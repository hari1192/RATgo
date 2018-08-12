package com.ot.tgo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityManager {
	@FindBy(xpath="//*[@id=\"cm\"]")
	WebElement cm;
	
	
	public CreateCompany clickOnCM(){
		cm.click();
		return new CreateCompany() ;
	}
}


