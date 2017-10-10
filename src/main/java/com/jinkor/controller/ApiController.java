package com.jinkor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiController {

	@RequestMapping
//	细粒度控制
//	@CrossOrigin(origins="http://localhost:8081")
	public String api() {
		return  "api";
	}
}

