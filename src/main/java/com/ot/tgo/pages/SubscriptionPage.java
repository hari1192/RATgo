package com.ot.tgo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ot.tgo.base.TestBase;
import com.ot.tgo.util.TestUtil;

public class SubscriptionPage extends TestBase{

	
	
	@FindBy(xpath="//*[@id=\"container22\"]/table[2]/tbody/tr[1]/td[2]/li/a") WebElement subsc;
	@FindBy(name="subscriptionVO.serviceSelectionMode") WebElement nonONEStack;
	@FindBy(name="subscriptionVO.serviceSelectionMode1") WebElement oneStack;
	//@FindBy(xpath="//*[@id=\"nonOnestackDev\"]/table/tbody/tr/td[2]/table/tbody/tr[13]/td[3]/table/tbody/tr[281]/td/input") WebElement tgms;
	@FindBy(xpath="//input[@value='50747']") WebElement tgms_iqa;
	@FindBy(xpath="//input[@value='3936']") WebElement tgms_pp;
	@FindBy(xpath="//input[@value='4168']") WebElement tgms_prod;
	@FindBy(id="next") WebElement nxt;
	@FindBy(name="serviceSelectionByAdminVO.ediDetails[0].qualifier") WebElement qualifier;
	@FindBy(name="serviceSelectionByAdminVO.ediDetails[0].address") WebElement EdiAddr;
	//@FindBy(xpath="//*[@id=\"serviceSelectionByAdminVO.priceBundleDetails[0].bundleType\"]") WebElement priceBundletype;
	@FindBy(xpath="//input[@value='nonStd']") WebElement priceBundletype;
	@FindBy(name="next") WebElement next1;
	@FindBy(xpath="//input[@value='29608']") WebElement commMethod_iqa;
	@FindBy(xpath="//input[@value='14683']") WebElement commMethod_pp;
	@FindBy(xpath="//input[@value='15836']") WebElement commMethod_prod;
	//pre-prod  14683  iqa   29608 15836
	@FindBy(xpath="//input[@value='Submit']") WebElement Submit;
	@FindBy(xpath="//*[@id=\"container21\"]/div[1]/table[1]/tbody/tr[4]/td[2]") WebElement mailbox;
	@FindBy(partialLinkText="Service Subscription Complete")WebElement subscComplete;
	
	public SubscriptionPage() {
		PageFactory.initElements(driver, this);
	
}
	
	public void subscribeServiceBundle() {
		
		subsc.click();
		nonONEStack.click();
		
		//Select tgms bundle 
		
		if(prop.getProperty("url_prod").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
		
			tgms_prod.click();
		}else if(prop.getProperty("url_PP").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
			
			tgms_pp.click();
		}else if (prop.getProperty("url_iqa").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
			tgms_iqa.click();
		}
		
		nxt.click();
		qualifier.sendKeys("zxc");
		EdiAddr.sendKeys(TestUtil.generateRandomString());
		priceBundletype.click();
		next1.click();
		
		//Select comm method
		
				if(prop.getProperty("url_prod").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
				
					commMethod_prod.click();
				}else if(prop.getProperty("url_PP").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
					
					commMethod_pp.click();
				}else if (prop.getProperty("url_iqa").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
					commMethod_iqa.click();
				}
		
		next1.click();
		
		next1.click();
		
		next1.click();
		
		Submit.click();
		if(!subscComplete.isEnabled()) {
			Assert.fail("TGMS Subsc failed");
		}else {
			System.out.println("Subscription Successfull and Mailbox is:"+mailbox.getText().trim());
		}
	}
}
