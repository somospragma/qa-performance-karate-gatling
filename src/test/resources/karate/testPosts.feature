Feature: As a quality analyst,
  I need to consult the posts registered
  in the system to validate their existence.

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  @posts
  Scenario: get posts

    Given path '/posts'
    When method get
    Then status 200

  @postComments
  Scenario: get posts comments

    Given path '/posts/1/comments'
    When method get
    Then status 200