package com.velan.zoho.testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.velan.zoho.pageobjects.ZohoAppPage;
import com.velan.zoho.pageobjects.ZohoHomePage;
import com.velan.zoho.pageobjects.ZohoLogInPage;
import com.velan.zoho.utilities.Constants;
import com.velan.zoho.utilities.DataProviders;
import com.velan.zoho.utilities.DataUtil;
import com.velan.zoho.utilities.ExcelReader;

public class ValidateCRMTest extends BaseTest  {
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void validateCRMTest(Hashtable<String, String> data) {

		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		//DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside validate CRM test");
		openBrowser(data.get("browser"));
		loginfo("Launched browser"+data.get("browser"));

		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com");
		ZohoLogInPage login = home.goToLogin();
		ZohoAppPage app = login.doLoginAsvalidUser(getDefaultUsername(), getDefaultPassword());
		loginfo("username entered as "+getDefaultUsername()+" and password entered as " +  getDefaultPassword());
		
		app.gotoCRM();
		
		//Assert.fail("Failing the login test");

		

	}
	
	@AfterMethod
	public void tearDown() {
		
		loginfo("Login test completed");
		
		quit();
	}
	
	

}
