@LoginFeature
Feature: Login Feature

  Scenario: User Login With Valid Credential
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login
    Then User Navigate To Homepage Menu


  Scenario Outline: User Login With Invalid Credential
    Given User In On Login Page
    When User Enters <username> and <password>
    And User Click Login
    Then User Should Get Error Message In Login Page

    Examples:
      | username  | password  |
      | Admin     | adminnn   |


  Scenario Outline: User Login Without Input Username and Password
    Given User In On Login Page
    When User Enters <username> and <password>
    And User Click Login
    Then User Should Get Error Message Required Username and Password In Login Page

    Examples:
      | username    | password |
      | Admin       | [empty]  |
      | [empty]     | adminnn  |
      | [empty]     | [empty]  |