package com.pageobjectmodel;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseclass.Baseclass;
import com.interfaceelements.OpenmrsInterfaceElements;
import com.sourceresource.FileReader_Openmrs;

public class OpenmrsLoginpage extends  Baseclass implements OpenmrsInterfaceElements{
         
	@FindBy(id = username_id)
	private WebElement username;
	
	@FindBy(name = password_name)
	private WebElement password;
	
	@FindBy(id = location_id)
	private WebElement location;
	
	@FindBy(id = login_id)
	private WebElement login;
	
	@FindBy(xpath = error_xpath)
	private WebElement error;
	
	@FindBy(xpath  = locationError_xpath)
	private WebElement location_e;
	
	public OpenmrsLoginpage(WebDriver driver) {
       PageFactory.initElements(driver, this);
	}
	
	public boolean validlogin(ExtentTest extenttest) {
		try {
			FileReader_Openmrs data =new FileReader_Openmrs();
			launchUrl(data.getDataProperty("url"));
			passingInput(username, data.getDataProperty("usernameinput"));
			passingInput(password, data.getDataProperty("passwordinput"));
			clickFunction(location);
			clickFunction(login);
			validation(driver.getTitle(), data.getDataProperty("title"));
			extenttest.log(Status.PASS, "login success");
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING VALIDATION");
			extenttest.log(Status.FAIL, "login failed" + e.getMessage());

		}
		return true;

	}
//	public boolean invalidlogin() {
//		try {
//			FileReader_Openmrs data =new FileReader_Openmrs();
//			launchUrl(data.getDataProperty("url"));
//			passingInput(username, data.getDataProperty("usernameinput"));
//			passingInput(password, data.getDataProperty("passworddetails"));
//			clickFunction(location);
//			clickFunction(login);
//			validation(error.getText(), data.getDataProperty("error"));
//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCUR DURING VALIDATION");
//
//		}
//		return true;
//
//	}
//	public boolean emptyInput() {
//		try {
//			FileReader_Openmrs data =new FileReader_Openmrs();
//			launchUrl(data.getDataProperty("url"));
//			passingInput(username, data.getDataProperty("empty"));
//			passingInput(password, data.getDataProperty("empty"));
//			clickFunction(location);
//			clickFunction(login);
//			validation(error.getText(), data.getDataProperty("error"));
//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCUR DURING VALIDATION");
//
//		}
//		return true;
//
//	}
//	public boolean withoutLocation() {
//		try {
//			FileReader_Openmrs data =new FileReader_Openmrs();
//			launchUrl(data.getDataProperty("url"));
//			passingInput(username, data.getDataProperty("usernameinput"));
//			passingInput(password, data.getDataProperty("passwordinput"));
//			clickFunction(login);
//			validation(location_e.getText(), data.getDataProperty("locationerr"));
//						
//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCUR DURING VALIDATION");
//
//		}
//		return true;
//
//	}
	

}
