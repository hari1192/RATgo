package com.ot.tgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import com.ot.tgo.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//*[@id=\"cm\"]")
	WebElement communityManager;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement accountManager;
	
	@FindBy(className="gxs")
	WebElement myProfile;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement logOut;
	
	
	
	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		
		public boolean verifyCorrectUserName(){
			String loggedUser=myProfile.getText();			
			return prop.getProperty("username").equals(loggedUser);
		}
		
		public CreateCompany clickOnCM(){
			communityManager.click();
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("size iframe"+size);
			return new CreateCompany() ;
		}
		
		/*public AccountManager clickOnAM(){
			accountManager.click();
			return new AccountManager();
		}
		
		public CreateCompany createCompany() {
			communityManager.click();
			return new CreateCompany() ;
		}*/
}
