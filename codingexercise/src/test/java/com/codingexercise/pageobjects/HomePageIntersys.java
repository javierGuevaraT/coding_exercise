package com.codingexercise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;
import com.codingexercise.utils.Wait;

/**
 * Class that contains current required web element actions, 
 * services and verification points for this page object. Initial page
 * of Intersys web site.
 * 
 * @author javierGuevara
 *
 */
public class HomePageIntersys extends PageBase{

	//SELENIUM WEB IDENTIFIERS
	private By magnifyingGlassButtonBy;
	private By searchTextFieldBy;
	private By searchButtonBy;
	
	/**
	 * Constructor of this page object class. It mainly performs action of
	 * getting the web element identifiers and initialize them.
	 * 
	 * @param  driver	 WebDriver object to handle browser instance
	 */
	public HomePageIntersys(WebDriver driver){
		super.driver = driver;
		
		bySelector = new BySelector("HomePageIntersys");
		
		initializeWebIdentifiers();
	}
	
	/**
	 * Initialize web element identifiers of this page object class
	 */
	private void initializeWebIdentifiers(){
		magnifyingGlassButtonBy = bySelector.getBy("magnifyingGlassButton");
		searchTextFieldBy = bySelector.getBy("searchTextField");
		searchButtonBy = bySelector.getBy("searchButton");
	}
	
	//HOME PAGE SERVICES
	
	/**
	 * Search based on text in intersys home page
	 * 
	 * @param searchText String that represents the search
	 * @return SearchPageIntersys
	 */
	public SearchPageIntersys searchFunctionality(String searchText){
		
		Wait.clickUntilReady(driver, magnifyingGlassButtonBy);
		driver.findElement(searchTextFieldBy).sendKeys(searchText);
		driver.findElement(searchButtonBy).click();
		
		return new SearchPageIntersys(driver);
	}
	
	//HOME PAGE VERIFICATION POINTS 
}
