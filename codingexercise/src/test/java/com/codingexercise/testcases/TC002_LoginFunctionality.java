package com.codingexercise.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codingexercise.pageobjects.BadLoginPageFacebook;
import com.codingexercise.pageobjects.JustLoginPageFacebook;
import com.codingexercise.pageobjects.LoginPageFacebook;

/**
 * TC002_LoginFunctionality tests one path of login functionality when
 * using incorrect password.
 * 
 * @author javierGuevara
 *
 */
public class TC002_LoginFunctionality extends TestCaseBase{

	//DEFINITIONS
	private LoginPageFacebook loginFacebook;
	private BadLoginPageFacebook badLoginFacebook;
	private JustLoginPageFacebook justloginFacebook;
	
	@BeforeTest
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		loginFacebook = new LoginPageFacebook(driver);
	}
	
	@Test
	public void tc002Test(){
		
		driver.get("https://www.facebook.com/");
		badLoginFacebook = loginFacebook.badLogin("franciscojavierguevaratrujillo@hotmail.com", "dfgh");
		justloginFacebook = badLoginFacebook.notYouOption();
		
		String loginLabelText = justloginFacebook.getLoginLabelText();
		
		Assert.assertTrue(loginLabelText.equals("Log into Facebook") ||
						  loginLabelText.equals("Inicia sesión en Facebook"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
