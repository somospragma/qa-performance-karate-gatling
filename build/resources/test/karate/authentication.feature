
Feature: Authentication

  Background:
    * url urlBaseAuth
    * def UuidFormat = Java.type("utils.UuidFormat")
    * def message = new UuidFormat()
    * def tracker = new UuidFormat()
    * def device = new UuidFormat()

  @SuccessUser
  Scenario: Authentication
    * def header = karate.read('../jsonrequest/headers_auth.json')
    * def dataReq = karate.read('../jsonrequest/auth.json')
    * set header.session-tracker = tracker.formatMessage()
    * configure headers = header
    Given path '/api/v1/auth/auth'
    And request dataReq
    When method post
    Then status 200












