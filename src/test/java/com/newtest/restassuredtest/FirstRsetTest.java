package com.newtest.restassuredtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstRsetTest {
	
	@Test
	public void  getRequest() {
		String url="https://reqres.in/api/users?page=2";
		
		Response response=RestAssured.get(url);
		
		Assert.assertEquals(response.getStatusCode(), 200,"response code mismatch");
		
		int total_pages=response.jsonPath().getInt("total_pages");
		
		Assert.assertEquals(total_pages, 2, "pages number mismatched");
	}
	
	@Test
	public void postApiRequest() {
		String url="https://reqres.in/api/users";
		String content_type="application/json";
		String body_data="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		Response response=RestAssured.given().contentType(content_type).body(body_data).when().post(url).then().extract().response();
		Assert.assertEquals(response.getStatusCode(), 201,"response code mismatch");
		String name=response.jsonPath().getString("name");
		Assert.assertEquals(name, "morpheus", "name mismatched");
	}
	
}
