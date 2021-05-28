package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.DropdownSelector;
import com.utility.XpathGenerator;

public class PersonalAndPaymentDetailsPage {
	public WebDriver pagedriver;

	public PersonalAndPaymentDetailsPage(WebDriver driver) {
		this.pagedriver = driver;
		PageFactory.initElements(driver, pagedriver);
	}

	@FindBy(id = "inputName")
	@CacheLookup
	WebElement txtName;

	@FindBy(id = "address")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(id = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(id = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(id = "zipCode")
	@CacheLookup
	WebElement txtZipCode;

	@FindBy(id = "cardType")
	@CacheLookup
	WebElement drpCardType;

	@FindBy(id = "creditCardNumber")
	@CacheLookup
	WebElement txtCreditCardNumber;

	@FindBy(id = "creditCardMonth")
	@CacheLookup
	WebElement txtCreditCardMonth;

	@FindBy(id = "creditCardYear")
	@CacheLookup
	WebElement txtCreditCardYear;

	@FindBy(id = "nameOnCard")
	@CacheLookup
	WebElement txtNameOnCard;

	@FindBy(id = "rememberMe")
	@CacheLookup
	WebElement chkRememberMe;

	@FindBy(css = "input[value='Purchase Flight']")
	@CacheLookup
	WebElement btnPurchaseFlight;
	
	public String reservedFlightHeaderText = "//h2(text()='Your flight from {0} to {1} has been reserved.')";

	public void fillPersonalAndPaymentDetails() {
		txtName.sendKeys("abc xyz");
		txtAddress.sendKeys("abc");
		txtCity.sendKeys("abc");
		txtState.sendKeys("abc");
		txtZipCode.sendKeys("12345");
		DropdownSelector.selectDropdownValue(drpCardType, "Visa");
		txtCreditCardNumber.sendKeys("1234567890");
		txtCreditCardMonth.sendKeys("11");
		txtCreditCardYear.sendKeys("2022");
		txtNameOnCard.sendKeys("abc");
	}

	public void clickOnPurchaseFlight() {
		txtNameOnCard.click();
	}
	
	public void verifyPaymentPageHeaderText(String headerText, String fromCityIATACode, String toCityIATACode) {
		String xpathHeaderText = XpathGenerator.createXpath(headerText, fromCityIATACode, toCityIATACode);
		Assert.assertTrue(pagedriver.findElement(By.xpath(xpathHeaderText)).isDisplayed());
	}

}
