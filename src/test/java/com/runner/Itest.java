package com.runner;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Itest {
	WebDriver driver;
	@BeforeTest
	private void beforeTest() {
driver =new ChromeDriver();
driver.get("https://www.google.com/");
	}
	@AfterTest
	private void afterTest() {
		driver.quit();

	}
	@Test(retryAnalyzer = Retest.class)
	private void test() {
		String title = driver.getTitle();
		assertEquals(title, "Google");

	}

}
