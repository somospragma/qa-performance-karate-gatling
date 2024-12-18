Feature: example

  Scenario Outline: get specif data values using examples
    Given want to obtain data with <id> and <description>
    When apply <data>
    Then see <result>
    Examples:
      | id | description | data | result |
    ##@externalData@acceptance_test@feature_cases
      |    |            |      |        |
    ##@externalData@acceptance_test@feature_cases_1
      |    |            |      |        |


  Scenario: get specific data value using simple scenario
    Given want to obtain data
    ##@externalData@acceptance_test@CP001@description
    When put the spected data like "value1"
    ##@externalData@acceptance_test@CP001@numero
    Then result is "value2"

  Scenario: get specific data value using simple scenario and multiples values
    Given want to obtain data
    ##@externalData@acceptance_test@feature_cases@data@id
    When put the spected data like "value1,value2"
    ##@externalData@acceptance_test@feature_cases@data@id@result
    Then result is "value3,value4,value5"

