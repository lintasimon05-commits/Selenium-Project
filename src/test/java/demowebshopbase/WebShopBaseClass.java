package demowebshopbase;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import demowebshoppages.WebShopCartPages;
import demowebshoppages.WebShopCheckoutPage;
import demowebshoppages.WebShopHomePage;
import demowebshoppages.WebShopLoginPage;
import demowebshoppages.WebShopRegisterPage;

public class WebShopBaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public WebShopLoginPage login;
	public WebShopHomePage home;
	public WebShopCartPages cart;
	public WebShopCheckoutPage checkout;
	public WebShopRegisterPage register;

	
	@BeforeTest
	public void setup()
	{
		reporter = new ExtentSparkReporter("./Reports/webshopreport.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "macOS");
		extent.setSystemInfo("testername", "Linta");
		extent.setSystemInfo("Browser name", "Chrome");
		//ChromeOptions options=new ChromeOptions();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
				
	}
   
	@BeforeMethod
	public void intializepages(Method mthd)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		register=new WebShopRegisterPage(driver);
		login=new WebShopLoginPage(driver);
		home=new WebShopHomePage(driver);
		cart=new WebShopCartPages(driver);
		checkout=new WebShopCheckoutPage(driver);
		
		
		
		
		test=extent.createTest(mthd.getName());
		
		
			
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed is " +result.getName());
			test.log(Status.FAIL, "Test case failed is " +result.getThrowable());
			String screenshotpath=screenshotMethod(driver, result.getName());//previous run test name is getting using getname
			test.addScreenCaptureFromPath(screenshotpath);
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case passed is " +result.getName());
		}
	}

	public static String screenshotMethod(WebDriver driver, String screenshotname) throws Exception {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./Screenshot/"+screenshotname +".jpeg";
		FileHandler.copy(src, new File(destination));
		return destination;
		
		
	}
	
}
