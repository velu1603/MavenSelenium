package com.velan.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.velan.zoho.utilities.DriverManager;

public class ZohoHomePage extends BasePage {
	
	/*public WebDriver driver;
	 
	public ZohoHomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		 
	}*/
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/a[4]")
	public WebElement logIn;
	
	public ZohoHomePage open(String url) {
		
		DriverManager.getDriver().navigate().to(url);
		
		return (ZohoHomePage) openPage(ZohoHomePage.class);
	}
	
	public ZohoLogInPage goToLogin() {
		
		
		click(logIn, "Login link");
		
		//logIn.click();
		
		
		return (ZohoLogInPage) openPage(ZohoLogInPage.class);
		
		
		
		
		
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logIn);
	}
	

}
