package com.codingexercise.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class used for getting elements of json file and allocate them
 * into respective maps
 * 
 * @author javierGuevara
 *
 */
public class JSONDeserializer {

	private static HashMap<String,HashMap<String,String>> mapPages;
	
	/**
	 *  Loads elements from json file and initialize maps with 
	 *  these elements.
	 */
	public static void initialize(){
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			TestLogger.mainLogger.debug("Locating src/test/java/resources/webIdentifiers.json");
			mapPages = mapper.readValue(
					new File("src/test/java/resources/webIdentifiers.json"),
					new TypeReference<HashMap<String, HashMap<String,String>>>(){});
			TestLogger.mainLogger.debug("webIdentifiers.json file was correctly mapped");
			
		} catch (IOException e) {

			TestLogger.mainLogger.error("webIdentifiers.json could not be read");
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets respective HashMap that contains element identifiers 
	 * based on page object.
	 * 
	 * @param pageObject String that represents the page object of 
	 * 						desired element identifiers
	 * @return HashMap<String,String>
	 */
	public static HashMap<String,String> getPageIdentifiers(String pageObject){
		return mapPages.get(pageObject);
	}
}
