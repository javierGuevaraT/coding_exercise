package com.codingexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;
import com.codingexercise.utils.Wait;

/**
 * Class that contains current required web element actions, 
 * services and verification points for this page object. Current page used
 * when something has been searched.
 * 
 * @author javierGuevara
 *
 */
public class SearchPageIntersys extends PageBase{

	//SELENIUM WEB IDENTIFIERS
	private By companyLinkFooterBy;
	
	/**
	 * Constructor of this page object class. It mainly performs action of
	 * getting the web element identifiers and initialize them.
	 * 
	 * @param  driver	 WebDriver object to handle browser instance
	 */
	public SearchPageIntersys(WebDriver driver){
		super.driver = driver;
		
		bySelector = new BySelector("SearchPageIntersys");
		
		initializeWebIdentifiers();
	}
	
	/**
	 * Initialize web element identifiers of this page object class
	 */
	private void initializeWebIdentifiers(){
		companyLinkFooterBy = bySelector.getBy("companyLinkFooter");
	}
	
	//SEARCH PAGE SERVICES
	
	//SEARCH PAGE VERIFICATION POINTS
	
	/**
	 * Get text from company link in footer
	 * 
	 * @return String
	 */
	public String getCompanyLinkTextInFooter(){
		return Wait.getTextUntilVisible(driver, companyLinkFooterBy);
	}
}
