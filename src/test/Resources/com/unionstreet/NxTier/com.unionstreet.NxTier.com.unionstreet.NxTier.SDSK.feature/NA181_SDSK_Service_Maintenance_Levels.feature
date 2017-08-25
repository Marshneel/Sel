@SDSK
Feature: NA181 SDSK Service Maintenance Levels
#  Scenario: Service maintenance levels should be unavailable for virtual lines
#    Given I am logged in as AdamR
#    And I raise an open reach incident on an either of the virtual line
#    Then The service maintenance levels should be un-available for virtualLines
#
#  Scenario: agent should not be able to alter the service maintenance levels
#    Given I am logged in as agentAdam
#    When I raise an open reach incident on an analogue line
#    Then The service maintenance levels dropdown should be un-available for selection
#
#  Scenario: service maintenance levels should be unavailable for ISDN30 when the care level plan is 2
#    Given I am logged in as AdamR
#    When I raise an open reach incident on an ISDN 30 line with care level plan 2
#    Then A validation message stating the unavailability of service maintenance levels should be thrown
#
#  Scenario Outline: verify service maintenance levels is available for the lines below
#    Given I am logged in as AdamR
#    When I raise an open reach incident on "<line>" with "<type>", "<numberOfLines>" and "<maintenanceLevel>"
#   Then The service maintenance levels should be available
#
#    Examples:
#      | line      | type 			   | numberOfLines | maintenanceLevel |
#      |01202300909| PSTN Multi Line Aux| 	2	       | 	2             |
#      |01202300920| WLR3 ISDN 2e System| 	2	       |  	2             |

  Scenario: validate service maintenance levels from low to high
    Given I am logged in as AdamR
    When I raise an open reach incident on a line that has care level 2
    Then The service time should drop basing on the plan i choose

