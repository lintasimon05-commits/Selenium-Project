package demowebshoptest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshopbase.WebShopBaseClass;
import utilieswebshop.ExcelWebShopUtilites;

public class WebShopLoginTest extends WebShopBaseClass {
	
	@Test(priority=3)
	public void logging()

	{
		login.logintab();
	}
	@Test(priority=6)
	public void titleverification()
	{
		String actualtitle=login.titleverify();
		AssertJUnit.assertEquals(actualtitle, "Demo Web Shop");
	}

	 @Test(priority=5)
	 public void validlogin()
	 {
		 login.SetValues("linta@gmail.com", "abc1234");
		 //login.SetValues(ExcelWebShopUtilites.registeredEmail, ExcelWebShopUtilites.registeredPassword);
		 login.loginpage();
		 System.out.println("Login Sucessfully ");
		 System.out.println("Registered Email : " +ExcelWebShopUtilites.registeredEmail);
		 System.out.println("Registered Password : " +ExcelWebShopUtilites.registeredPassword);
		 String expurl="https://demowebshop.tricentis.com/";
		 wait.until(ExpectedConditions.urlToBe(expurl));
		 String acturl=driver.getCurrentUrl();
		 Assert.assertEquals(expurl, acturl);
		 if(expurl.equals(acturl))
		 {
			 System.out.println("URL is matching");
		 }
		 else
		 {
			 System.out.println("URL is not matching. Actual URl" +acturl);
		 }
		 
	 }
	 @DataProvider(name="logindata")
	 public Object[][] getData() throws Throwable
	 {
	        String path="/Users/lintaalbin/Documents/DataDrivenExcel/Book1.xlsx";
			Object[][] data= ExcelWebShopUtilites.getData(path, "DemoWebShopLogin");
		    for (int i = 0; i < data.length; i++) {
		        System.out.println("Row " + (i+1) + ": Username=" + data[i][0] + ", Password=" + data[i][1]);
		        System.out.println("Invalid login creditionals");
		    }
		    return data;
				 
	 }
	 
	 @Test(dataProvider="logindata", priority=4)
	 public void logintest(String username, String password)
	 {
		    driver.findElement(By.id("Email")).clear();
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
			
			System.out.println("Executed for:" +username);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.urlContains("https://demowebshop.tricentis.com/login"));
		
	 }
	 
	 
	 @Test(enabled=false)
	 public void forgotpasswordtest()
	 {
		 login.forgotpassword();
		 driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("linta@gmail.com");
		 driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/input")).click();
		 String message= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div")).getText();
		 Assert.assertEquals(message, "Email with instructions has been sent to you.");
		 
	 }
}
