Feature: Validating Place APIs

  @AddPlace @Regression
  Scenario Outline: Verify if place is being added using AddPlaceAPI
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with staus 200
    And "status" in response is "OK"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name                | language | address            |
      | welcome to my House | English  | world cross center |

  # | Djebba              | ARABIC   | Thibar Tunisie     |
  @DeletePlace @Regression
  Scenario: Verify if the Delete functionnality is Working
    Given DeletePlace Payload
    When user calls "deletePlaceAPI" with "POST" http request
    Then the API call is success with staus 200
    And "status" in response is "OK"
