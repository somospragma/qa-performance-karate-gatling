Feature: Credit cards Payments

  Background:
    * url urlBase
    * configure headers = read('../jsonrequest/headersPay.json')
    * def datareq = read('../jsonrequest/pay.json')
    * def auth = karate.callSingle('authentication.feature@SuccessUser')
    * def sessionId = auth.response.data[0].attributes.param.sessionDataRS.sessionId
    * header session-tracker = sessionId

  @PayTdc
  Scenario: Query with data and path correct payment with dollars and current account
    * set datareq.data.customerCard.currency = 'USD'
    * set datareq.data.customerCard.amount = 1.01
    * set datareq.data.customerCard.number = '0377815155107143'
    * header transaction-code = "0429"
    * header document-number = "989989251"
    * header document-type = "CC"
    Given path '/api/v1/cards/pay'
    And request datareq
    When method POST
    Then status 200

