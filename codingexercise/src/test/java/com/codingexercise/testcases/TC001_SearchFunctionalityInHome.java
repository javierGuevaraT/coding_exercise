package com.codingexercise.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codingexercise.pageobjects.HomePageIntersys;
import com.codingexercise.pageobjects.SearchPageIntersys;

/**
 * TC001_SearchFunctionalityInHome checks basic search functionality of
 * Intersys home page.
 * 
 * @author javierGuevara
 *
 */
public class TC001_SearchFunctionalityInHome extends TestCaseBase{
	
	//DEFINITIONS
	private HomePageIntersys homeIntersys;
	private SearchPageIntersys searchIntersys;
	
	@BeforeTest
	public void setUp(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		homeIntersys = new HomePageIntersys(driver);
		
	}
	
	@Test
	public void tc001Test(){
		
		driver.get("https://www.intersysconsulting.com/");
		searchIntersys = homeIntersys.searchFunctionality("Subscription Services");
		
		Assert.assertEquals(searchIntersys.getCompanyLinkTextInFooter(),"Company");
	}
	
	@AfterTest
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
