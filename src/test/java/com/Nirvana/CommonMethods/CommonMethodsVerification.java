package com.Nirvana.CommonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Nirvana.Init.AbstractPage;


public class CommonMethodsVerification extends AbstractPage {

	public CommonMethodsVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath=".//span[@data-notify='message']")
	WebElement successMsg;
	
	public Boolean verifySuccessMessage(String value)
	{
		if(successMsg.getText().contains(value))
			return true;
		else
			return false;
	}
	
	@FindBy(xpath=".//header[contains(.,'Sign In')]")
	WebElement signin;
	
	public Boolean verifysignin(String valu) {
		
		if(signin.getText().contains(valu)) {
		return true;
	}
		else {
		return false;
	}
	}

}
