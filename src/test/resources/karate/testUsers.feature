Feature: as a quality analyst,
  I need to consult the users registered
  in the system to validate their existence.

  Background:
    * url 'https://jsonplaceholder.typicode.com'
    * path '/users'

  @users
  @getUsers
  Scenario: Consult users registered in the system

    When method get
    Then status 200
