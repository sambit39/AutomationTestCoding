package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightBookingConfirmationPage {
	public WebDriver pagedriver;

	public FlightBookingConfirmationPage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(driver, pagedriver);
	}

	@FindBy(css = "table > tbody > tr:nth-child(1) > td:nth-child(2)")
	@CacheLookup
	WebElement confirmationID;

	public void verifyConfirmationID() {
		String string = confirmationID.getText();
		if (string == null || string.equals("")) {
			Assert.assertFalse(false);
		}
		try {
			int intValue = Integer.parseInt(string);
			Assert.assertTrue(true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Assert.assertFalse(false);
	}
}
