package com.Nirvana.Claims;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;


public class ClaimsVerification extends AbstractPage {

	public ClaimsVerification(WebDriver driver) {
		super(driver);

	}


	public boolean verifyClaimsPagel() {
		Common.pause(1);
		String xpath = "//h4[text()='Claims']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}
}

