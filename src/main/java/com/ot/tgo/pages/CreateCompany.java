package com.ot.tgo.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.ot.tgo.base.TestBase;
import com.ot.tgo.util.TestUtil;

public class CreateCompany extends TestBase {

	public static final String CHAR_LIST = "1234567890";
	public static final int RANDOM_STRING_LENGTH =5;
	
	@FindBy(id="centerpanel")
	WebElement iFrame;
	
	@FindBy(xpath="//*[@id=\"actionsbar\"]/form/table[2]/tbody/tr/td/table/tbody/tr/td[2]/input")
	WebElement createOTCompany;
	
	@FindBy(name="companyDetails.companyName")
	WebElement companyName;
	
	@FindBy(name="companyDetails.companyAddress.city")
	WebElement city;
	
	@FindBy(name="companyDetails.companyAddress.state")
	WebElement state;
	
	@FindBy(name="companyDetails.companyAddress.country")
	WebElement drpCountry;
	
	@FindBy(name="companyDetails.billingDetails.billingAddress.country")
	WebElement billingcountry;
	
	@FindBy(xpath="//*[@id=\"container22\"]/table/tbody/tr/td/input[2]")
	WebElement nextStep;
	
	@FindBy(xpath="//*[@id=\"cm\"]")
	WebElement cm;
	
	
	public CreateCompany() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean createCompany() {
		driver.switchTo().frame("serviceArea");
		driver.switchTo().frame("centerpanel");
		createOTCompany.click();
		//companyName.sendKeys(prop.getProperty("cmpName"));
		companyName.sendKeys(TestUtil.generateRandomString());
		//companyName.sendKeys(cmp);
		city.sendKeys("abc");
		state.sendKeys("ka");
		Select dropdown = new Select(drpCountry);  
		dropdown.selectByValue("US");
		Select billingCountry = new Select(billingcountry);  
		billingCountry.selectByValue("US");
		nextStep.click();
		return  companyProfile();
	}
	
	
	
	@FindBy(name="companyDetails.companyAddress.address1")
	WebElement address;
	@FindBy(name="companyDetails.companyAddress.zipCode")
	WebElement zipcode;
	@FindBy(name="companyDetails.testCompany") WebElement testcmp;
	@FindBy(name="companyDetails.businessContact.firstName")
	WebElement firstName;
	@FindBy(name="companyDetails.businessContact.lastName")
	WebElement lastName;
	@FindBy(name="companyDetails.businessContact.telephone")
	WebElement telephone;
	@FindBy(name="companyDetails.businessContact.email")
	WebElement email;
	@FindBy(xpath="//*[@id=\"compInfo\"]/table/tbody/tr[22]/td/div/input ")
	WebElement technicalContact;
	@FindBy(xpath="//*[@id=\"compInfo\"]/table/tbody/tr[22]/td/div/input") WebElement businessContact;
	@FindBy(xpath="//*[@id=\"payForTPsType\"]") WebElement sponsoringTP;
	@FindBy(xpath="//*[@id=\"companyDetails.billingDetailsLst[0].billingAddressAsCompany\"]") WebElement billingAddr;
	@FindBy(name="companyDetails.billingDetailsLst[0].attention") WebElement attention;
	@FindBy(id="companyDetails.billingDetailsLst[0].paymentMethod") WebElement paymentmethod;
	@FindBy(xpath="//*[@id=\"container22\"]/div[5]/table/tbody/tr/td/input[2]") WebElement nextstep;
	@FindBy(xpath="//*[@id=\"subContainter\"]/div[3]/table/tbody/tr/td/input[2]") WebElement create;
	
	
	public boolean companyProfile() {
		address.sendKeys("Test");
		zipcode.sendKeys("TEST123");
		testcmp.click();
		firstName.sendKeys("TestSel");
		lastName.sendKeys("TestSel");
		telephone.sendKeys("123456789");
		email.sendKeys("vsrihari@opentext.com");
		businessContact.click();
		sponsoringTP.click();
		attention.sendKeys("Test");
		billingAddr.click();
		
		Select paymenttype = new Select(paymentmethod);  
		paymenttype.selectByValue("10004");
		nextstep.click();
		create.click();
	return companyCreated();
	
	}
	
	@FindBy(xpath="//*[@id=\"container22\"]/div[2]/b") WebElement success;
	public boolean companyCreated() {
		
	//	Assert.assertEquals(success.getText(), "The company has been successfully created.","Company Creation Failed");
		if(success.getText().equals("The company has been successfully created.")) {
			return true;
		}else {
		return false;
		}
	}
	
public static String generateRandomString(){
        
        StringBuffer randStr = new StringBuffer("HCTEST");
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.append("2018").toString();
    }
	 private static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	 
	 @DataProvider
	 public Object[][] getcmpTestData() {
		Object data[][]=TestUtil.getTestData("cmpname");
		 return data;
	 }
	
}
