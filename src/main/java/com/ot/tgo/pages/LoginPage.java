package com.ot.tgo.pages;

import com.ot.tgo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	//page factory -OR:
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"Submit\"]")
	WebElement loginBtn;
	
	@FindBy(className="gxs")
	WebElement userDetails;
	
	//Initializing Page objects:
	public LoginPage() {
		PageFactory.initElements(driver,this);
		//PageFactory.initElements(driver,LoginPage.class);
	}
	
	//Actions
	public String validLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) {
		
	 username.sendKeys(un);
	 password.sendKeys(pwd);
	 loginBtn.click();
	 return new HomePage();
	}
	
}
