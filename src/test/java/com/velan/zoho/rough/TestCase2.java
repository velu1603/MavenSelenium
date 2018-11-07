package com.velan.zoho.rough;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.velan.zoho.pageobjects.ZohoHomePage;
import com.velan.zoho.pageobjects.ZohoLogInPage;
import com.velan.zoho.testcases.BaseTest;
import com.velan.zoho.utilities.DataProviders;
import com.velan.zoho.utilities.DriverManager;

public class TestCase2 extends BaseTest { 

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void doLogin(String username, String password, String browser) {

		openBrowser(browser);

		ZohoHomePage home = new ZohoHomePage();

		ZohoLogInPage login = home.goToLogin();

		login.doLoginAsvalidUser("trainer@way2automation.com", "selenium@1234");

		/*getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div/a[4]")).click();
		getDriver().findElement(By.xpath("//*[@id='lid']")).sendKeys(username);
		getDriver().findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		getDriver().findElement(By.xpath("//*[@id='signin_submit']")).click();*/

		quit();

	}

	

}
