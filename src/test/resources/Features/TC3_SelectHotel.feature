@SelectHotel
Feature: Verifying OMR Branch Select Hotel page Automation

  Background: 
    Given User is on the OMR Branch hotel page

  @SelectHotel1
  Scenario Outline: Verifying Select hotel and navigate to book hotel upon accepting the alerts
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User select the first hotel and save the hotel name
    Then User should verify success message after Select hotel "Book Hotel"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 |

  @SelectHotel2
  Scenario Outline: Verifying Select hotel and navigate in the same page upon dismiss the alert
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User select the first hotel name and dismiss the alert
    Then User should remain in same page and verify success message in select hotel "Select Hotel"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 |

  @SelectHotel3
  Scenario Outline: verifing Sort Name Ascending
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User click the sort by name ascending
    Then User should verify hotel names are displayed in ascending order

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 |

  @SelectHotel4
  Scenario Outline: Unselecting all room types and verify listing all the hotels
     When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User unselect room type
    Then User should verify all hotel names should be displayed

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms   | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 3-Three | 5-Five |     2 |
