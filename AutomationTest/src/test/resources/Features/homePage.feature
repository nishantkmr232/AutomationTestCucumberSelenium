Feature: Feature to verify J.P Morgan home page Logo

  Scenario Outline: Validate J.P Morgan logo is displayed on home page
    Given Web Browser is open
    And User is on google search page
    When User enters a search text as <SearchText>
    And User hits enter after entering search Text
    Then User is navigated to results page
    When User click on first link displayed from results
    Then User navigated to J.P Morgan Home Page and J.P morgan Logo is displayed

    Examples: 
      | SearchText   |
      | J. P. Morgan |
