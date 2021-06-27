package com.raghul.expensetracker.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.raghul.expensetracker.service.MiscService;

@RestController
@RequestMapping("/api/misc")
public class MiscController {
	
	@Resource
	private MiscService miscService;
	
	@GetMapping("/build")
	public ResponseEntity<?> build() throws JsonParseException, JsonMappingException, IOException{
		
		miscService.build();
	
		return ResponseEntity.ok().build();
	}

}
