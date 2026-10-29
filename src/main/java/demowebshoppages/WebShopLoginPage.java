package demowebshoppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilieswebshop.ExcelWebShopUtilites;

public class WebShopLoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement demologin;
	
	@FindBy(id="Email")
	WebElement loginemail;
	
	@FindBy(id="Password")
	WebElement loginpass;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	WebElement loginbutton;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a")
	WebElement forgotpass;
	
	
	public WebShopLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void logintab()
	{
		demologin.click();
	}
	public void SetValues(String username, String password)
	{
		loginemail.clear();
		//loginemail.sendKeys(ExcelWebShopUtilites.registeredEmail);
		loginemail.sendKeys(username);
		loginpass.clear();
		loginpass.sendKeys(password);
		//loginpass.sendKeys(ExcelWebShopUtilites.registeredPassword);
		
		
	}
	
	public void loginpage()
	{
		loginbutton.click();
		
	}
	
	public String titleverify()
	{
		return driver.getTitle();
		
	}
	
	public void forgotpassword()
	{
		forgotpass.click();
	}
	
	

}
