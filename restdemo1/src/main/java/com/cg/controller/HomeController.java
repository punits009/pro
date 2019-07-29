package com.cg.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Message;

@RestController
@RequestMapping("/test")
public class HomeController {
	
	@GetMapping(value="/",produces= {"application/json","application/xml"})
	public Message testGet()
	{
		return new Message("This is a get request");
	}
	@PostMapping(value="/",produces= {"application/json","application/xml"})
	public Message testPost()
	{
		return new Message("This is a post request");
	}
	@PutMapping(value="/",produces= {"application/xml"})
	public Message testPush()
	{
		return new Message("This is cut request");
	}
	@DeleteMapping(value="/",produces= {"application/json"})
	public Message testDelete()
	{
		return new Message("This is delete request");
	}
	
	

}
