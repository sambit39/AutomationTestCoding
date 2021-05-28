package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelector {
	
	public static void selectDropdownValue(WebElement drpElement, String value) {
		Select drpEle = new Select(drpElement);
		drpEle.selectByValue(value);
	}

}
