package es.dario.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dario.bootcamp.interfaces.MessageServiceImpl;


@RestController
@RequestMapping(value = "/api/v1")
public class MessageRestController {
	
	@Autowired
	private MessageServiceImpl service;
	
	@GetMapping("/message")
	public String holaMundo() {
		return service.getMessage();
	}
}
