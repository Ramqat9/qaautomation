package com.modernemortgage.snap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The EmailValidation program implements an application that compares and
 * validates email ids on Maxwell webpage
 *
 * @author Ram Tarigoppula
 * @version 1.0
 * @since 2021-06-04
 */
public class EmailValidation {
	public static String driver = "webdriver.gecko.driver";
	public static String webBrowserPath = "C:\\geckodriver.exe";
	public static String url = "https://snap.modernemortgage.com/home/mobile-test";
	public static String success = "PASS";
	public static String failure = "FAIL";

	public static void main(String[] args) throws Exception {
		String executionResult;
		System.setProperty(driver, webBrowserPath);
		WebDriver driver = new FirefoxDriver();
		// Launch the webpage
		driver.get(url);
		// Implicitly waiting for the page to load
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		// Retrieve email id from page 1
		String emailIdPage1 = driver.findElement(By.cssSelector("a[href*='mailto']")).getText();
		System.out.println("Email id captured from page 1 : " + emailIdPage1);
		if (null != emailIdPage1 && !emailIdPage1.isEmpty()) {

			// Click on Apply Now
			driver.findElement(By.xpath(".//*[@class='organization-call-to-action-wrapper']/a")).click();
			// Retrieve email id from page 2
			String emailIdPage2 = driver.findElement(By.cssSelector("a[href*='mailto']")).getText();
			System.out.println("Email id captured from page 2 : " + emailIdPage2);
			// Validate the 2 emails
			executionResult = (emailIdPage1.equalsIgnoreCase(emailIdPage2)) ? success : failure;
			System.out.println("Test Execution Result : " + executionResult);

		} else
			executionResult = failure;
		// The below line will close the browser after the execution completes.As the
		// execution will be swift,
		// wanted user to see the action on the page.
		// driver.close();
	}

}
