package com.codingexercise.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.codingexercise.utils.JSONDeserializer;
import com.codingexercise.utils.TestLogger;

/**
 * Base class that contains main attributes for all test case
 * classes and test suite setup.
 * 
 * @author javierGuevara
 *
 */
public class TestCaseBase {

	protected WebDriver driver;
	
	/**
	 * Detects operating system to execute correct gecko driver
	 * for browser handling and test execution. Also loads all 
	 * web identifiers.
	 */
	@BeforeSuite
	public void initialSetUp(){
		
		String OS = System.getProperty("os.name").toLowerCase();
		TestLogger.mainLogger.info("OS detected: " + OS);
		
		if(OS.contains("mac")){
			System.setProperty("webdriver.gecko.driver", "macos_geckodriver");
			TestLogger.mainLogger.info("macos_geckodriver selected.");
		}
		else if(OS.contains("win")){
			System.setProperty("webdriver.gecko.driver", "win_geckodriver.exe");
			TestLogger.mainLogger.info("win_geckodriver.exe selected.");
		}
		
		JSONDeserializer.initialize();
	}
}
