package demowebshoppages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebShopCartPages {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"topcartlink\"]/a")
	//@FindBy(id="topcartlink")
	WebElement carttext;
	
	@FindBy(name="updatecart")
	//@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]")
	WebElement updatecart;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[1]/div[1]/div[3]/input[1]")
	WebElement typecode;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[1]/div[1]/div[3]/input[2]")
	WebElement applycode;
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement checkoutbutton;
	
	public WebShopCartPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
	}

public void shoppingcart()
{
	carttext.click();
}
	
public void updatequantity(int qty)
{
    WebElement qtyBox = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@name,'itemquantity')]")
        )
    );
    qtyBox.clear();
    qtyBox.sendKeys(String.valueOf(qty));
}

	
public void upcart()
{
	updatecart.click();
}
	
public String coupon()
{
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	typecode.clear();
	typecode.sendKeys("welcome");
	String actualvalue=typecode.getAttribute("value");
	System.out.println("Typed code: "  +actualvalue);
	return actualvalue;
	
	
}

public void apply()
{
	applycode.click();
	WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[1]/div[1]/div[4]")));
	System.out.println("Code result :" +message.getText());
	
}
	
public void termsandcheckout()
{
	WebElement termscheckbox=wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice")));
	if(!termscheckbox.isSelected())
	{
		termscheckbox.click();
	}
	checkoutbutton.click();
}

}

