package com.Nirvana.Login;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;


public class LoginIndexPage extends AbstractPage{

	public LoginIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//Login
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailID;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordtxt;
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginBtn;

	public LoginVerification doLogin(String email, String password)
	{
		Common.clickableElement(emailID, driver);
		Common.type(emailID, email);
		Common.type(passwordtxt, password);
		Common.clickableElement(loginBtn, driver);
		Common.clickOn(driver, loginBtn);
		Common.pause(5);
		return new LoginVerification(driver);
	}


//Logout
	
	@FindBy(xpath="//*[@data-testid='ArrowDropDownIcon']")
	WebElement dropDownLogout;
	@FindBy(xpath="//li[text()='Logout']")
	WebElement logout;
	
	public LoginVerification logout()
	{
		
		Common.clickableElement(dropDownLogout, driver);
		Common.clickOn(driver, dropDownLogout);
		Common.clickableElement(logout, driver);
		Common.clickOn(driver, logout);

		return new LoginVerification(driver);
	}

}
