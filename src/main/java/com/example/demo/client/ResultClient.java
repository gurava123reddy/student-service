package com.example.demo.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Result;

@Component
public class ResultClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void saveResult(List<Result> results, Integer studentId) {
		
		results.stream().forEach(
				result -> {
					result.setStudentId(studentId);
					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					HttpEntity<Result> httpEntity = new HttpEntity<Result>(result, httpHeaders);
					
					restTemplate.exchange("http://localhost:4040/result-service", HttpMethod.POST, httpEntity, String.class);
				});
	}

}
