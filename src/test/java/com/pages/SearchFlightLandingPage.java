package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DropdownSelector;

public class SearchFlightLandingPage {
	public WebDriver pagedriver;

	public SearchFlightLandingPage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(driver, pagedriver);
	}

	@FindBy(name = "fromPort")
	@CacheLookup
	WebElement drpDepartureCity;

	@FindBy(name = "toPort")
	@CacheLookup
	WebElement drpDestinationCity;

	@FindBy(css = "input[value='Find Flights']")
	@CacheLookup
	WebElement btnfindFlights;

	public void searchFlights(String fromCity, String toCity) {
		DropdownSelector.selectDropdownValue(drpDepartureCity, fromCity);
		DropdownSelector.selectDropdownValue(drpDestinationCity, toCity);
		btnfindFlights.click();
	}

}
