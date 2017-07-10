package com.codingexercise.utils;

import java.util.HashMap;

import org.openqa.selenium.By;

/**
 * BySelector gets web element identifiers from collection already
 * loaded in memory from json file
 * 
 * @author javierGuevara
 *
 */
public class BySelector {

	private HashMap<String,String> pageIdentifiers;
	
	/**
	 * Constructor that selects specific page object list 
	 * with web identifiers
	 * 
	 * @param pageObject String that represents the page object where
	 * 						web identifiers are located
	 */
	public BySelector(String pageObject){
	
		pageIdentifiers = JSONDeserializer.getPageIdentifiers(pageObject);
	}
	
	/**
	 * Gets value of specific web identifier in previously selected
	 * page object in constructor
	 * 
	 * @param webIdentifier String of specific web identifier
	 * @return By (xpath or id)
	 */
	public By getBy(String webIdentifier){
		
		String identifier = pageIdentifiers.get(webIdentifier);
		
		if(identifier.startsWith("/")){
			return By.xpath(identifier);
		}
		else{
			return By.id(identifier);
		}
	}
	
}
