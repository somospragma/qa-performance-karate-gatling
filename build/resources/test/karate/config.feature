Feature: Get configurations params

  Background:
    * def environment = karate.properties['karate.env'] || 'prod'
    * karate.log('Loading configuration for environment:', environment)

  Scenario: Get variables from karate config
    * karate.set('rampUsers', performance.rampUsers)
    * karate.set('during', performance.during)
    * karate.set('responseTimeMax', performance.thresholds.responseTimeMax)
    * karate.set('errorRateMax', performance.thresholds.errorRateMax)
    * karate.set('requestsPerSecMin', performance.thresholds.requestsPerSecMin)
    * karate.set('successfulRequestsMin', performance.thresholds.successfulRequestsMin)