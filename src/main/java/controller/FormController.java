package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Form;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path = "/data")
public class FormController {

	@PostMapping(path= "/postData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createData(@RequestBody Form formObj) {
		System.out.println(formObj.toString());
		return null;
		
	}
}