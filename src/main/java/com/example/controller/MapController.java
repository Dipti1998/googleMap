package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MapService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class MapController {
	
	@Autowired
	private MapService mapServiceObj;
	
	@PostMapping(value = "/Address/{latitude}/{langitude}")
	public ResponseEntity<String> getAddress(@PathVariable double latitude,@PathVariable double langitude){
		System.out.println("controller");
		return new ResponseEntity<String>(mapServiceObj.getAddress(latitude,langitude),HttpStatus.OK);
	}
	
	
}