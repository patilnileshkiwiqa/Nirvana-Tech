package com.Nirvana.ApplicationsList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Nirvana.Init.Common;
import com.Nirvana.Init.SeleniumInit;
import com.Nirvana.Utility.TestData;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ApplicationsListIndex extends SeleniumInit{


	@Test
	public void createApplication() throws IOException, AWTException{

		int numOfFailure=0;
		int step=1;
		
		//For Data Driven From Excel
		
		File fMain = new File("UploadData/NewApp.xlsx");
		String NewAppCreateExcel = fMain.getAbsolutePath();
		System.out.println("Absolute  path NewAppCreateExcel: "
				+ NewAppCreateExcel);


		ArrayList<String> DOTNumberE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "DOTNumber");
		ArrayList<String> EligibilityE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Eligibility");
		ArrayList<String> CoverageRequestedE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "CoverageRequested");
		ArrayList<String> ProducerE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Producer");
		ArrayList<String> Miles_0_50E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Miles_0_50");
		ArrayList<String> Miles_51_200E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Miles_51_200");
		ArrayList<String> Miles_201_500E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Miles_201_500");
		ArrayList<String> Miles501E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Miles501");
		ArrayList<String> UploadedFileE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "UploadedFile");
		ArrayList<String> OperationsE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Operations");
		ArrayList<String> DryVanE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "DryVan");
		ArrayList<String> RefrigeratedE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Refrigerated"); 
		ArrayList<String> FlatbedE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Flatbed"); 
		ArrayList<String> IntermodalE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Intermodal"); 
		ArrayList<String> TankerE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Tanker"); 
		ArrayList<String> HazmatE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Hazmat");
		ArrayList<String> HeavyHaulE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "HeavyHaul"); 
		ArrayList<String> DumpE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Dump");
		ArrayList<String> PrimaryCommodityE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PrimaryCommodity"); 
		ArrayList<String> PowerUnits1E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PowerUnits1");
		ArrayList<String> LossIncurred1E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LossIncurred1"); 
		ArrayList<String> Claims1E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Claims1");
		ArrayList<String> PowerUnits2E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PowerUnits2");
		ArrayList<String> LossIncurred2E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LossIncurred2");
		ArrayList<String> Claims2E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Claims2");
		ArrayList<String> PowerUnits3E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PowerUnits3");
		ArrayList<String> LossIncurred3E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LossIncurred3");
		ArrayList<String> Claims3E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Claims3");
		ArrayList<String> PowerUnits4E = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PowerUnits4");
		ArrayList<String> LossIncurred4E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LossIncurred4");
		ArrayList<String> Claims4E  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Claims4");
		ArrayList<String> AutoLiabilityE  = TestData.getColumnData(NewAppCreateExcel, "NewApp", "AutoLiability");
		ArrayList<String> PlansE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Plans");
		ArrayList<String> PhysicalDamageE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "PhysicalDamage");
		ArrayList<String> InsuredsFullNameE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "InsuredsFullName");
		ArrayList<String> InsuredsEmailE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "InsuredsEmail");
		ArrayList<String> OwnerOperatorsUnitsE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "OwnerOperatorsUnits");
		ArrayList<String> HazardousMaterialsE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "HazardousMaterials");
		ArrayList<String> LiftGateService_WhiteGloveDeliveryE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LiftGateService_WhiteGloveDelivery");
		ArrayList<String> ResidentialDeliveryE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "ResidentialDelivery");
		ArrayList<String> Double_TripleTrailersE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "Double_TripleTrailers");
		ArrayList<String> MeatOnHookE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "MeatOnHook");
		ArrayList<String> LargeLossesE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "LargeLosses");
		ArrayList<String> AdditionalInformationE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "AdditionalInformation");
		ArrayList<String> UploadedFileLossRunE = TestData.getColumnData(NewAppCreateExcel, "NewApp", "UploadedFileLossRun");


		String DOTNumber = DOTNumberE.get(0);
		String Eligibility = EligibilityE.get(0);
		String CoverageRequested = CoverageRequestedE.get(0);
		String Producer = ProducerE.get(0);
		String Miles_0_50 = Miles_0_50E.get(0);
		String Miles_51_200 = Miles_51_200E.get(0);
		String Miles_201_500 = Miles_201_500E.get(0);
		String Miles501 = Miles501E.get(0);
		String UploadedFile = UploadedFileE.get(0);
		String Operations = OperationsE.get(0);
		String DryVan = DryVanE.get(0);
		String Refrigerated = RefrigeratedE.get(0); 
		String Flatbed = FlatbedE.get(0); 
		String Intermodal = IntermodalE.get(0); 
		String Tanker = TankerE.get(0); 
		String Hazmat = HazmatE.get(0);
		String HeavyHaul = HeavyHaulE.get(0); 
		String Dump = DumpE.get(0);
		String PrimaryCommodity = PrimaryCommodityE.get(0); 
		String PowerUnits1  = PowerUnits1E.get(0);
		String LossIncurred1 = LossIncurred1E.get(0); 
		String Claims1  = Claims1E.get(0);
		String PowerUnits2  = PowerUnits2E.get(0);
		String LossIncurred2  = LossIncurred2E.get(0);
		String Claims2  = Claims2E.get(0);
		String PowerUnits3  = PowerUnits3E.get(0);
		String LossIncurred3  = LossIncurred3E.get(0);
		String Claims3  = Claims3E.get(0);
		String PowerUnits4 = PowerUnits4E.get(0);
		String LossIncurred4  = LossIncurred4E.get(0);
		String Claims4  = Claims4E.get(0);
		String AutoLiability  = AutoLiabilityE.get(0);
		String Plans = PlansE.get(0);
		String PhysicalDamage = PhysicalDamageE.get(0);
		String InsuredsFullName = InsuredsFullNameE.get(0);
		String InsuredsEmail = InsuredsEmailE.get(0);
		String OwnerOperatorsUnits = OwnerOperatorsUnitsE.get(0);
		String HazardousMaterials = HazardousMaterialsE.get(0);
		String LiftGateService_WhiteGloveDelivery = LiftGateService_WhiteGloveDeliveryE.get(0);
		String ResidentialDelivery = ResidentialDeliveryE.get(0);
		String Double_TripleTrailers = Double_TripleTrailersE.get(0);
		String MeatOnHook = MeatOnHookE.get(0);
		String LargeLosses = LargeLossesE.get(0);
		String AdditionalInformation = AdditionalInformationE.get(0);
		String UploadedFileLossRun = UploadedFileLossRunE.get(0);

		
		logStep(step++,"Open URL : "+testUrl);	

		logStep(step++,"Click on + New Application Button");
		applicationsListVerification =applicationsListIndexPage.clickOnNewApllicationButton();
		
		if(!DOTNumber.equalsIgnoreCase("")) 
		{
			logStep(step++,"Enter DOT Numbers");
			applicationsListVerification = applicationsListIndexPage.enterDOTNumber(DOTNumber);
			log("Entered DOT Number is "+DOTNumber);
		}
		
		if(!Eligibility.equalsIgnoreCase("")) 
		{
			logStep(step++,"Select Yes or No for insured's eligibility");
			applicationsListVerification = applicationsListIndexPage.selectYesOrNo(Eligibility);
		}
		
		logStep(step++,"Click on continue button");
		applicationsListVerification = applicationsListIndexPage.continueButton();
		
		if(Eligibility.equalsIgnoreCase("Yes")) 
		{
			if(applicationsListVerification.verifyForYesEligibility()) 
			{
				logStatus(1,"Unfortunately, this application doesn't fit our appetite");
			}
			else{
				logStatus(2,"Not working");
				numOfFailure++;
			}

			logStep(step++,"Click on back to home button");
			applicationsListVerification = applicationsListIndexPage.backtoHomeButton();
		}
		
		if(Eligibility.equalsIgnoreCase("No")) 
		{
			log("Geting ApplicationId value. ");
			String ApplicationID = applicationsListIndexPage.getApplicationId();
			TestData.setValueConfig("uploadConfig.properties","ApplicationID",ApplicationID);
			
//			if(!ApplicationID.equalsIgnoreCase(""))
//			{
//				logStep(step++,"Searching given application id.");
//				applicationsListVerification = applicationsListIndexPage.searchBar(ApplicationID);
	//
//			logStep(step++,"Click on the given application id. "+ApplicationID);
//			applicationsListVerification = applicationsListIndexPage.clickOnAppID(ApplicationID);
//			TestData.setValueConfig("uploadConfig.properties","ApplicationID",applicationsListIndexPage.getApplicationID());
//			
//			}
			
			
			/////////////Operations
			
			boolean OperationsPage = applicationsListIndexPage.getOperationsPageDetails();
			
			if(OperationsPage==true)
			{
				if(!CoverageRequested.equalsIgnoreCase(""))
				{
					logStep(step++,"Select coverage requested.");
					if(CoverageRequested.equalsIgnoreCase("Physical Damage")) 
					{
						applicationsListVerification = applicationsListIndexPage.selectCoverageRequested(CoverageRequested);
					}
					log("Selected value is "+CoverageRequested);
				}

				if(!Producer.equalsIgnoreCase(""))
				{
					logStep(step++,"Select producer.");
					applicationsListVerification = applicationsListIndexPage.selectProducer(Producer);
					log("Selected value is "+Producer);
				}

				logStep(step++,"Click on refresh projected number of power units. ");
				applicationsListVerification = applicationsListIndexPage.refreshBtnProjectedNumber();

				logStep(step++,"Click on refresh projected mileage. ");
				applicationsListVerification = applicationsListIndexPage.refreshBtnProjectedMileage();

				logStep(step++,"Enter Radius of operation. ");
				if(!Miles_0_50.equalsIgnoreCase(""))
				{
					logStep(step++,"Entered value in 0-50 miles ");
					applicationsListVerification = applicationsListIndexPage.radius_0_50(Miles_0_50);
					log("Value entered is 0-50 miles : "+Miles_0_50);
				}

				if(!Miles_51_200.equalsIgnoreCase(""))
				{
					logStep(step++,"Entered value in 51-200 miles ");
					applicationsListVerification = applicationsListIndexPage.radius_51_200(Miles_51_200);
					log("Value entered is 51-200 miles :"+Miles_51_200);
				}

				if(!Miles_201_500.equalsIgnoreCase(""))
				{
					logStep(step++,"Entered value in 201-500 miles ");
					applicationsListVerification = applicationsListIndexPage.radius_201_500(Miles_201_500);
					log("Value entered is 201-500 miles :"+Miles_201_500);
				}

				if(!Miles501.equalsIgnoreCase(""))
				{
					logStep(step++,"Entered value in 501+ miles ");
					applicationsListVerification = applicationsListIndexPage.radius_500(Miles501);
					log("Value entered is 501+ miles :"+Miles501);
				}

				log("Total value is : "+applicationsListIndexPage.getTotal());

				logStep(step++,"Click on the upload button in the equipment list ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadEquipmentList();

		        
				logStep(step++,"Click on the procced button ");
				applicationsListVerification = applicationsListIndexPage.clickOnProccedBtnInEquipmentListTab();

				File f = new File("UploadData/"+UploadedFile+"");
				String absolute = f.getAbsolutePath();
				System.out.println("Absolute  path: "
						+ absolute);

				logStep(step++,"Click on the upload data from file button in the upload equipment list ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadDataBtnInEquipmentListTab(absolute);

				logStep(step++,"Select sheets and click on continue button. ");
				applicationsListVerification = applicationsListIndexPage.selectSheets();
				
				boolean getRowHead = applicationsListIndexPage.getRowHeadersSelection();
				
				if (getRowHead==true) {
					logStep(step++,"Select row contain column headers?. ");
					applicationsListVerification = applicationsListIndexPage.selectRowHeaders();
				}

				logStep(step++,"Click on review button. ");
				applicationsListVerification = applicationsListIndexPage.clickOnReviewButton();

				logStep(step++,"Click on continue button. ");
				applicationsListVerification = applicationsListIndexPage.clickOnContinueButton();
				
				logStep(step++,"Click on continue button on next page. ");
				applicationsListVerification = applicationsListIndexPage.clickOnContinueButtonNextPage();
				
				logStep(step++,"Click on the equipment list to download the uploaded file. ");
				applicationsListVerification = applicationsListIndexPage.clickOnToDownloadTheUploadedFile();
				
				log("Verifying Document Summary. ");
				if(applicationsListVerification.verifyDocumentSummary()) 
				{
					logStatus(1,"File loaded successfully and Document Summary is also visible");
				}
				else{
					logStatus(2,"Document Summary not visible ");
					numOfFailure++;
				}

				logStep(step++,"Click on proceed button on operations page. ");
				applicationsListVerification = applicationsListIndexPage.proceedBtnOperationsPage();
			}

		
			
			/////////////Classes & Commodities
			
			boolean ClassesCommoditiesPage = applicationsListIndexPage.getClassesCommoditiesPageDetails();
			
			if(ClassesCommoditiesPage==true)
			{
				logStep(step++,"Select Operating class distribution");
				applicationsListVerification = applicationsListIndexPage.selectOperations(Operations);
				
				if(!DryVan.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Dry Van");
					applicationsListVerification = applicationsListIndexPage.enterDryVan(DryVan);
					log("Value is "+DryVan);
				}
				
				if(!Refrigerated.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Refrigerated ");
					applicationsListVerification = applicationsListIndexPage.enterRefrigerated(Refrigerated);
					log("Value is "+Refrigerated);
				}
				
				if(!Flatbed.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Flatbed ");
					applicationsListVerification = applicationsListIndexPage.enterFlatbed(Flatbed);
					log("Value is "+Flatbed);
				}
				
				if(!Intermodal.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Intermodal ");
					applicationsListVerification = applicationsListIndexPage.enterIntermodal(Intermodal);
					log("Value is "+Intermodal);
				}
				
				if(!Tanker.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Tanker ");
					applicationsListVerification = applicationsListIndexPage.enterTanker(Tanker);
					log("Value is "+Tanker);
				}
				
				if(!Hazmat.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Hazmat ");
					applicationsListVerification = applicationsListIndexPage.enterHazmat(Hazmat);
					log("Value is "+Hazmat);
				}
				
				if(!HeavyHaul.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in HeavyHaul ");
					applicationsListVerification = applicationsListIndexPage.enterHeavyHaul(HeavyHaul);
					log("Value is "+HeavyHaul);
				}
				
				if(!Dump.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter value in Dump ");
					applicationsListVerification = applicationsListIndexPage.enterDump(Dump);
					log("Value is "+Dump);
				}
				
				log("Total value is : "+applicationsListIndexPage.getTotalClassesAndCommodities());
				
				if(!PrimaryCommodity.equalsIgnoreCase(""))
				{
					logStep(step++,"Select value in Primary Commodity ");
					applicationsListVerification = applicationsListIndexPage.selectPrimaryCommodity(PrimaryCommodity);
					log("Selceted Value is "+PrimaryCommodity);
				}
				
				logStep(step++,"Click on proceed > button on Classes & Commodities page. ");
				applicationsListVerification = applicationsListIndexPage.proceedBtnOperationsPage();
			}
			
			
			/////////////Loss History
			
			boolean LossHistoryPage = applicationsListIndexPage.getLossHistoryPageDetails();
			if(LossHistoryPage==true)
			{
				if(CoverageRequested.equalsIgnoreCase("Auto Liability"))
				{
					logStep(step++,"Enter auto liability summary. ");
					applicationsListVerification = applicationsListIndexPage.autoLiabilitySummary(PowerUnits1, LossIncurred1, Claims1, PowerUnits2, LossIncurred2, Claims2);
				}
				
				if(CoverageRequested.equalsIgnoreCase("Auto Liability + Physical Damage"))
				{
					logStep(step++,"Enter auto liability summary and physical damage summary. ");
					applicationsListVerification = applicationsListIndexPage.physicalDamageSummary(PowerUnits1, LossIncurred1, Claims1, PowerUnits2, LossIncurred2, Claims2, PowerUnits3, LossIncurred3, Claims3, PowerUnits4, LossIncurred4, Claims4);
				}
				
				logStep(step++,"Click on proceed > button on Loss History page. ");
				applicationsListVerification = applicationsListIndexPage.proceedBtnOperationsPage();
			}
			
			Common.pause(10);
			
			
			/////////////Indication
			
			boolean IndicationPage = applicationsListIndexPage.getIndicationPageDetails();
			
			if(IndicationPage==true)
			{
				if(CoverageRequested.equalsIgnoreCase("Auto Liability"))
				{
					if(!AutoLiability.equalsIgnoreCase(""))
					{
						logStep(step++,"Select value in deductibles for auto liability. ");
						applicationsListVerification = applicationsListIndexPage.selectAutoLiability(AutoLiability);
						log("Selceted Value is "+AutoLiability);
					}
				}
				
				
				if(CoverageRequested.equalsIgnoreCase("Physical Damage"))
				{
					if(!PhysicalDamage.equalsIgnoreCase(""))
					{
						logStep(step++,"Select value in deductibles for auto liability and physical damage. ");
						applicationsListVerification = applicationsListIndexPage.selectPlansPhysicalDamage(AutoLiability,PhysicalDamage);
						log("Selceted Value is "+AutoLiability+ " and Physical Damage "+PhysicalDamage);
					}
				}
				
				
				int basicValue = applicationsListIndexPage.getBasicPlanAmount();
				int standardValue = applicationsListIndexPage.getStandardPlanAmount();
				int completeValue = applicationsListIndexPage.getCompletePlanAmount();
				
				log("Verifying plans amount in incremental order. ");
				if(applicationsListVerification.verifyPlansAmountOrder(basicValue,standardValue,completeValue)) 
				{
					logStatus(1,"Plans amount is in proper incremental order ");
				}
				else{
					logStatus(2,"Plans amount is not in proper order");
					numOfFailure++;
				}
				
				if(!Plans.equalsIgnoreCase(""))
				{
					logStep(step++,"Select value in auto liability. ");
					applicationsListVerification = applicationsListIndexPage.selectPlans(Plans);
					log("Selceted Value is "+Plans);
				}
				
				logStep(step++,"Click on the procced button ");
				applicationsListVerification = applicationsListIndexPage.clickOnProccedBtn2IndiccationTab();
			}

			
			/////////////Additional information
			
			boolean AdditionalInformationPage = applicationsListIndexPage.getAdditionalInformationPageDetails();
			
			boolean LinkGeneratedOnPage = applicationsListIndexPage.getLinkGeneratedOnPageDetails();
			
			if(AdditionalInformationPage==true)
			{
				
				if(LinkGeneratedOnPage==false)
				{
					logStep(step++,"Connecting ELD/Telematics data so the insured may be eligible for up to 20% discount. ");
					applicationsListVerification = applicationsListIndexPage.ClickOnConnect();
					
					
					if(!InsuredsFullName.equalsIgnoreCase("") && !InsuredsEmail.equalsIgnoreCase(""))
					{
						logStep(step++,"Connect ELD/Telematics to generate link. ");
						applicationsListVerification = applicationsListIndexPage.generateLink(InsuredsFullName, InsuredsEmail);
						log("Selceted Value is "+InsuredsFullName);
					}
					
					log("Generated link is : "+applicationsListIndexPage.getGenerateLink());
					TestData.setValueConfig("uploadConfig.properties","GeneratedLink",applicationsListIndexPage.getGenerateLink());
					
					logStep(step++,"Click on close. ");
					applicationsListVerification = applicationsListIndexPage.ClickOnClose();
				}

				log("Verifying Link Generated. ");
				if(applicationsListVerification.verifyLinkGenerated()) 
				{
					logStatus(1,"Link Generated successfully");
				}
				else{
					logStatus(2,"Link Not Generated ");
					numOfFailure++;
				}
				
				File f1 = new File("UploadData/"+UploadedFile+"");
				String absolutePathDriverList = f1.getAbsolutePath();
				System.out.println("Absolute  path: "
						+ absolutePathDriverList);

				logStep(step++,"Click on the upload button in drivers list. ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadDriversList();
				
				
				logStep(step++,"Click on the upload data from file button in the upload equipment list ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadDataBtnInDriverListTab(absolutePathDriverList);
				
				logStep(step++,"Select sheets and click on continue button. ");
				applicationsListVerification = applicationsListIndexPage.selectSheetsDriversList();
				
				boolean getRowHead2 = applicationsListIndexPage.getRowHeadersSelection();
				
				if (getRowHead2==true) {
					logStep(step++,"Select row contain column headers?. ");
					applicationsListVerification = applicationsListIndexPage.selectRowHeaders();
				}

				logStep(step++,"Click on review button. ");
				applicationsListVerification = applicationsListIndexPage.clickOnReviewButton();

				logStep(step++,"Click on continue button. ");
				applicationsListVerification = applicationsListIndexPage.clickOnContinueButton();
				
				logStep(step++,"Click on Yes button on next page. ");
				applicationsListVerification = applicationsListIndexPage.clickOnYesButtonNextPage();
				
				logStep(step++,"Click on the Drivers list to download the uploaded file. ");
				applicationsListVerification = applicationsListIndexPage.clickOnDownloadUploadedFile2(UploadedFile);

				log("Verifying Document Summary. ");
				if(applicationsListVerification.verifyDocumentSummary()) 
				{
					logStatus(1,"File loaded successfully and Document Summary is also visible");
				}
				else{
					logStatus(2,"Document Summary not visible ");
					numOfFailure++;
				}
				
				if(!OwnerOperatorsUnits.equalsIgnoreCase(""))
				{
					logStep(step++,"Enter number of units in the fleet are the owner operator. ");
					applicationsListVerification = applicationsListIndexPage.enterOwnerOperators(OwnerOperatorsUnits);
					log("Value is "+OwnerOperatorsUnits);
				}
				
				if(!HazardousMaterials.equalsIgnoreCase("") || LiftGateService_WhiteGloveDelivery.equalsIgnoreCase("") 
						|| !ResidentialDelivery.equalsIgnoreCase("") || !Double_TripleTrailers.equalsIgnoreCase("") || 
						!MeatOnHook.equalsIgnoreCase("")) 	
				{
					logStep(step++,"Select if any of these operations or commodities apply. ");
					
					if (HazardousMaterials.equalsIgnoreCase("true")) {
						applicationsListVerification = applicationsListIndexPage.selectHazardousMaterials();
						log("Value is "+HazardousMaterials);
					}

					if (LiftGateService_WhiteGloveDelivery.equalsIgnoreCase("true")) {
						applicationsListVerification = applicationsListIndexPage.selectLiftGateService_WhiteGloveDelivery();
						log("Value is "+LiftGateService_WhiteGloveDelivery);
					}

					if (ResidentialDelivery.equalsIgnoreCase("true")) {
						applicationsListVerification = applicationsListIndexPage.selectResidentialDelivery();
						log("Value is "+ResidentialDelivery);
					}

					if (Double_TripleTrailers.equalsIgnoreCase("true")) {
						applicationsListVerification = applicationsListIndexPage.selectDouble_TripleTrailers();
						log("Value is "+Double_TripleTrailers);
					}

					if (MeatOnHook.equalsIgnoreCase("true")) {
						applicationsListVerification = applicationsListIndexPage.selectMeatOnHook();
						log("Value is "+MeatOnHook);
					}
				}
				
				logStep(step++,"Click on the upload button in loss runs ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadEquipmentList();
				
				File f2 = new File("UploadData/"+UploadedFileLossRun+"");
				String absolutePathLossRun = f2.getAbsolutePath();
				System.out.println("Absolute  path: "
						+ absolutePathLossRun);
			
				logStep(step++,"Clicking on browse button. ");
				applicationsListVerification = applicationsListIndexPage.clickOnUploadDataBtnInLossRun(absolutePathLossRun);
				
				logStep(step++,"Enter large Losses. ");
				applicationsListVerification = applicationsListIndexPage.enterLargeLosses(LargeLosses);
				
				logStep(step++,"Enter additional information. ");
				applicationsListVerification = applicationsListIndexPage.enterAdditionalInformation(AdditionalInformation);
				
				logStep(step++,"Click on the procced button ");
				applicationsListVerification = applicationsListIndexPage.clickOnProccedBtn2InEquipmentListTab();
			}
			
			//Review
			
			boolean ReviewPage = applicationsListIndexPage.getReviewPageDetails();
			
			if(ReviewPage==true)
			{
				log("Verifying Review Page. ");
				if(applicationsListVerification.verifyReviewPage()) 
				{
					logStatus(1,"Review page loaded succesfully and all five fields are editable. ");
				}
				else{
					logStatus(2,"Review page not loaded succesfully. ");
					numOfFailure++;
				}
				
				logStep(step++,"Click on the submit button ");
				applicationsListVerification = applicationsListIndexPage.clickOnSubmitBtn();
			}
			
			
			log("Verifying submition page. ");
			if(applicationsListVerification.verifySubmitPage()) 
			{
				logStatus(1,"Submit page loaded succesfully and application is submited. ");
			}
			else{
				logStatus(2,"Submit page not loaded succesfully. ");
				numOfFailure++;
			}
			
			logStep(step++,"Click on the back to home button ");
			applicationsListVerification = applicationsListIndexPage.clickOnBackToHomeBtn();
			
			if(!ApplicationID.equalsIgnoreCase(""))
			{
				logStep(step++,"Searching given application id.");
				applicationsListVerification = applicationsListIndexPage.searchBar(ApplicationID);
			}
			
			log("Verifying newly created application. ");
			if(applicationsListVerification.verifyStatus()) 
			{
				logStatus(1,"New application created succesfully and status updated to Pending ELD/Telematics. ");
			}
			else{
				logStatus(2,"Application not created.");
				numOfFailure++;
			}
			
		}

	
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (numOfFailure > 0) {	Assert.assertTrue(false); }

	}

}
