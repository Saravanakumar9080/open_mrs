package com.baseclass;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class Baseclass {
	private static final String FileUtils = null;
	public static WebDriver driver;
	public static ExtentReports extentreports;
	public static File file;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

			}

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING LAUNCHURL");
		}
		return driver;
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLOSING BROWSER");

		}

	}

	protected static void terminateBrowser() {

		try {
			driver.quit();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING TERMINATE THE BROWSER");

		}

	}

	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATE BROWSER");

		}

	}

	protected static void navigateBack() {
		try {
			driver.navigate().back();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATEBACK");

		}

	}

	protected static void navigateForward() {
		try {
			driver.navigate().forward();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATEFORWARD");

		}

	}

	protected static void navigateRefresh() {
		try {
			driver.navigate().refresh();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING NAVIGATEREFRESH");

		}

	}

	protected void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ACCEPT ALERT");

		}

	}

	protected static void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING ACCEPT DISMISS");

		}

	}

	protected static void gettextAlert() {
		try {
			driver.switchTo().alert().getText();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING GETTEXT ALERT");

		}

	}

	protected static void sendkeyAlert(String alert) {
		try {
			driver.switchTo().alert().sendKeys(alert);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SENDKEY ALERT");

		}

	}

	protected static Actions action_method() {
		Actions action = new Actions(driver);
		return action;
	}

	protected static void moveElement(WebElement element) {
		try {
			action_method().moveToElement(element).perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING MOVETOELEMENT");

		}

	}

	protected static void contextClick(WebElement element) {
		try {
			action_method().contextClick(element).perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CONTEXTCLICK");

		}

	}

	protected static void doubleClick(WebElement element) {
		try {
			action_method().doubleClick(element).perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING DOUBLECLICK");

		}

	}

	protected static void dragAndDrop(WebElement source, WebElement destination) {
		try {
			action_method().dragAndDrop(source, destination).perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING DRAGANDDROP");

		}

	}

	protected static void clickAndHold(WebElement element) {
		try {
			action_method().clickAndHold().perform();

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLICKANDHOLD");

		}

	}

	protected static Robot robot_Method() throws AWTException {
		Robot robot = new Robot();
		return robot;
	}

	protected static void keypress() {
		try {
			robot_Method().keyPress(KeyEvent.KEY_PRESSED);
			robot_Method().keyRelease(KeyEvent.KEY_RELEASED);

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING KEYFUCTION");

		}

	}

//	protected static void windowHandles(int num) {
//		try {
//			List<String> allwindow = new ArrayList(driver.getWindowHandles());
//			driver.switchTo().window(allwindow.get(num));
//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCUR DURING WINDOWHANDLES");
//
//		}
//
//	}

	protected static void frame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FRAMES");

		}

	}

	protected static void frame_Name(String text) {
		try {
			driver.switchTo().frame(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FRAMES");

		}
	}

	protected static void frame_Element(WebElement frameelement) {
		try {
			driver.switchTo().frame(frameelement);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FRAMES");

		}
	}

	protected static Select select_Method(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByIndex(WebElement element, int index) {
		try {
			select_Method(element).selectByIndex(index);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECTBYINDEX");

		}

	}

	protected static void selectByValue(WebElement element, String text) {
		try {
			select_Method(element).selectByValue(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECTBYVALUE");

		}

	}

	protected static void selectByVisibleText(WebElement element, String text) {
		try {
			select_Method(element).selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECTBYVISIBLETEXT");

		}

	}

	protected static void getOptions(WebElement element, String text) {
		try {
			select_Method(element).getOptions();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING SELECTBYVISIBLETEXT");

		}

	}
	protected static void passingInput(WebElement element,String text) {
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING PASSINGINPUT");

		}
	}
	protected static void clickFunction(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLICK");

		}
	}
	protected static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING CLEAR");

		}
	}

	protected static String Screenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("F:\\Saravanakumar\\"+ timestamp +".png");
		org.openqa.selenium.io.FileHandler.copy(source, destination);
		return destination.getAbsolutePath();
	}


	protected static void javaScript(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (value.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,500);");
		} else if (value.equalsIgnoreCase("up")) {
			js.executeScript("window.scrollBy(0,-3000);");
		}
	}
	protected static void validation(String actual,String expect) {
		try {
			Assert.assertEquals(actual, expect);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING VALIDATION");

		}

	}
	protected static void implicitWait(int num) {
		 driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
			}
	public static void extentReportStart(String location) {
		try {
			extentreports =new ExtentReports();
			file =new File(location);
			ExtentSparkReporter sparkreporter =new ExtentSparkReporter(file);
			extentreports.attachReporter(sparkreporter);
			extentreports.setSystemInfo("OS", System.getProperty("os.name"));
			extentreports.setSystemInfo("Java version", System.getProperty("java.version"));
			
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING EXTENTREPORT");

		}
		
	}
	public static void extentReportTearDown(String location) throws IOException {
		extentreports.flush();
		file =new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
}
