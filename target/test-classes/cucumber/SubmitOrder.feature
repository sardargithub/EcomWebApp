@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given landed on Ecommerce page

  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product to Cart
    And Checkout and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the Confirmation page

    Examples: 
      | name  								 | password         |
      | johnsmith123@gmail.com | Test@123     	  |
   
