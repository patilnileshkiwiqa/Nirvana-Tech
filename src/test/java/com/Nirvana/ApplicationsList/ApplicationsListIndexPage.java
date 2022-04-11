package com.Nirvana.ApplicationsList;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Nirvana.Init.AbstractPage;
import com.Nirvana.Init.Common;
 

public class ApplicationsListIndexPage extends AbstractPage{

	public ApplicationsListIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//Create New Application
	
	@FindBy(xpath="//span[text()='New Application']")
	WebElement clickOnNewApllicationButton;

	public ApplicationsListVerification clickOnNewApllicationButton() {
		Common.pause(2);
		Common.clickableElement(clickOnNewApllicationButton, driver);
		Common.clickOn(driver, clickOnNewApllicationButton);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//label[text()='DOT number']/..//input")
	WebElement enterDOTNumber;
	@FindBy(xpath="//button[@aria-label='sync']//*[name()='svg']")
	WebElement refreshCompanyNameBtn;
	
	public ApplicationsListVerification enterDOTNumber(String value) {
		Common.clickableElement(enterDOTNumber, driver);
		Common.type(enterDOTNumber, value);
		Common.clickableElement(refreshCompanyNameBtn, driver);
		Common.clickOn(driver, refreshCompanyNameBtn);
		return new ApplicationsListVerification(driver);

	}

	public ApplicationsListVerification selectYesOrNo(String value) {
		
		String xpath = "//span[contains(text(),'"+value+"')]";
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[text()='Continue']")
	WebElement continueButton;
	
	public ApplicationsListVerification continueButton() {
		Common.clickableElement(continueButton, driver);
		Common.clickOn(driver, continueButton);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//span[text()='Back to Home']")
	WebElement backtoHomeButton;
	
	public ApplicationsListVerification backtoHomeButton() {
		Common.clickableElement(backtoHomeButton, driver);
		Common.clickOn(driver, backtoHomeButton);
		Common.pause(3);
		Common.refresh(driver);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchBar;
		
	
	public ApplicationsListVerification searchBar(String value) {
		Common.pause(5);
		Common.refresh(driver);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(100, TimeUnit.SECONDS) 			
				.pollingEvery(2, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement tableElementPresent = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath("//tbody//tr[1]"));
			}
		});
		tableElementPresent.click();
		
		searchBar.sendKeys(value);
		Common.pause(1);
		return new ApplicationsListVerification(driver);

	}

	public ApplicationsListVerification clickOnAppID(String applicationID) {
		String xpath = "//tbody//td[1]";
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}
	
	public String getApplicationID() {	
		Common.pause(2);	
		String xpath = "//div[@class='css-jaenh2']//p[contains(text(),'#')]";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		System.out.println("Get Text : "+srt);
		return srt;		
	}

	public ApplicationsListVerification selectCoverageRequested(String value) {
		String xpath = "//span[text()='Physical Damage']/..//input";
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}

	@FindBy(id="producer-select")
	WebElement selectProducer;

	public ApplicationsListVerification selectProducer(String value) {
		String xpath ="//li[text()='"+value+"']";
		Common.clickableElement(selectProducer, driver);
		Common.clickOn(driver, selectProducer);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//label[text()='Projected number of power units']/../..//span//*[name()='svg']")
	WebElement refreshBtnProjectedNumber;

	public ApplicationsListVerification refreshBtnProjectedNumber() {
		Common.clickableElement(refreshBtnProjectedNumber, driver);
		Common.clickOn(driver, refreshBtnProjectedNumber);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//label[text()='Projected mileage']/../..//span//*[name()='svg']")
	WebElement refreshBtnProjectedMileage;

	public ApplicationsListVerification refreshBtnProjectedMileage() {
		Common.clickableElement(refreshBtnProjectedMileage, driver);
		Common.clickOn(driver, refreshBtnProjectedMileage);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//div[text()='0-50 miles']/../..//input")
	WebElement radius_0_50;

	public ApplicationsListVerification radius_0_50(String value) {
		Common.clickableElement(radius_0_50, driver);
		Common.type(radius_0_50, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//div[text()='51-200 miles']/../..//input")
	WebElement radius_51_200;

	public ApplicationsListVerification radius_51_200(String value) {
		Common.clickableElement(radius_51_200, driver);
		Common.type(radius_51_200, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//div[text()='201-500 miles']/../..//input")
	WebElement radius_201_500;

	public ApplicationsListVerification radius_201_500(String value) {
		Common.clickableElement(radius_201_500, driver);
		Common.type(radius_201_500, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//div[text()='501+ miles']/../..//input")
	WebElement radius_500;

	public ApplicationsListVerification radius_500(String value) {
		Common.clickableElement(radius_500, driver);
		Common.type(radius_500, value);
		return new ApplicationsListVerification(driver);
	}

	public String getTotal() {
		Common.pause(1);
		String xpath = "//div[text()='Total']/../..//div[2]//div";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		System.out.println(" Total  : "+srt);
		return srt;
	}

	@FindBy(xpath="//span[text()='Upload']")
	WebElement clickOnUploadEquipmentList;

	public ApplicationsListVerification clickOnUploadEquipmentList() {
		Common.scrollUpToElement(driver, clickOnUploadEquipmentList);
		Common.clickableElement(clickOnUploadEquipmentList, driver);
		Common.clickOn(driver, clickOnUploadEquipmentList);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//button[contains(text(),'Proceed')]")
	WebElement clickOnProccedBtnInEquipmentListTab;

	public ApplicationsListVerification clickOnProccedBtnInEquipmentListTab() {
		Common.clickableElement(clickOnProccedBtnInEquipmentListTab, driver);
		Common.clickOn(driver, clickOnProccedBtnInEquipmentListTab);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//button[contains(text(),'Upload data from file')]")
	WebElement clickOnUploadDataBtnInEquipmentListTab;

	public ApplicationsListVerification clickOnUploadDataBtnInEquipmentListTab(String absolutepath) throws AWTException {
//		Common.jsClick(driver, clickOnUploadDataBtnInEquipmentListTab);
		System.out.println("Absolute  path: "
                + absolutepath);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Frames :"+size);
		
		driver.switchTo().frame(1);
		
		Common.pause(2);
		StringSelection s = new StringSelection(absolutepath);
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      driver.findElement(By.xpath("//button[contains(text(),'Upload data from file')]")).click();
	      // Robot object creation
	      Common.pause(2);
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
		Common.pause(3);
		return new ApplicationsListVerification(driver);
	}
	
	public ApplicationsListVerification clickOnUploadDataBtnInDriverListTab(String absolutepath) throws AWTException {
//		Common.jsClick(driver, clickOnUploadDataBtnInEquipmentListTab);
		System.out.println("Absolute  path: "
                + absolutepath);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Frames :"+size);
		
		driver.switchTo().frame(2);
		
		Common.pause(2);
		StringSelection s = new StringSelection(absolutepath);
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      driver.findElement(By.xpath("//button[contains(text(),'Upload data from file')]")).click();
	      // Robot object creation
	      Common.pause(2);
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
		Common.pause(3);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//button[text()='Continue']")
	WebElement clickOnContinueBtnInEquipmentListTab;

	public ApplicationsListVerification selectSheets() {
		Common.pause(5);
		Common.clickableElement(clickOnContinueBtnInEquipmentListTab, driver);
		Common.clickOn(driver, clickOnContinueBtnInEquipmentListTab);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//div[text()='UnitRenewals']")
	WebElement clickOnDropDownSheets;

	public ApplicationsListVerification selectSheetsDriversList() throws AWTException {
		Common.pause(5);
		Common.clickableElement(clickOnDropDownSheets, driver);
		Common.clickOn(driver, clickOnDropDownSheets);
		Common.pause(2);
//		clickOnDropDownSheets.sendKeys(Keys.ARROW_DOWN);
//		clickOnDropDownSheets.sendKeys(Keys.ENTER);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Common.clickableElement(clickOnContinueBtnInEquipmentListTab, driver);
		Common.clickOn(driver, clickOnContinueBtnInEquipmentListTab);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//button[text()='Review']")
	WebElement clickOnReviewButton;
	
	public ApplicationsListVerification clickOnReviewButton() {
		Common.scrollUpToElement(driver, clickOnReviewButton);
		Common.clickableElement(clickOnReviewButton, driver);
		Common.clickOn(driver, clickOnReviewButton);
		return new ApplicationsListVerification(driver);
	}

	public ApplicationsListVerification clickOnContinueButton() {
		Common.clickableElement(clickOnContinueBtnInEquipmentListTab, driver);
		Common.clickOn(driver, clickOnContinueBtnInEquipmentListTab);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//li//button[text()='Continue']")
	WebElement clickOnContinueButtonNextPage;

	public ApplicationsListVerification clickOnContinueButtonNextPage() {
		Common.clickableElement(clickOnContinueButtonNextPage, driver);
		Common.clickOn(driver, clickOnContinueButtonNextPage);
		Common.pause(5);
		driver.switchTo().parentFrame();
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//span[text()='Proceed']")
	WebElement proceedBtnOperationsPage;

	public ApplicationsListVerification proceedBtnOperationsPage() {
		Common.clickableElement(proceedBtnOperationsPage, driver);
		Common.clickOn(driver, proceedBtnOperationsPage);
		Common.pause(2);
		return new ApplicationsListVerification(driver);
	}

	public ApplicationsListVerification selectOperations(String operations) {

		for (int j = 0; j < operations.split(";").length; j++) {
			System.out.println(operations.split(";")[j]);
			String operation = operations.split(";")[j];
			String xpath = "//p[text()='"+operation+"']";
			Common.pause(1);
			Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		}
	
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//p[text()='Dry Van']/../..//input")
	WebElement enterDryVan;
	
	public ApplicationsListVerification enterDryVan(String value) {
		Common.clickableElement(enterDryVan, driver);
		Common.type(enterDryVan, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//p[text()='Refrigerated']/../..//input")
	WebElement enterRefrigerated;

	public ApplicationsListVerification enterRefrigerated(String value) {
		Common.clickableElement(enterRefrigerated, driver);
		Common.type(enterRefrigerated, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//p[text()='Flatbed']/../..//input")
	WebElement enterFlatbed;
	
	public ApplicationsListVerification enterFlatbed(String value) {
		Common.clickableElement(enterFlatbed, driver);
		Common.type(enterFlatbed, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//p[text()='Intermodal']/../..//input")
	WebElement enterIntermodal;

	public ApplicationsListVerification enterIntermodal(String value) {
		Common.clickableElement(enterIntermodal, driver);
		Common.type(enterIntermodal, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//p[text()='Tanker']/../..//input")
	WebElement enterTanker;

	public ApplicationsListVerification enterTanker(String value) {
		Common.clickableElement(enterTanker, driver);
		Common.type(enterTanker, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//p[text()='Hazmat']/../..//input")
	WebElement enterHazmat;

	public ApplicationsListVerification enterHazmat(String value) {
		Common.clickableElement(enterHazmat, driver);
		Common.type(enterHazmat, value);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//p[text()='Heavy Haul']/../..//input")
	WebElement enterHeavyHaul;
	
	public ApplicationsListVerification enterHeavyHaul(String value) {
		Common.clickableElement(enterHeavyHaul, driver);
		Common.type(enterHeavyHaul, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//p[text()='Dump']/../..//input")
	WebElement enterDump;
	
	public ApplicationsListVerification enterDump(String value) {
		Common.clickableElement(enterDump, driver);
		Common.type(enterDump, value);
		return new ApplicationsListVerification(driver);
	}
	
	public String getTotalClassesAndCommodities() {	
		Common.pause(3);	
		String xpath = "//form//div[9]//div[2]//div";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		System.out.println("Get Text Total Classes And Commodities: "+srt);
		return srt;		
	}

	@FindBy(xpath="//div[text()='Select']")
	WebElement clickSelectOnClassesAndCommodities;
	
	public ApplicationsListVerification selectPrimaryCommodity(String value) {
		Common.scrollUpToElement(driver, clickSelectOnClassesAndCommodities);
		Common.clickableElement(clickSelectOnClassesAndCommodities, driver);
		Common.clickOn(driver, clickSelectOnClassesAndCommodities);
		String xpath = "//li[text()='"+value+"']";
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}

	//Loss History

	@FindBy(xpath="//tbody//tr[1]//td[2]//input")
	WebElement powerUnits1Xpath;
	@FindBy(xpath="//tbody//tr[1]//td[3]//input")
	WebElement lossIncurred1Xpath;
	@FindBy(xpath="//tbody//tr[1]//td[4]//input")
	WebElement claims1Xpath;
	@FindBy(xpath="//tbody//tr[2]//td[2]//input")
	WebElement powerUnits2Xpath;
	@FindBy(xpath="//tbody//tr[2]//td[3]//input")
	WebElement lossIncurred2Xpath;
	@FindBy(xpath="//tbody//tr[2]//td[4]//input")
	WebElement claims2Xpath;
	
	public ApplicationsListVerification autoLiabilitySummary(String powerUnits1, String lossIncurred1, String claims1, String powerUnits2, String lossIncurred2, String claims2) {
		Common.clickableElement(powerUnits1Xpath, driver);
		Common.type(powerUnits1Xpath, powerUnits1);
		Common.type(lossIncurred1Xpath, lossIncurred1);
		Common.type(claims1Xpath, claims1);
		Common.clickableElement(powerUnits2Xpath, driver);
		Common.type(powerUnits2Xpath, powerUnits2);
		Common.type(lossIncurred2Xpath, lossIncurred2);
		Common.type(claims2Xpath, claims2);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="(//tbody//tr[1]//td[2]//input)[1]")
	WebElement powerUnits21Xpath;
	@FindBy(xpath="(//tbody//tr[1]//td[3]//input)[1]")
	WebElement lossIncurred21Xpath;
	@FindBy(xpath="(//tbody//tr[1]//td[4]//input)[1]")
	WebElement claims21Xpath;
	@FindBy(xpath="(//tbody//tr[2]//td[2]//input)[1]")
	WebElement powerUnits22Xpath;
	@FindBy(xpath="(//tbody//tr[2]//td[3]//input)[1]")
	WebElement lossIncurred22Xpath;
	@FindBy(xpath="(//tbody//tr[2]//td[4]//input)[1]")
	WebElement claims22Xpath;
	@FindBy(xpath="(//tbody//tr[1]//td[2]//input)[2]")
	WebElement powerUnits21Xpath2;
	@FindBy(xpath="(//tbody//tr[1]//td[3]//input)[2]")
	WebElement lossIncurred21Xpath2;
	@FindBy(xpath="(//tbody//tr[1]//td[4]//input)[2]")
	WebElement claims21Xpath2;
	@FindBy(xpath="(//tbody//tr[2]//td[2]//input)[2]")
	WebElement powerUnits22Xpath2;
	@FindBy(xpath="(//tbody//tr[2]//td[3]//input)[2]")
	WebElement lossIncurred22Xpath2;
	@FindBy(xpath="(//tbody//tr[2]//td[4]//input)[2]")
	WebElement claims22Xpath2;
	
	
	public ApplicationsListVerification physicalDamageSummary(String powerUnits1, String lossIncurred1, String claims1,
			String powerUnits2, String lossIncurred2, String claims2, String powerUnits3, String lossIncurred3,
			String claims3, String powerUnits4, String lossIncurred4, String claims4) {
	
		Common.clickableElement(powerUnits21Xpath, driver);
		Common.type(powerUnits21Xpath, powerUnits1);
		Common.type(lossIncurred21Xpath, lossIncurred1);
		Common.type(claims21Xpath, claims1);
		
		Common.clickableElement(powerUnits22Xpath, driver);
		Common.type(powerUnits22Xpath, powerUnits2);	
		Common.type(lossIncurred22Xpath, lossIncurred2);
		Common.type(claims22Xpath, claims2);
		
		Common.clickableElement(powerUnits21Xpath2, driver);
		Common.type(powerUnits21Xpath2, powerUnits3);
		Common.type(lossIncurred21Xpath2, lossIncurred3);
		Common.type(claims21Xpath2, claims3);
		
		Common.clickableElement(powerUnits22Xpath2, driver);
		Common.type(powerUnits22Xpath2, powerUnits4);	
		Common.type(lossIncurred22Xpath2, lossIncurred4);
		Common.type(claims22Xpath2, claims4);
		
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//button[text()='Yes']")
	WebElement selectRowHeaders;	
	
	public ApplicationsListVerification selectRowHeaders() {
		Common.clickableElement(selectRowHeaders, driver);
		Common.clickOn(driver, selectRowHeaders);
		return new ApplicationsListVerification(driver);
	}

	public boolean getRowHeadersSelection() {
		Common.pause(1);
		String xpath = "//button[text()='No header row']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	@FindBy(xpath="(//label[text()='Equipment List']/../../..//p)[1]")
	WebElement clickOnToDownloadTheUploadedFile;	
	
	public ApplicationsListVerification clickOnToDownloadTheUploadedFile() {
		Common.scrollUpToElement(driver, clickOnToDownloadTheUploadedFile);
		Common.clickableElement(clickOnToDownloadTheUploadedFile, driver);
		Common.clickOn(driver, clickOnToDownloadTheUploadedFile);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(id="mui-component-select-CoverageAutoLiability")
	WebElement selectAutoLiabilityclick;
	

	public ApplicationsListVerification selectAutoLiability(String value) {
		String xpath = "//li//span[text()='"+value+"']";
		Common.clickableElement(selectAutoLiabilityclick, driver);
		Common.clickOn(driver, selectAutoLiabilityclick);
		Common.pause(2);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		Common.pause(12);
		return new ApplicationsListVerification(driver);
		
	}
	
	public ApplicationsListVerification selectPlans(String value) {
		String xpath = "//h6[text()='"+value+"']/../../..//button";
		
		Common.scrollUpToElement(driver, driver.findElement(By.xpath("//h6[text()='Basic']")));
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(id="mui-component-select-CoverageAutoPhysicalDamage")
	WebElement selectPhysicalDamageclick;

	public ApplicationsListVerification selectPlansPhysicalDamage(String autoLiability, String physicalDamage) {
		
		String xpath = "//ul//span[contains(text(),'"+autoLiability+"')]";
		
		Common.clickableElement(selectAutoLiabilityclick, driver);
		Common.clickOn(driver, selectAutoLiabilityclick);
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		
		Common.pause(12);
		String xpath2 = "//ul//span[contains(text(),'"+physicalDamage+"')]";
		
		Common.clickableElement(selectPhysicalDamageclick, driver);
		Common.clickOn(driver, selectPhysicalDamageclick);
		Common.clickableElement(driver.findElement(By.xpath(xpath2)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath2)));
		Common.pause(12);
		return new ApplicationsListVerification(driver);
	}

	//Additional information
	
	@FindBy(xpath="//span[text()='Connect']")
	WebElement ClickOnConnect;
	
	public ApplicationsListVerification ClickOnConnect() {
		Common.clickableElement(ClickOnConnect, driver);
		Common.clickOn(driver, ClickOnConnect);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//input[@name='name']")
	WebElement enterinsuredsFullName;
	@FindBy(xpath="//input[@name='email']")
	WebElement enterinsuredsEmail;
	@FindBy(xpath="//span[text()='Generate Link']")
	WebElement generateLinkBtn;
	
	public ApplicationsListVerification generateLink(String insuredsFullName, String insuredsEmail) {
		Common.clickableElement(enterinsuredsFullName, driver);
		Common.type(enterinsuredsFullName, insuredsFullName);	
		Common.type(enterinsuredsEmail, insuredsEmail);	
		Common.clickableElement(generateLinkBtn, driver);
		Common.clickOn(driver, generateLinkBtn);
		Common.pause(3);
		return new ApplicationsListVerification(driver);
	}

	public String getGenerateLink() {
		Common.pause(2);	
		String xpath = "//input[@placeholder='Invite link']";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getAttribute("value");
		return srt;	
	}

	@FindBy(xpath="//*[@data-testid='CloseIcon']//*")
	WebElement ClickOnClose;
	
	public ApplicationsListVerification ClickOnClose() {
		Common.clickableElement(ClickOnClose, driver);
		Common.clickOn(driver, ClickOnClose);
		Common.pause(3);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//*[text()=' Upload']")
	WebElement clickOnUploadDriversList;

	public ApplicationsListVerification clickOnUploadDriversList() {
		Common.scrollUpToElement(driver, driver.findElement(By.xpath("//span[text()='Link Generated']")));
		Common.clickableElement(clickOnUploadDriversList, driver);
		Common.clickOn(driver, clickOnUploadDriversList);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//button[text()='Yes']")
	WebElement clickOnYesButtonNextPage;
	
	public ApplicationsListVerification clickOnYesButtonNextPage() {
		Common.scrollUpToElement(driver, clickOnYesButtonNextPage);
		Common.clickableElement(clickOnYesButtonNextPage, driver);
		Common.clickOn(driver, clickOnYesButtonNextPage);
		return new ApplicationsListVerification(driver);
	}
	
	
	
	public ApplicationsListVerification clickOnDownloadUploadedFile2(String value) {
		String xpath="//p[contains(text(),'"+value+"')]";
		driver.switchTo().parentFrame();
		Common.scrollUpToElement(driver, driver.findElement(By.xpath("//span[text()='Link Generated']")));
		Common.clickableElement(driver.findElement(By.xpath(xpath)), driver);
		Common.clickOn(driver, driver.findElement(By.xpath(xpath)));
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(id="numOwnerOperatorUnits-input")
	WebElement enterOwnerOperators;

	public ApplicationsListVerification enterOwnerOperators(String value) {
		Common.clickableElement(enterOwnerOperators, driver);
		Common.type(enterOwnerOperators, value);	
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[normalize-space()='Hazardous Materials (including Class 9)']")
	WebElement selectHazardousMaterials;
	
	public ApplicationsListVerification selectHazardousMaterials() {
		Common.clickableElement(selectHazardousMaterials, driver);
		Common.clickOn(driver, selectHazardousMaterials);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='Lift-gate service/white glove delivery']")
	WebElement selectLiftGateService_WhiteGloveDelivery;

	public ApplicationsListVerification selectLiftGateService_WhiteGloveDelivery() {
		Common.clickableElement(selectLiftGateService_WhiteGloveDelivery, driver);
		Common.clickOn(driver, selectLiftGateService_WhiteGloveDelivery);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[normalize-space()='Residential Delivery']")
	WebElement selectResidentialDelivery;

	public ApplicationsListVerification selectResidentialDelivery() {
		Common.clickableElement(selectResidentialDelivery, driver);
		Common.clickOn(driver, selectResidentialDelivery);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[normalize-space()='Double/Triple Trailers']")
	WebElement selectDouble_TripleTrailers;

	public ApplicationsListVerification selectDouble_TripleTrailers() {
		Common.clickableElement(selectDouble_TripleTrailers, driver);
		Common.clickOn(driver, selectDouble_TripleTrailers);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[normalize-space()='Meat-on-hook']")
	WebElement selectMeatOnHook;
	
	public ApplicationsListVerification selectMeatOnHook() {
		Common.clickableElement(selectMeatOnHook, driver);
		Common.clickOn(driver, selectMeatOnHook);
		return new ApplicationsListVerification(driver);
	}
	
	public ApplicationsListVerification clickOnUploadDataBtnInLossRun(String absolutepath) throws AWTException {
//		Common.jsClick(driver, clickOnUploadDataBtnInEquipmentListTab);
//		System.out.println("Absolute  path: "
//                + absolutepath);
//		int size = driver.findElements(By.tagName("iframe")).size();
//		System.out.println("Frames :"+size);
//		
//		driver.switchTo().frame(1);
		
		Common.pause(2);
		StringSelection s = new StringSelection(absolutepath);
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      driver.findElement(By.xpath("//span[text()='Browse']")).click();
	      // Robot object creation
	      Common.pause(2);
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
		Common.pause(3);
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Common.pause(2);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(id="largeLossComment-input")
	WebElement enterLargeLosses;

	public ApplicationsListVerification enterLargeLosses(String value) {
		Common.scrollUpToElement(driver, enterLargeLosses);
		Common.clickableElement(enterLargeLosses, driver);
		Common.type(enterLargeLosses, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(id="overallComment-input")
	WebElement enterAdditionalInformation;

	public ApplicationsListVerification enterAdditionalInformation(String value) {
		Common.scrollUpToElement(driver, enterAdditionalInformation);
		Common.clickableElement(enterAdditionalInformation, driver);
		Common.type(enterAdditionalInformation, value);
		return new ApplicationsListVerification(driver);
	}
	
	@FindBy(xpath="//*[contains(text(),'Proceed')]")
	WebElement clickOnProccedBtn2InEquipmentListTab;

	public ApplicationsListVerification clickOnProccedBtn2InEquipmentListTab() {
		Common.clickableElement(clickOnProccedBtn2InEquipmentListTab, driver);
		Common.clickOn(driver, clickOnProccedBtn2InEquipmentListTab);
		return new ApplicationsListVerification(driver);
	}
	

	@FindBy(xpath="//span[contains(text(),'Proceed')]")
	WebElement clickOnProccedBtn2IndiccationTab;

	public ApplicationsListVerification clickOnProccedBtn2IndiccationTab() {
		Common.clickableElement(clickOnProccedBtn2IndiccationTab, driver);
		Common.clickOn(driver, clickOnProccedBtn2IndiccationTab);
		return new ApplicationsListVerification(driver);
	}
	
	
	@FindBy(xpath="//span[text()='Submit']")
	WebElement clickOnSubmitBtn;

	public ApplicationsListVerification clickOnSubmitBtn() {
		Common.clickableElement(clickOnSubmitBtn, driver);
		Common.clickOn(driver, clickOnSubmitBtn);
		return new ApplicationsListVerification(driver);
	}

	@FindBy(xpath="//span[text()='Back to Home']")
	WebElement clickOnBackToHomeBtn;
	
	public ApplicationsListVerification clickOnBackToHomeBtn() {
		Common.pause(2);
		Common.clickableElement(clickOnBackToHomeBtn, driver);
		Common.clickOn(driver, clickOnBackToHomeBtn);
		return new ApplicationsListVerification(driver);
	}

	public int getBasicPlanAmount() {
		Common.pause(1);
		String xpath = "(//span[text()='$']/..//span[contains(text(),',')])[1]";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		srt = srt.replaceAll(",", "");
		int number = Integer.parseInt(srt);
		return number;
	}
	
	public int getStandardPlanAmount() {
		Common.pause(1);
		String xpath = "(//span[text()='$']/..//span[contains(text(),',')])[2]";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		srt = srt.replaceAll(",", "");
		int number = Integer.parseInt(srt);
		return number;
	}
	
	public int getCompletePlanAmount() {
		Common.pause(1);
		String xpath = "(//span[text()='$']/..//span[contains(text(),',')])[3]";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		srt = srt.replaceAll(",", "");
		int number = Integer.parseInt(srt);
		return number;
	}

	
	public boolean getOperationsPageDetails() {
		String xpath = "//h4[text()='Operations']";
		
		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public boolean getClassesCommoditiesPageDetails() {
		String xpath = "//h4[text()='Classes & Commodities']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public boolean getLossHistoryPageDetails() {
		String xpath = "//h4[text()='Loss History']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public boolean getIndicationPageDetails() {
		String xpath = "//h4[text()='Indication']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}
	
	public boolean getAdditionalInformationPageDetails() {
		String xpath = "//h4[text()='Additional information']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public boolean getReviewPageDetails() {
		String xpath = "//h4[text()='Review']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public boolean getLinkGeneratedOnPageDetails() {
		String xpath = "//span[text()='Copy Connection Link']";

		if(driver.findElements(By.xpath(xpath)).size()==1)
			return true;
		else
			return false;
	}

	public String getApplicationId() {
		Common.pause(1);
		String xpath = "(//header//p)[1]";
		WebElement ele = driver.findElement(By.xpath(xpath));
		String srt = ele.getText();
		srt = srt.replaceAll("# ", "");
		System.out.println(" ApplicationId  /"+srt+"/");
		return srt;
	}

	
}
