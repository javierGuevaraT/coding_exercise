package com.codingexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;
import com.codingexercise.utils.Wait;

/**
 * Class that contains current required web element actions, 
 * services and verification points for this page object. Initial page
 * of Facebook web site, Login.
 * 
 * @author javierGuevara
 *
 */
public class LoginPageFacebook extends PageBase{

	//SELENIUM WEB IDENTIFIERS
	private By emailTextFieldBy;
	private By passwordTextFieldBy;
	private By loginButtonBy;
	
	/**
	 * Constructor of this page object class. It mainly performs action of
	 * getting the web element identifiers and initialize them.
	 * 
	 * @param  driver	 WebDriver object to handle browser instance
	 */
	public LoginPageFacebook(WebDriver driver){
		super.driver = driver;
		
		bySelector = new BySelector("LoginPageFacebook");
		
		initializeWebIdentifiers();
	}
	
	/**
	 * Initialize web element identifiers of this page object class
	 */
	private void initializeWebIdentifiers(){
		emailTextFieldBy = bySelector.getBy("emailTextField");
		passwordTextFieldBy = bySelector.getBy("passwordTextField");
		loginButtonBy = bySelector.getBy("loginButton");
		
	}
	
	//LOGIN PAGE SERVICES
	
	/**
	 * Service of login page to be used for bad login
	 * 
	 * @param email	String to be used as email for logging
	 * @param password String to used as password for logging
	 * @return BadLoginPageFacebook
	 */
	public BadLoginPageFacebook badLogin(String email, String password){
		
		Wait.setTextUntilVisible(driver, emailTextFieldBy, email);
		driver.findElement(passwordTextFieldBy).sendKeys(password);
		driver.findElement(loginButtonBy).click();
		
		return new BadLoginPageFacebook(driver);
	}
	
	//LOGIN PAGE VERIFICATION POINTS
}
