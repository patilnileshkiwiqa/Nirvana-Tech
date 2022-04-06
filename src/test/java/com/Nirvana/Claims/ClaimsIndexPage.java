package com.Nirvana.Claims;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Nirvana.ApplicationsList.ApplicationsListVerification;
import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;


public class ClaimsIndexPage extends AbstractPage{

	public ClaimsIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//Claims
	
	@FindBy(xpath="//span[text()='Claims']")
	WebElement claimsPageTab;

	public ClaimsVerification claimsPageTab() {
		Common.pause(2);
		Common.clickableElement(claimsPageTab, driver);
		Common.clickOn(driver, claimsPageTab);
		return new ClaimsVerification(driver);
	}

}
