package com.Nirvana.CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;



public class CommonMethodsIndexPage extends AbstractPage{

	public CommonMethodsIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public CommonMethodsVerification clickOnMenu(String sidemenu)
	{
		//String xpath=".//a[@title='"+menu+"']";
		String xpath="//a[@id='"+sidemenu+"_sidebar_link']";
		
		Common.PresenceOfElement(By.xpath(xpath), driver);
		Common.clickableElement(By.xpath(xpath), driver);
		driver.findElement(By.xpath(xpath)).click();
		
		return new CommonMethodsVerification(driver);
	}
	
	public CommonMethodsVerification clickOnMenuWithouChild(String menu)
	{
		String xpath=".//span[@class='menu-item-parent' and contains(.,'"+menu+"')]";
		
		Common.PresenceOfElement(By.xpath(xpath), driver);
		Common.clickableElement(By.xpath(xpath), driver);
		driver.findElement(By.xpath(xpath)).click();
		
		return new CommonMethodsVerification(driver);
	}
	
	public WebDriver redirectOnMainMenu()
	{		
		System.out.println("--------------->"+testUrl);
		driver.navigate().to("https://google.com");
		return driver;
	}
	
	//SideBar Menu Xpath
	//a[@id='inventory_sidebar_link']
	//a[@id='about_sidebar_link']
	//a[@id='logout_sidebar_link']
	//a[@id='reset_sidebar_link']

}
