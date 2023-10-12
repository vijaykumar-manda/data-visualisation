package com.data_dashboard.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data_dashboard.Service.DataService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
	private final DataService dataService;

	public Controller(DataService dataService) {
		this.dataService = dataService;
	}

	@GetMapping("/intensity-count")
	public List<Object[]> getIntesityCount() {
		List<Object[]> result = dataService.getIntensityCount();
		return result;
	}
	@GetMapping("/likelihood-count")
	public List<Object[]> getLikelihoodCount() {
		List<Object[]> result = dataService.getLikelihoodCount();
		return result;
	}

}
