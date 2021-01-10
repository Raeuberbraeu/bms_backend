package de.raeuberbraeu.bms.test.utils;

import org.springframework.http.HttpStatus;

import io.restassured.response.Response;

public class ControllerTestUtils {

	public static void basicCheckOfResponse(Response response, HttpStatus httpStatus) {
		response.then().assertThat().statusCode(httpStatus.value());
		response.then().assertThat().header("Content-Type", "application/json");
	}

}
