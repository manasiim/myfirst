Feature: Food Delivery

  Scenario Outline: login
    Given User open chrome browser
    When user enter <URL> to open Website
    Then User visit to the URL

    Examples: 
      | URL                     |
      | https://www.swiggy.com/ |
