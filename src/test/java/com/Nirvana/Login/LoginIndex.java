package com.Nirvana.Login;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Nirvana.Init.SeleniumInit;
import com.Nirvana.Utility.TestData;

public class LoginIndex extends SeleniumInit{



	@Test
	public void login() throws IOException{

		int numOfFailure=0;
		int step=1;
		String LoginEmail;
		String Password;

		logStep(step++,"Open URL : "+testUrl);	
		
		System.out.println("Login Thread ID: "+Thread.currentThread().getId());
		
		

		logStep(step++,"Do login with valid email and password.");
		
		//For Data Driven
		File f = new File("UploadData/Sigin.xlsx");
		String SiginExcel = f.getAbsolutePath();
		System.out.println("Absolute  path: "
				+ SiginExcel);
				
		ArrayList<String> EmailExcel = TestData.getColumnData(SiginExcel, "Sigin", "Email");
		ArrayList<String> PasswordExcel = TestData.getColumnData(SiginExcel, "Sigin", "Password");
		
		LoginEmail = EmailExcel.get(0);
		Password = PasswordExcel.get(0);
		
		loginVerification=loginIndexPage.doLogin(LoginEmail, Password);
		log("Entered Email: "+LoginEmail);
		log("Entered Password: "+Password);
		TestData.setValueConfig("uploadConfig.properties","Email",LoginEmail);
		TestData.setValueConfig("uploadConfig.properties","Password",Password);


		if(loginVerification.verifyloginurl()) 
		{
			logStatus(1,"User Logged in succesfully.");
		}
		else{
			logStatus(2,"User did not logged in.");
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		} 

	}
	
	@Test
	public void logout() throws IOException{
		
		int numOfFailure=0;
		int step=1;
		 

		System.out.println("Logout Thread ID: "+Thread.currentThread().getId());
		
		logStep(step++,"Click on logout.");
		loginVerification=loginIndexPage.logout();
		

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		} 
		
	}

}
