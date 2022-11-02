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
Feature: ErrorHandling of Purchase Order from Ecommerce site
  I want to use this template for my feature file

  @ErrorValidation
  Scenario: Get Error Message when Login Failed
    Given I landed on ECommerce page 
    When Logeed in with <username> and <password>
    Then "Incorrect email or password." Error Message is displayed
    

    Examples: 
      | username 								  | password		 | productname  |
      | soumyadarshanee1@gmail.com | Shaktiman@11 | ZARA COAT 3  |