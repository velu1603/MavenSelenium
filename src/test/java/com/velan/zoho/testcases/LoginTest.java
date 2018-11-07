package com.velan.zoho.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.velan.zoho.pageobjects.ZohoHomePage;
import com.velan.zoho.pageobjects.ZohoLogInPage;
import com.velan.zoho.utilities.Constants;
import com.velan.zoho.utilities.DataProviders;
import com.velan.zoho.utilities.DataUtil;
import com.velan.zoho.utilities.DriverManager;
import com.velan.zoho.utilities.ExcelReader;

public class LoginTest extends BaseTest {  

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void loginTest(Hashtable<String, String> data) {

		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		//DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		loginfo("Launched browser"+data.get("browser"));

		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com");
		ZohoLogInPage login = home.goToLogin();
		login.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		loginfo("username entered as "+(data.get("username")+" and password entered as " +  data.get("password")));
		//Assert.fail("Failing the login test");

		

	}
	
	@AfterMethod
	public void tearDown() {
		
		loginfo("Login test completed");
		
		quit();
	}

}
