package com.prospect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prospect.business.WolframData;
import com.prospect.model.Form;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/data")
public class FormController {
	
	@Autowired
	WolframData dataVal;
	

	@PostMapping(path= "/postData", consumes = "application/json", produces = "application/json")
	public String createData(@RequestBody Form formObj) {
		//System.out.println(formObj.toString());
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr ="";
		try {
			jsonStr = Obj.writeValueAsString(formObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);
		return dataVal.formulateData(formObj);
		
	}
}