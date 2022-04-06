package com.Nirvana.ApplicationsList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;

 

public class ApplicationsListVerification extends AbstractPage {

	public ApplicationsListVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public Boolean verifyloginurl(String value) 
	{
		Common.pause(1);
		String actualTitle = driver.getTitle();
		String expectedTitle = value;

		if(actualTitle.equalsIgnoreCase(expectedTitle)) 
			return true;
		else
			return false;
	}

	
	public boolean verifyForYesEligibility() {
		Common.pause(1);
		String xpath = "//h5[contains(text(),'Unfortunately')]";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}


	public boolean verifyDocumentSummary() {
		Common.pause(2);
		String xpath = "//div[text()='Document Summary']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}


	public boolean verifyLinkGenerated() {
		Common.pause(1);
		String xpath = "//span[text()='Link Generated']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}


	public boolean verifyReviewPage() {
		Common.pause(1);
		String xpath = "//span[text()='Edit']";

		if(driver.findElements(By.xpath(xpath)).size()==5)
			return true;
		else
			return false;	
	}


	public boolean verifySubmitPage() {
		Common.pause(1);
		String xpath = "//h4[text()='Congratulations! Your application is successfully submitted']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;	
	}


	public boolean verifyPlansAmountOrder(int basic, int standard, int complete) {
		if(complete > standard )
		{
			if(standard > basic) 
			{
				return true;
			}else
				return false;
		}
		else
			return false;
	}


	public boolean verifyStatus() {
		Common.pause(1);
		String xpath = "(//tr/td[5]//span[text()='Pending ELD/Telematics'])[1]";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;	
	}
}

