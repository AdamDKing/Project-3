package com.project3.controllers;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.project3.models.Associate;
import com.project3.services.AssociateService;


@RestController
@RequestMapping(path="/associates")
public class AssociateController {
	@Autowired
	AssociateService associateService;
	
	@GetMapping
	public List<Associate> getAssociates() {
		
		return associateService.getAllAssociates();
	}
	
	@PostMapping  
	public void updateAssociateBatch (@RequestBody Integer associateId, @RequestBody Integer assignedBatchId) {
		associateService.updateAssociateBatch(associateId, assignedBatchId);
	}
	
}
