Feature: login

  Scenario: Successful login
    Given Open the url of the application (url: "https://www.demoblaze.com/")
    When Click on the Log in option
    And Enter username and password (username: "manishkumar1990" , password: "manish")
    And Click on the Log in button
    Then Validate the welcome user message