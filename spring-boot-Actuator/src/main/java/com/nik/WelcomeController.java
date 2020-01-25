package com.nik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	private static Logger logger = Logger.getLogger(WelcomeController.class);

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@RequestMapping("/index")
	public ModelAndView welcome(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("message", this.message);
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		list.add("aaaa");
		logger.info("All data in list" + list);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("cource", list);
		mav.addObject("data", map);
		return mav;
	}
	
	
}