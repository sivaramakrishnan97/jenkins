@ExploreHotel
Feature: Verifying OMR Branch Explore Hotels page Automation

  Background: 
    Given User is on the OMR Branch hotel page
@ExploreHotel11
  Scenario Outline: Enter all field and verify select hotel
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-05-28 | 2023-05-30 | 1-One | 1-One  |     1 |

@ExploreHotel22
  Scenario Outline: Select multiple room type and verify same filter in header
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    When user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    Then User should verify success message selected room type is present  "<roomType>"

    Examples: 
      | username                | password        | state      | city    | roomType            | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe/Suite/Studio | 2023-04-28 | 2023-04-30 | 1-One | 1-One  |     2 |

@ExploreHotel33
  Scenario Outline: Verify hotel name ends with selected room type
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    When user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    Then User should verify each hotel name ends with selected room type "<roomType>"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-28 | 2023-04-30 | 1-One | 1-One  |     2 |

@ExploreHotel44
  Scenario Outline: Without Entering any fields and verify error messages
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    When user click search button without entering any fields
    Then User should verify  error messages in explore hotel page "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | username                | password        |
      | sivaraman.drs@gmail.com | 9677569677@Siva |
