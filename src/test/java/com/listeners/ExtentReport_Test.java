package com.listeners;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.Baseclass;

public class ExtentReport_Test  {
	
public static ExtentTest extenttest;

  @BeforeSuite
    private void extentTestReportStartup() throws IOException {
     Baseclass base =new Baseclass() {
	};
	base.extentReportStart(null);
	}
  @AfterSuite
  private void extentReportEnd() throws IOException {
	  Baseclass base =new Baseclass() {
		};
		base.extentReportTearDown(null);
	  
}
	
}

