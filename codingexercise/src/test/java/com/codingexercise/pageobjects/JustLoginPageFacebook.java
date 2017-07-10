package com.codingexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;
import com.codingexercise.utils.Wait;

/**
 * Class that contains current required web element actions, 
 * services and verification points for this page object. Facebook page
 * only for login.
 * 
 * @author javierGuevara
 *
 */
public class JustLoginPageFacebook extends PageBase{

	//SELENIUM WEB IDENTIFIERS
	private By loginLabelBy;
	
	/**
	 * Constructor of this page object class. It mainly performs action of
	 * getting the web element identifiers and initialize them.
	 * 
	 * @param  driver	 WebDriver object to handle browser instance
	 */
	public JustLoginPageFacebook(WebDriver driver) {
		super.driver = driver;
		
		bySelector = new BySelector("JustLoginPageFacebook");
		
		initializeWebIdentifiers();
	}
	
	/**
	 * Initialize web element identifiers of this page object class
	 */
	private void initializeWebIdentifiers(){
		loginLabelBy = bySelector.getBy("loginLabel");
	}
	
	//JUST LOGIN PAGE FACEBOOK SERVICES
	
	//JUST LOGIN PAGE FACEBOOK VERIFICATION POINTS
	
	/**
	 * Get text from label of only login page
	 * 
	 * @return String
	 */
	public String getLoginLabelText(){
		return Wait.getTextUntilVisible(driver, loginLabelBy);
	}
}
