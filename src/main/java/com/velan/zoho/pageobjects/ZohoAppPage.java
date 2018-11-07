package com.velan.zoho.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZohoAppPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'Cliq')]")
	public WebElement cliq;

	@FindBy(xpath = "//*[contains(text(),'Creator')]")
	public WebElement creator;

	@FindBy(xpath = "//*[contains(text(),'CRM')]")
	public WebElement crm;

	@FindBy(xpath = "//*[contains(text(),'Books')]")
	public WebElement books;

	@FindBy(xpath = "//*[contains(text(),'Mail')]")
	public WebElement mail;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(crm);
	}

	public ZohoCRMPage gotoCRM() {
		
		click(crm, "CRM link");
		
		return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	}

	public ZohoCliqPage gotoCliq() {
		
		click(cliq, "cliq link");
		
		return (ZohoCliqPage) openPage(ZohoCliqPage.class);

	}

	public ZohoCreatorPage gotoCreator() {
		click(creator, "Creator link");
		return (ZohoCreatorPage) openPage(ZohoCreatorPage.class);

	}
	
	public ZohoBooksPage gotoBooks() {
		click(books, "Books link");
		return (ZohoBooksPage) openPage(ZohoBooksPage.class);
		
		

	}

	public ZohoMailPage gotoMail() {
		click(mail, "Mail link");
		
		return (ZohoMailPage) openPage(ZohoMailPage.class);
		

	}

	

}
