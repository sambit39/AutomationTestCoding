Feature: Book Flight

  Scenario: User can able to book flight by selecting departure city and destination city
    Given user is on flight search landing page
    When user selects departure city "Paris" and destination city "Buenos Aires" and clicks on find flights button
    Then different flights are displayed in the searched table based on the departure city "Paris" and destination city "Buenos Aires"
    When user choose any flight to proceed with booking
    Then payment page is displayed along with from "TLV" and to "SFO" flight details
    When user enters personal and payment details and clicks on purchase flight button
    Then payment confirmation page is displayed with confirmation id
#Scenario: User can not able to book flight if any of the personal and payment detail fields are blank
#Given user is on flight search landing page
#When user selects departure city and destination city and clicks on find flights button
#Then different flights are displayed in the searched table based on the departure city and destination city
#When user choose any flight to proceed with booking
#Then payment page is displayed along with flight details
#When user skips personal and payment details and clicks on purchase flight button
#Then payment confirmation page should not be displayed
#
#Scenario: User can able to verify the reserve flight details before proceeding to purchase flight
#Given user is on flight search landing page
#When user selects departure city and destination city and clicks on find flights button
#Then different flights are displayed in the searched table based on the departure city and destination city
#When user choose any flight to proceed with booking
#Then payment page is displayed along with reserved flight details as displayed in searched flight table
#
#Scenario: No two or more flights with same flight number are displayed in searched table 
#Given user is on flight search landing page
#When user selects departure city and destination city and clicks on find flights button
#Then flights are displayed in the searched table with unique flight number based on the departure city and destination city
#
#Scenario: No two or more flights with same airline carrier and same departure time and same arrival time are displayed in searched table 
#Given user is on flight search landing page
#When user selects departure city and destination city and clicks on find flights button
#Then no two or more flights with same airline carrier and same departure time and same arrival time are displayed in searched table
