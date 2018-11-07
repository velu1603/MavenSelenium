package com.velan.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoLogInPage extends BasePage {

	@FindBy(xpath = "//*[@id='lid']")
	public WebElement email;

	@FindBy(xpath = "//*[@id='pwd']")
	public WebElement pass;

	@FindBy(xpath = "//*[@id='signin_submit']")
	public WebElement signin;

	public ZohoLogInPage doLoginAsInvalidUser(String username, String password) {

		type(email, username, "Usrname textbox");
		type(pass, password, "password textbox");
		click(signin, "Sign in Button");

		return this;

	}
	
	public ZohoAppPage doLoginAsvalidUser(String username, String password) {

		type(email, username, "Usrname textbox");
		type(pass, password, "password textbox");
		click(signin, "Sign in Button");

		return (ZohoAppPage) openPage(ZohoAppPage.class);

	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(email);
	}
}
