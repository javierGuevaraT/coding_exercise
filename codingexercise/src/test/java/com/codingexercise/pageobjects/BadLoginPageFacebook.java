package com.codingexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;
import com.codingexercise.utils.Wait;

/**
 * Class that contains current required web element actions, 
 * services and verification points for this page object.
 * 
 * @author javierGuevara
 *
 */
public class BadLoginPageFacebook extends PageBase{

	//SELENIUM WEB IDENTIFIERS
	private By notYouLinkBy;
	
	/**
	 * Constructor of this page object class. It mainly performs action of
	 * getting the web element identifiers and initialize them.
	 * 
	 * @param  driver	 WebDriver object to handle browser instance
	 */
	public BadLoginPageFacebook(WebDriver driver){
		super.driver = driver;
		
		bySelector = new BySelector("BadLoginPageFacebook");
		
		initializeWebIdentifiers();
	}
	
	/**
	 * Initialize web element identifiers of this page object class
	 */
	private void initializeWebIdentifiers(){
		notYouLinkBy = bySelector.getBy("notYouLink");
	}
	
	//BAD LOGIN PAGE SERVICES
	
	/**
	 * Click on Not You link to continue the flow of bad login.
	 * 
	 * @return JustLoginPageFacebook
	 */
	public JustLoginPageFacebook notYouOption(){
		
		Wait.clickUntilReady(driver, notYouLinkBy);
		
		return new JustLoginPageFacebook(driver);
	}
	
	//BAD LOGIN PAGE VERIFICATION POINTS
}
