#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Given: Some precondition step
#Then: To observe outcomes or validation
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios

Feature: RCBTest feature
  I want to use this template for my feature file
  
  Background:
		Given Json file contains RCB team details is loaded

  #@test1
  Scenario Outline: Validate if the team has only 4 foreign players    
    Then Team should have only x <Number_of_Foreign_Players> foreign players
Examples:
|Number_of_Foreign_Players|
|4|


  #@test2
  Scenario Outline: To validate if the team has at least one wicket player
    Then Team should have at least y <Number_of_Wicket_Players> wicket players
Examples:
|Number_of_Wicket_Players|
|1|
