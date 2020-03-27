package com.sumanth.template.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.template.service.URLStatusService;

@RestController
public class URLController {
	
	@Autowired
	private URLStatusService urlStatusService;
	
	
	@GetMapping("/getStatus")
	public Map<String, String> getStatus(@RequestBody List<String> urls){
		
		Map<String,String> statusCheckMap = new HashMap<>();
		
		statusCheckMap = urlStatusService.getStatusOfURL(urls);
		
		
		return statusCheckMap;
		
	}

}
