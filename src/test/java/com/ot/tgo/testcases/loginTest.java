package com.ot.tgo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.*;

import com.ot.tgo.base.TestBase;
import com.ot.tgo.pages.HomePage;
import com.ot.tgo.pages.LoginPage;

public class loginTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public loginTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage=new LoginPage();		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.validLoginPageTitle();
		Assert.assertEquals(title, "OpenText Trading Grid Online");
	}
	
	@Test(priority=2)
	public void loginPageTest() {
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
	
	
}
