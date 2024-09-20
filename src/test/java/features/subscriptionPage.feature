Feature: Subsrciption Page

  Scenario Outline: Validate subscription package
    Given I am on the subscription page
    When I select "<Country>"
    Then the lite subscription price should be "<litePrice>"
    And the classic subscription price should be "<classicPrice>"
    And the premium subscription price should be "<premiumPrice>"

  Examples:
     | Country     |     litePrice | classicPrice | premiumPrice |
     | Egypt       |       0.25    |      0.5     |      1       |
     | Palestine   |       2.4     |      4.8     |     7.2      |
     | Iraq        |       2.4     |      4.1     |     6.2      |