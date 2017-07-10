package com.codingexercise.pageobjects;

import org.openqa.selenium.WebDriver;

import com.codingexercise.utils.BySelector;

/**
 * Base class that contains main attributes for all page
 * object classes
 * 
 * @author javierGuevara
 *
 */
public class PageBase {

	protected WebDriver driver;
	protected BySelector bySelector;
}
