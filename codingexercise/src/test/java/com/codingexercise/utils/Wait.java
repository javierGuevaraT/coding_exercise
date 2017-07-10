package com.codingexercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wait class is an implementation of explicit Selenium waiters with 
 * static methods.
 * 
 * @author javierGuevara
 *
 */
public class Wait{

	/**
	 * Performs click when specific element is detected as clickable.
	 * 
	 * @param driver WebDriver instance
	 * @param by By object to identify web element
	 */
	public static void clickUntilReady(WebDriver driver,By by){

		WebDriverWait wait = new WebDriverWait(driver, 10);
 
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();;
	}
	
	/**
	 * Gets text of web element when specific element is visible.
	 * 
	 * @param driver WebDriver instance
	 * @param by By object to identify web element
	 */
	public static String getTextUntilVisible(WebDriver driver,By by){

		WebDriverWait wait = new WebDriverWait(driver, 10);
 
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(by))).getText();
	}
	
	/**
	 * Sets text in web element when specific element is visible.
	 * 
	 * @param driver WebDriver instance
	 * @param by By object to identify web element
	 * @param text String to set in web element
	 */
	public static void setTextUntilVisible(WebDriver driver,By by, String text){

		WebDriverWait wait = new WebDriverWait(driver, 10);
 
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by))).sendKeys(text);;
	}
}
