@BookHotel
Feature: Verifying OMRBranch Book Hotel page automation

  Background: 
    Given User is on the OMR Branch hotel page

  @BookHotel1
  Scenario Outline: Book Hotel W/O including GST and W/O special request and card details(credit card-visa)
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User select the first hotel and save the hotel name
    Then User should verify success message after Select hotel "Book Hotel"
    When User enters the Guest details "<Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User select should enter the payment details, proceed with card type
      | cardType    | card | cardNumber       | nameOnCard | month   | year | cvv |  |
      | Credit Card | Visa | 5555555555552223 | siva       | January | 2027 | 123 |  |
      | Credit Card | Amex | 5555555555552223 | siva       | January | 2027 | 123 |  |
    Then User should verify after booking success message "Booking is Confirmed" and save the order id
    And User should verify booked Hotel name

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child | Salutation | First Name | Last Name | Mobile No. | Email    | card type   |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 | Mr.        | Siva       | D         | 2145782145 | siva@123 | Credit card |

  @BookHotel2
  Scenario Outline: Enter invalid UPI id and verify error message
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User select the first hotel and save the hotel name
    Then User should verify success message after Select hotel "Book Hotel"
    When User enters the Guest details "<Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    When User enter UPI id "<UPI ID>"
    Then User should verify UPI id error message "Invalid UPI ID"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child | Salutation | First Name | Last Name | Mobile No. | Email    | UPI ID   |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 | Mr.        | Siva       | D         | 2145782145 | siva@123 | siva@ybl |

  @BookHotel3
  Scenario Outline: Enter invalid card details and Verify error message
    When User login "<username>" and "<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"
    And user enters "<state>","<city>","<roomType>","<checkIn>","<checkOut>","<rooms>","<adults>" and "<child>"
    Then User should verify success message after Explore hotel "Select Hotel"
    When User select the first hotel and save the hotel name
    Then User should verify success message after Select hotel "Book Hotel"
    When User enters the Guest details "<Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User select should enter the payment details, proceed with card type
      | cardType    | card | cardNumber       | nameOnCard | month   | year | cvv |
      | Credit Card | Visa | 5555555555552228 | siva       | January | 2027 | 123 |
      | Credit Card | Amex | 5555555555552223 | siva       | January | 2027 | 123 |
    Then User should verify invalid card details error message "Invalid Card Details"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child | Salutation | First Name | Last Name | Mobile No. | Email    | card type   |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-04-24 | 2023-04-25 | 1-One | 1-One  |     2 | Mr.        | Siva       | D         | 2145782145 | siva@123 | Credit Card |
