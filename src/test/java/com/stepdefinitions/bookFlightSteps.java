package com.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.FlightBookingConfirmationPage;
import com.pages.PersonalAndPaymentDetailsPage;
import com.pages.SearchFlightLandingPage;
import com.pages.SearchedFlightTablePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bookFlightSteps {
	public WebDriver driver;
	public SearchFlightLandingPage searchflight;
	public SearchedFlightTablePage searchedFlightTable;
	public PersonalAndPaymentDetailsPage personalAndPaymentDetails;
	public FlightBookingConfirmationPage flightBookingConfirm;

	@Given("user is on flight search landing page")
	public void user_is_on_flight_search_landing_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		searchflight = new SearchFlightLandingPage(driver);
		driver.get("http://blazedemo.com/");

		String landingPageTitle = driver.getTitle();
		Assert.assertEquals(landingPageTitle, "BlazeDemo");

	}

	@When("user selects departure city {string} and destination city {string} and clicks on find flights button")
	public void user_selects_departure_city_and_destination_city_and_clicks_on_find_flights_button(String fromCity,
			String toCity) {
		searchflight.searchFlights(fromCity, toCity);
	}

	@Then("different flights are displayed in the searched table based on the departure city {string} and destination city {string}")
	public void different_flights_are_displayed_in_the_searched_table_based_on_the_departure_city_and_destination_city(
			String fromCity, String toCity) {
		searchedFlightTable.verifyHeaderText(searchedFlightTable.headerText, fromCity, toCity);
		searchedFlightTable.verifySearchedFlightTableIsNotEmpty();
	}

	@When("user choose any flight to proceed with booking")
	public void user_choose_any_flight_to_proceed_with_booking() {
		searchedFlightTable.selectAnySearchedFlight();
	}

	@Then("payment page is displayed along with from {string} and to {string} flight details")
	public void payment_page_is_displayed_along_with_flight_details(String fromCityIATACode, String toCityIATACode) {
		personalAndPaymentDetails.verifyPaymentPageHeaderText(personalAndPaymentDetails.reservedFlightHeaderText,
				fromCityIATACode, toCityIATACode);
	}

	@When("user enters personal and payment details and clicks on purchase flight button")
	public void user_enters_personal_and_payment_details_and_clicks_on_purchase_flight_button() {
		personalAndPaymentDetails.fillPersonalAndPaymentDetails();
		personalAndPaymentDetails.clickOnPurchaseFlight();
	}

	@Then("payment confirmation page is displayed with confirmation id")
	public void payment_confirmation_page_is_displayed_with_confirmation_id() {
		flightBookingConfirm.verifyConfirmationID();
	}
}
