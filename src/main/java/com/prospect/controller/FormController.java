package com.prospect.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.prospect.business.WolframData;
import com.prospect.model.Form;
import com.prospect.model.Metrics;
import com.prospect.repository.MetricsRepository;

/*@CrossOrigin(origins = "https://insurance-prospect-ui.cfapps.io/", maxAge = 3600)*/
@RestController
@RequestMapping(path = "/data")
public class FormController {

	@Autowired
	WolframData data;

	@Autowired
	MetricsRepository repository;

	@RequestMapping(value = "insurance-prospect-ui.cfapps.io/**", method = RequestMethod.OPTIONS)
	public void corsHeaders(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
		response.addHeader("Access-Control-Max-Age", "3600");
	}

	@CrossOrigin
	@PostMapping(path = "/postData", consumes = "application/json", produces = "application/json")
	public Form createData(@RequestBody Form formObj) {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = Obj.writeValueAsString(formObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);
		String resp = data.formulateData(formObj);
		formObj.setResponse(resp);
		return formObj;
	}

	@CrossOrigin
	@GetMapping(path = "/getAllUsers", produces = "application/json")
	public ResponseEntity<List<Metrics>> getAllUsers() {
		List<Metrics> users = repository.findAll();
		return ResponseEntity.ok().header("total", Integer.toString(users.size())).body(users);
	}

	@CrossOrigin
	@RequestMapping(value = "/file", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String handleFileUpload(@RequestPart("file") MultipartFile file) {
		String message = "";
		try {

			List<Form> userData = Poiji.fromExcel(file.getInputStream(), PoijiExcelType.XLSX, Form.class);
			for (Form eachUser : userData) {
				message = data.formulateData(eachUser);
			}
			return message;
		} catch (Exception e) {
			return message = "FAIL to upload " + file.getOriginalFilename() + "!";
		}
	}

}