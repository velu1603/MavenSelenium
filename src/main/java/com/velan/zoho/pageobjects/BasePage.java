package com.velan.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.velan.zoho.ExtendListeners.ExtentListeners;
import com.velan.zoho.utilities.DriverManager;

public abstract class BasePage<T> {
	
	protected WebDriver driver;
	
	public BasePage() {
		
		this.driver=DriverManager.getDriver();
	}
	
	
	public T openPage(Class<T> clazz) {
		
		T page = null;
		
		driver = DriverManager.getDriver();
		
		AjaxElementLocatorFactory ajaxElementFactory = new AjaxElementLocatorFactory(driver,10);
		
		page = PageFactory.initElements(driver, clazz);
		
		PageFactory.initElements(ajaxElementFactory, page);
		
		
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
		
		
		/*
		 * 1st intializing the pagefactory elements
		 * 2nd Page load condition 
		 * 
		 */
		
		
	}
	
	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(pageLoadCondition);
	}
	
	
	
	protected abstract ExpectedCondition getPageLoadCondition();
	
public void click(WebElement element,String elementName) {
		
		
		element.click();
		ExtentListeners.testReport.get().info("Clicking on :"+elementName);
		
	}
	
     public void type(WebElement element,String value,String elementName) {
		
		
		element.sendKeys(value);
		ExtentListeners.testReport.get().info("Typing in :"+elementName+" Entered the value as :"+value);
		
	}
	
	
	
	

}
