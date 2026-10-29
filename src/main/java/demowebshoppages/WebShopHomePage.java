package demowebshoppages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebShopHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a")
	WebElement books;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
	WebElement computers;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[3]/a")
	WebElement electronics;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a")
	WebElement apparel;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[5]/a")
	WebElement downloads;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")
	WebElement jewelry;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[2]/ul[1]/li[7]/a")
	WebElement giftcards;
	
	@FindBy(xpath="//*[@id=\"small-searchterms\"]")
	WebElement searchfield;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")
	WebElement searchbutton;
	
	@FindBy(xpath="//*[@id=\"products-orderby\"]")
	WebElement selectbox;
	
	@FindBy(tagName="a")
	List<WebElement>allATags;
	
	public WebShopHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	
		
	}
	public void homebar()
	{
		books.click();
		electronics.click();
		apparel.click();
		downloads.click();
		jewelry.click();
		giftcards.click();
	}
     public void compmousehover()
     {
    	 
    	 WebElement computers=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));		 
    	 Actions act=new Actions(driver);
    	 act.moveToElement(computers).perform();
    	 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"))).click();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button-72\"]"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topcartlink\"]/a"))).click();
           
   
     }

     public void alert()
     {
    	 try
    	 {
    		 Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // Wait for alert
             System.out.println("Alert says: Change Password " + alert.getText());  // Get alert text
             alert.accept(); // Click OK 
    	 }catch(TimeoutException e)
    	 {

       	  System.out.println("No JavaScript alert appeared — it may be an HTML popup.");
    	 }
  	
     }
     
     public int getLinkCount()
 	{
 		return allATags.size();
 	}
     
    public void searchbar()
     {
    searchfield.sendKeys("laptop");
    searchbutton.click();
    	
     }
}
