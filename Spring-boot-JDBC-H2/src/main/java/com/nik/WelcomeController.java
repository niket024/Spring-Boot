package com.nik;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nik.exception.DBOperationFailedException;

@Controller
public class WelcomeController {
	private static Logger logger = Logger.getLogger(WelcomeController.class);

	@Autowired
	private PersonDAO personDAO;
	@Value("${welcome.message}")
	String msg;

	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public ModelAndView welcome(Map<String, Object> model) {
		logger.info("Fetching the person list");
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("message", msg);
		Iterable<Person> all = personDAO.findAll();
		logger.debug("Received the person details");
		List<Person> persons = new ArrayList<Person>();
		for (Person person : all) {
			persons.add(person);
		}
		logger.debug("prepared the the person list "+ persons);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("persons", persons);
		mav.addObject("data", jsonObj);
		return mav;
	}

	@ResponseBody
	@RequestMapping("/getName")
	public String index() {
		Iterable<Person> all = personDAO.findAll();

		StringBuilder sb = new StringBuilder();

		all.forEach(p -> sb.append(p.getFullName() + "<br>"));
		System.out.println(sb.toString());
		return sb.toString();
	}

	@RequestMapping("/create")
	public String create(Map<String, Object> map) {
		Person person = new Person();
		map.put("person", person);
		return "person";
	}

	@RequestMapping(value = "/delete")
	public String delete(Map<String, Object> map) {
		Person person = new Person();
		map.put("person", person);
		return "delete";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("id") Long id) {
		System.out.println("id " + id);
		ModelAndView mav = new ModelAndView("welcome");
		personDAO.delete(id);
		mav.addObject("message", "I am from H2 database");
		Iterable<Person> all = personDAO.findAll();
		List<Person> persons = new ArrayList<Person>();
		for (Person person1 : all) {
			persons.add(person1);
		}
		logger.info("list of person = " + persons);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("persons", persons);
		mav.addObject("data", jsonObj);
		return mav;
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute Person person, BindingResult result, Map<String, Object> map) {
		try {
			System.out.println(person.getFullName());
			System.out.println(person.getDateOfBirth());
			personDAO.save(person);
			ModelAndView mav = new ModelAndView("welcome");
			mav.addObject("message", msg);
			Iterable<Person> all = personDAO.findAll();
			List<Person> persons = new ArrayList<Person>();
			for (Person person1 : all) {
				persons.add(person1);
			}
			logger.info("list of person = " + persons);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("persons", persons);
			mav.addObject("data", jsonObj);
			return mav;
		} catch (Exception ex) {
			String errorMsg = "Exception while saving the person" + ex;
			logger.error(errorMsg);
			throw new DBOperationFailedException(errorMsg);
		}
	}
}