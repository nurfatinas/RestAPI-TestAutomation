package stepsDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TypiCodeScripts {

	private Response response;

    @Given("the API endpoint for retrieving comments")
    public void setApiEndpointForComments() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Given("the API endpoint for posting comments")
    public void setApiEndpointForPostingComments() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Given("the API endpoint for retrieving users")
    public void setApiEndpointForUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("a GET request is made for comments with ID {int}")
    public void getRequestForCommentsWithId(int commentId) {
        response = given().get("/comments/" + commentId);
    }

    @When("a POST request is made with the specified JSON body")
    public void postRequestWithJsonBody() {
        String jsonBody = "{ \"postId\": 1, \"name\": \"Melissa\", \"email\": \"abc@gmail.com\" }";
        response = given().body(jsonBody).header("Content-Type", "application/json").post("/comments");
    }

    @When("a GET request is made for users with ID {int}")
    public void getRequestForUsersWithId(int userId) {
        response = given().get("/users/" + userId);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response body should contain the correct \"name\" and \"email\" values")
    public void verifyNameAndEmailValues() {
        assertEquals(response.jsonPath().getString("name"), "odio adipisci rerum aut animi");
        assertEquals(response.jsonPath().getString("email"), "Nikita@garfield.biz");
    }

    @Then("the response body should contain the correct \"id\" value")
    public void verifyIdValue() {
        int actualId = response.jsonPath().getInt("id");
        // You need to dynamically get the actual ID from the response or use a fixed expected value.
        // For illustration, assuming the expected value is 101.
        assertEquals(actualId, 501);
    }

    @Then("the response body should contain the correct \"address.street\" and \"address.city\" values")
    public void verifyAddressValues() {
        assertEquals(response.jsonPath().getString("address.street"), "Norberto Crossing");
        assertEquals(response.jsonPath().getString("address.city"), "South Christy");
    }
}
