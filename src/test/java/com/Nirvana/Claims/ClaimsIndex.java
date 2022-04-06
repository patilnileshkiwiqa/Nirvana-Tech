package com.Nirvana.Claims;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Nirvana.Init.SeleniumInit;
import com.Nirvana.Utility.TestData;

public class ClaimsIndex extends SeleniumInit{



	@Test
	public void claimsPage() throws IOException{

		int numOfFailure=0;
		int step=1;

		logStep(step++,"Open URL : "+testUrl);	
		
		logStep(step++,"Click on claims tab");
		claimsVerification = claimsIndexPage.claimsPageTab();
		
		if(claimsVerification.verifyClaimsPagel()) 
		{
			logStatus(1,"Claims page loaded succesfully.");
		}
		else{
			logStatus(2,"Claims page not loaded .");
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		} 

	}

}
