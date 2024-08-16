@AdminFeature
Feature: Admin Feature

  Background: : User Login With Valid Credential
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login
    Then User Navigate To Homepage Menu

    Scenario: User Add New Job Title
      Given User In On Admin Page
      And User Click Job
      When Click Add In Job Titles
      And User Fill Job Title
      And User Fill Job Description
      And User Fill Job Specification
      And User Fill Note
      And User Click Save
      Then User Success To Add New Job Title


    Scenario: User Delete Job Title
      Given User In On Admin Page
      And User Click Job
      When User Click Delete Job titles
      And Click Delete
      Then User Success To Delete Job Title



