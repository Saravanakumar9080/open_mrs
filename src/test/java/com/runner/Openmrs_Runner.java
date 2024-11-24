package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.baseclass.Baseclass;
import com.interfaceelements.OpenmrsInterfaceElements;
import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.ProjectManagerOpenmrs;
@Listeners(ITestListenerClass.class)

public class Openmrs_Runner extends Baseclass implements OpenmrsInterfaceElements {
	ProjectManagerOpenmrs pageObjectManager = new ProjectManagerOpenmrs();
	@BeforeTest
	public void setUp() throws IOException {
       launchBrowser(pageObjectManager.getFilereader().getDataProperty("browser"));

	}
	//@Test(priority = 0)
	@Test
	private void validLoginTest() {
		ExtentReport_Test.extenttest = extentreports.createTest("login test" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("valid login");
      Assert.assertTrue(pageObjectManager.getLoginpage().validlogin(ExtentReport_Test.extenttest));
	}
	//@Test(priority = -5)
//	@Test(dependsOnMethods = "withoutLocation")
//	private void invalidLoginTest() {
//	      Assert.assertTrue(pageObjectManager.getLoginpage().invalidlogin());
//	}
//	//@Test(priority = -10)
//	@Test()
//	private void emptyinput() {
//	      Assert.assertTrue(pageObjectManager.getLoginpage().emptyInput());
//	}
//	//@Test(priority = -8)
//	@Test(dependsOnMethods = "emptyinput")
//	private void withoutLocation() {
//	     Assert.assertTrue(pageObjectManager.getLoginpage().withoutLocation());
//	}
	@AfterTest
	private void terminate() {
     terminateBrowser();
	}
	@BeforeSuite
	private void extendStartUp() {
      extentReportStart("C:\\Users\\sk\\eclipse-workspace\\Openmrs\\Reports");
	}
	@AfterSuite
	private void extendReportEnd() throws IOException {
      extentReportTearDown("C:\\Users\\sk\\eclipse-workspace\\Openmrs\\Reports\\index.html");
	

	}

}
