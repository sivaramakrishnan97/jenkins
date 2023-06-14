@ChangeBooking
Feature: Verify OMR Branch Change Booking page Automation

  Scenario Outline: To validate booked hotel by change the booking and verify success message
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
      | Credit Card | Amex | 5555555555552224 | siva       | January | 2027 | 123 |  |
    Then User should verify after booking success message "Booking is Confirmed" and save the order id
    And User navigate to my booking and enter order Id
    Then User should verify the Order Id and Hotel Name
    When User edit booking "<Update Date>"
    Then User should verify after Edit Booking success message "Booking updated successfully"

    Examples: 
      | username                | password        | state      | city    | roomType | checkIn    | checkOut   | rooms | adults | child | Salutation | First Name | Last Name | Mobile No. | Email    | card type   | Update Date |
      | sivaraman.drs@gmail.com | 9677569677@Siva | Tamil Nadu | Chennai | Deluxe   | 2023-05-24 | 2023-05-25 | 1-One | 1-One  |     2 | Mr.        | Siva       | D         | 2145782145 | siva@123 | Credit card | 2023-05-29  |
