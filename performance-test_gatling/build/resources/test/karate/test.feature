Feature: test

  Scenario: make a simple test
    * def body =
    """
    {
      "email": "eve.holt@reqres.in",
      "password": "cityslicka"
    }
    """
    Given url 'https://reqres.in'
    And path '/api/login'
    When request body
    And method post
    Then status 200