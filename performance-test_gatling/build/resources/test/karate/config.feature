Feature: Get configurations params

  Scenario: Get variables from karate config
    * def config = karate.callSingle('classpath:karate-config.js')
    * karate.set('result',config)