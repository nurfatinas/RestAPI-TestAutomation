Feature: API Tests for Comments and Users

  Scenario: Retrieve comments with ID 3
    Given the API endpoint for retrieving comments
    When a GET request is made for comments with ID 3
    Then the response status code should be 200
    And the response body should contain the correct "name" and "email" values
   
  Scenario: Post comments with JSON body
    Given the API endpoint for posting comments
    When a POST request is made with the specified JSON body
    Then the response status code should be 201
    And the response body should contain the correct "id" value

  Scenario: Retrieve users with ID 6
    Given the API endpoint for retrieving users
    When a GET request is made for users with ID 6
    Then the response status code should be 200
    And the response body should contain the correct "address.street" and "address.city" values

