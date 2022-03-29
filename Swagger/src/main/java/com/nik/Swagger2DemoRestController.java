package com.nik;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.util.Json;
import io.swagger.util.Yaml;

@SwaggerDefinition(tags = { @Tag(name = "Demo", description = "Demo for Swagger") })
@RestController
public class Swagger2DemoRestController {

	List<Student> students = new ArrayList<Student>();
	{
		students.add(new Student("Sajal", "IV", "India"));
		students.add(new Student("Lokesh", "V", "India"));
		students.add(new Student("Kajal", "III", "USA"));
		students.add(new Student("Sukesh", "VI", "USA"));
	}

	@ApiOperation(value = "Get all students")
	@RequestMapping(value = "/getStudents")
	public List<Student> getStudents() {
		return students;
	}

	@ApiOperation(value = "Get students by name")
	@RequestMapping(value = "/getStudent/{name}")
	public Student getStudent(@PathVariable(value = "name") String name) {
		List<Student> students = new ArrayList<>();
		students = this.students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if (students.size() > 0) {
			return students.get(0);
		} else {
			return new Student();
		}
	}

	@ApiOperation(value = "Get students by country")
	@RequestMapping(value = "/getStudentByCountry/{country}")
	public List<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
		System.out.println("Searching Student in country : " + country);
		List<Student> studentsByCountry = students.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
		System.out.println(studentsByCountry);
		return studentsByCountry;
	}

	@ApiOperation(value = "Get students by class")
	@RequestMapping(value = "/getStudentByClass/{cls}")
	public List<Student> getStudentByClass(@PathVariable(value = "cls") String cls) {
		return students.stream().filter(x -> x.getCls().equalsIgnoreCase(cls)).collect(Collectors.toList());
	}

	@GetMapping(value = "/getYaml")
	public String getYaml() {

		String finalResult = "";
		final String URI = "http://localhost:8090/v2/api-docs";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URI, String.class);
		try {
			finalResult = Yaml.pretty().writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return finalResult;
	}

	@RequestMapping(value = "import", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity uploadZipFile(@RequestPart MultipartFile file, 
			@RequestParam(value = "test") String test, @RequestParam(value = "name") String name)
			throws IllegalStateException, IOException {
		System.out.println("File name = " + file.getOriginalFilename());
		System.out.println("data = " + test);
		System.out.println("name = " + name);
		File file2 = new File("C:\\Niket");
		File newFile = new File(file2.getAbsoluteFile() + File.separator + file.getOriginalFilename());
		file.transferTo(newFile);
		return new ResponseEntity<>("FIle uploade successfully", HttpStatus.OK);
	}

}
