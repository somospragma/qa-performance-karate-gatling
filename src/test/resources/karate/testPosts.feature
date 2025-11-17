Feature: As a quality analyst,
  I need to consult the posts registered
  in the system to validate their existence.

  Background:
    * url urlBase

  @posts
  Scenario: get posts

    Given path endpoints.posts
    When method get
    Then status 200

  @postComments
  Scenario: get posts comments

    Given path endpoints.comments
    When method get
    Then status 200