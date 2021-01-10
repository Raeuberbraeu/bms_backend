package de.raeuberbraeu.bms.test.controller;

import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

import javax.annotation.PostConstruct;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import de.raeuberbraeu.bms.BMSApplication;
import io.restassured.RestAssured;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;

@SpringBootTest(classes = BMSApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredConfig {
	
	@LocalServerPort
	private int port;

	@PostConstruct
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
		RestAssured.config = newConfig().jsonConfig(jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL));
	}

}
