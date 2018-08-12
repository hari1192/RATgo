package com.ot.tgo.testcases;

import org.testng.Assert;


import org.testng.annotations.*;

import com.ot.tgo.base.TestBase;
import com.ot.tgo.pages.CompanyProfile;
import com.ot.tgo.pages.CreateCompany;
import com.ot.tgo.pages.HomePage;
import com.ot.tgo.pages.LoginPage;
import com.ot.tgo.pages.SubscriptionPage;
import com.ot.tgo.util.TestUtil;
import com.ot.tgo.util.WebEventListener;

public class SubscriptionTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	CreateCompany createcompany;
	SubscriptionPage subscriptionpage;
	WebEventListener webeventlistener;
	public SubscriptionTest() {
		super();
	}
	
	
	
	
	@BeforeTest
	public void loginPageTitleTest(){
		initialization();
		 loginpage=new LoginPage();	
		 createcompany=new CreateCompany();
		 homepage=new HomePage();
		 subscriptionpage=new SubscriptionPage();
		 webeventlistener=new WebEventListener();
		 
		String title=loginpage.validLoginPageTitle();
		Assert.assertEquals(title, "OpenText Trading Grid Online");
		System.out.println("url"+driver.getCurrentUrl());
		
		if(prop.getProperty("url_prod").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
		
			loginpage.login(prop.getProperty("username_prod"),prop.getProperty("password_prod"));
		}else if(prop.getProperty("url_PP").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
			
			loginpage.login(prop.getProperty("username_PP"),prop.getProperty("password_PP"));
		}else if(prop.getProperty("url_iqa").substring(8, 18).contains(driver.getCurrentUrl().substring(8,18))){
			loginpage.login(prop.getProperty("username_iqa"),prop.getProperty("password_iqa"));
		}else {
			Assert.fail("Incorrect URl");
		}
		
		
	}
	
	/*@Test(priority=1,dataProvider="getcmpTestData")
	public void createCompanyTest(String companyName) throws InterruptedException {
		 
		
		 homepage.clickOnCM();
		if(!createcompany.createCompany(companyName)) {
			Assert.fail("Company Creation Failed");
		}else {
			webeventlistener.onExceptionSuccess(driver);
		}
	}*/
	
	@Test(priority=1)
	public void createCompanyTest()  {
		 
		
		 homepage.clickOnCM();
		if(!createcompany.createCompany()) {
			Assert.fail("Company Creation Failed");
		}else {
			webeventlistener.onExceptionSuccess(driver);
		}
	}
	
	
	@Test(priority=2)
	public void subscribeServiceTest( ) {
		subscriptionpage.subscribeServiceBundle();
		webeventlistener.onExceptionSuccess(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
	
	/* @DataProvider
	 public Object[][] getcmpTestData() {
		Object data[][]=TestUtil.getTestData("cmpname");
		 return data;
	 }
	*/
}
