package com.makesystem.statusvenda;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makesystem.statusvenda.webservice.StatusVendaFeign;


@RestController
@RequestMapping("sale")
public class UpdateStatusVendaControle {
	
	@Autowired
	private StatusVendaFeign statusVendaFeing;
	
	private String apiKey = "DCF0AFC9-7C21-4F0C-837A-2DB3F56F147C";
	
	
	
	}
	

