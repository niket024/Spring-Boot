package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Welcome {

	@RequestMapping("/")
	public String hello() {
		return "hello to all";
	}

	@RequestMapping("/json")
	public ResponseEntity<Object> getJsonData(Map<String, Object> model) {
		JSONParser jsonParser = new JSONParser(getPublicApi());
		LinkedHashMap<?, ?> hashMap = null;
		try {
			hashMap = (LinkedHashMap<?, ?>) jsonParser.parse();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(hashMap, HttpStatus.OK);
	}

	public String getPublicApi() {
		final String uri = "https://reqres.in/api/users?page=2";
		// If you are accessing https url then you need to add following code to
		// RestTemplate
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String response = restTemplate.getForObject(uri, String.class);
		System.out.println(response);
		return response;
	}
}
