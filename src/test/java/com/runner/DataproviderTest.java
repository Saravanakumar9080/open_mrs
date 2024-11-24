package com.runner;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.Baseclass;

public class DataproviderTest extends Baseclass {
	@Test(dataProvider  ="login")
public void login(String username , String password) {
	launchBrowser("chrome");
 launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 implicitWait(3000);
 driver.findElement(By.name("username")).sendKeys(username);
 driver.findElement(By.name("password")).sendKeys(password);
 driver.findElement(By.xpath("//button[text()=' Login ']")).click();
}

@DataProvider(name = "login")
 public Object [][] dataset() {
	 
	 return new Object [][]
			 {{"",""},{"Admin","Admin123"},{"admin","Admin123"},{"Admin","123"}};
}
}
