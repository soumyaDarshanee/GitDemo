#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature:Purchase the Order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on ECommerce page 

  @Regression
  Scenario: Positive Test of Submitting the Order
    Given Logeed in with <username> and <password>
    When I add <productname> to cart
    And Checkout <productname> is added to the cart and submit the order
    Then I validate the "THANKYOU FOR THE ORDER." message is displayed
    

    Examples: 
      | username 								  | password		 | productname  |
      | soumyadarshanee@gmail.com | Shaktiman@11 | ZARA COAT 3  |
     
