package com.example.microservicioCircuitBreakerMicrometerClient.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.microservicioCircuitBreakerMicrometerClient.entities.Coche;

import netscape.javascript.JSObject;


public class StatusService {
	
	Logger logger = LoggerFactory.getLogger(StatusService.class);
	
	RestTemplate restTemplate = new RestTemplate();
	
	String URL = "http://localhost:8080/";
	
	Coche coche;
	
	public StatusService() throws URISyntaxException
	{
		coche = new Coche();
		coche.setMarca("seat");
		
		close();
	}
	
	public void open() throws URISyntaxException
	{
		String urlOpen
		  = URL + "actuator/status/open";
		coche.setStatus("OPEN");
		URI uri = new URI(urlOpen);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(uri,coche ,String.class);
		logger.info("Estado open");
		
	}
	public void close() throws URISyntaxException
	{
		String urlClose
		  = URL + "actuator/status/close";
		coche.setStatus("CLOSE");
		URI uri = new URI(urlClose);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(urlClose,coche ,String.class);
		logger.info("Estado close");
	}
	public void halfOpen() throws URISyntaxException
	{
		String urlHalf
		  = URL + "actuator/status/halfopen";
		coche.setStatus("HALF-OPEN");
		URI uri = new URI(urlHalf);
		ResponseEntity<String> response
		  = restTemplate.postForEntity(urlHalf,coche ,String.class);
		logger.info("Estado half-open");
	}

}
