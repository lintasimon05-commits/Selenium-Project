package demowebshoppages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;





public class WebShopCheckoutPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement billcontinue;
	
	
	@FindBy(xpath="//*[@id=\"shipping-buttons-container\"]/input")
	WebElement shipadrscontinue;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement shipmthdcontinue;
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement paymentconti;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement payinfoconti;
	
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmorder;
	
	public WebShopCheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	
	public void billadres()
	{
		billcontinue.click();
	}
	
	public void shippadres()
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement addressdrop=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-address-select\"]")));
		Select select =new Select(addressdrop);
		select.selectByValue("5153251");
		shipadrscontinue.click();
	}

	public void shipmethod()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement groundshipping=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shippingoption_0\"]")));
		groundshipping.click();
		
		WebElement nextdayshipping=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shippingoption_1\"]")));
		nextdayshipping.click();
		
		WebElement dayair=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shippingoption_2\"]")));
		dayair.click();
		
		shipmthdcontinue.click();
		
	}
	
	public void paymentmthd()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement cashdelivery=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"paymentmethod_0\"]")));
		cashdelivery.click();
		
		paymentconti.click();
	}
	
	public void infopay()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the cell 
		WebElement priceInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.info")));
        String value = priceInfo.getText();// Get the text
		System.out.println("Displayed value: " + value);
		payinfoconti.click();
	
	}
	
	public void orderconfirm()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement confirmbtn=wait.until(ExpectedConditions.elementToBeClickable(confirmorder));
		confirmbtn.click();
		WebElement sucessmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")));
		String actmsg=sucessmsg.getText();
		String expmsg="Your order has been successfully processed!";
		Assert.assertEquals(actmsg, expmsg);
		if(expmsg.equals(actmsg))
		{
			System.out.println("Thank You!!  Your order has been successfully processed!");
		}
		else
		{
			System.out.println("Order not placed");
		}
		WebElement conti=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")));
		conti.click();
			
		
	
	}
}
