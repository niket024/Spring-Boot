package com.nik;

import java.util.Arrays;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductServiceController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8090/products", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/template/publicuri")
	public ResponseEntity<String> getPublicApi() {
		return new ResponseEntity<String>(getPublicApiCall(), HttpStatus.OK);
	}

	@RequestMapping(value = "/template/products", method = RequestMethod.POST)
	public String createProducts(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:8090/products", HttpMethod.POST, entity, String.class).getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

		return restTemplate.exchange("http://localhost:8090/products/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);

		return restTemplate.exchange("http://localhost:8090/products/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
	
	public String getPublicApiCall() {
		final String uri = "https://reqres.in/api/users?page=2";
		// If you are accessing https url then you need to add following code to
		// RestTemplate
		CloseableHttpClient httpClient = HttpClients.custom()
				.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String response = restTemplate.getForObject(uri, String.class);
		System.out.println(response);
		return response;
	}
}