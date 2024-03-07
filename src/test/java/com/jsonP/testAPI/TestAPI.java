package com.jsonP.testAPI;

import org.testng.annotations.Test;

import com.jsonP.testComponents.BaseTest;

import org.testng.Assert;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class TestAPI extends BaseTest {

    /**
     * Get comments with id=3 and verify response body’s “name” and email” values
     */     
    @Test
    public void testGETCommentsWithId3() {
        // Send GET request to retrieve comments with ID 3
        Response response = given().get("/comments/3");
        response.then().statusCode(200);

        // Print actual response
        System.out.println("Actual Response: " + response.getBody().asString());

        // Assert the "name" value in the response body
        Assert.assertEquals(response.jsonPath().getString("name"), "odio adipisci rerum aut animi");
        Assert.assertEquals(response.jsonPath().getString("email"), "Nikita@garfield.biz");
    }
    
    /**
     * Post comments with given JSON body and verify response body’s “id” value
     * 
     */    
    @Test
    public void testPostCommentsWithJsonBody() {
        // Send POST request to post comments with the specified JSON body
        String jsonBody = "{ \"postId\": 1, \"name\": \"Melissa\", \"email\": \"abc@gmail.com\" }";
        Response response = given().body(jsonBody).header("Content-Type", "application/json").post("/comments");
        response.then().statusCode(201);

        // Print actual response
        System.out.println("Actual Response: " + response.getBody().asString());

        // Assert the "id" in the response body
        Assert.assertEquals(response.jsonPath().getInt("id"), 501); // Replace with the expected value
    }

    /**
     * Get users with id=6 and verify response body’s “street” and “city” values
     */  
    @Test
    public void testGETUsersWithId6() {
        // Send GET request to retrieve users with ID 6
        Response response = given().get("/users/6");
        response.then().statusCode(200);

        // Print actual response
        System.out.println("Actual Response: " + response.getBody().asString());

        // Assert the presence of "address.street" and "address.city" in the response body
        Assert.assertEquals(response.jsonPath().getString("address.street"), "Norberto Crossing"); // Replace with the expected value
        Assert.assertEquals(response.jsonPath().getString("address.city"), "South Christy"); // Replace with the expected value
    }
}

