package com.sumanth.template.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class URLStatusService {
	
	
	@Autowired
	private RestTemplate template;
	
	
	public Map<String,String> getStatusOfURL(List<String> urls) {
		
		Map<String,String> statusMap = new HashMap<>();
		urls.forEach(url->{
			
			System.out.println(url);
		});
		
		urls.parallelStream().forEach(url->{
			ResponseEntity response = template.getForEntity(url,String.class);
			if(response.getStatusCode()==HttpStatus.OK) {
			statusMap.put(url, "Success");
			} else if(response.getStatusCode()==HttpStatus.FORBIDDEN) {
		    statusMap.put(url, "Forbidden");
			}
		});
		
		
		return statusMap;
		
		
	}

}
