package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.XpathGenerator;

public class SearchedFlightTablePage {
	public WebDriver pagedriver;

	public SearchedFlightTablePage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(driver, pagedriver);
	}

	public String headerText = "//h3(text()='Flights from {0} to {1}: ')";

	public void verifyHeaderText(String headerText, String fromCity, String toCity) {
		String xpathHeaderText = XpathGenerator.createXpath(headerText, fromCity, toCity);
		Assert.assertTrue(pagedriver.findElement(By.xpath(xpathHeaderText)).isDisplayed());
	}

	public void verifySearchedFlightTableIsNotEmpty() {
		int rowSize = pagedriver.findElements(By.xpath("//table/tbody/tr")).size();
		Assert.assertNotEquals(rowSize, 0);
	}

	public void selectAnySearchedFlight() {
		pagedriver
				.findElement(By.cssSelector(
						"table > tbody > tr:nth-child(1) > td:nth-child(2) > input[value='Choose This Flight']"))
				.click();
	}

}
