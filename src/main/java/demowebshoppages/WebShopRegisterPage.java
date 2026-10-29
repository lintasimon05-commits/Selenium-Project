package demowebshoppages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilieswebshop.ExcelWebShopUtilites;

public class WebShopRegisterPage {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\"gender-female\"]")
	WebElement female;
	
	@FindBy(xpath="//*[@id=\"FirstName\"]")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id=\"LastName\"]")
	WebElement lastname;
	
	@FindBy(id="Email")
    WebElement email;
	
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"ConfirmPassword\"]")
	WebElement confirmpassword;
	
	@FindBy(xpath="//*[@id=\"register-button\"]")
	WebElement registerbutton;
	

public WebShopRegisterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	wait=new WebDriverWait(driver, Duration.ofSeconds(10));

	
}

public void login()
{
	register.click();
}

public void logindetails()
{
	female.click();
	firstname.sendKeys("Linta");
	lastname.sendKeys("Simon");
	//email.sendKeys("linta@gmail.com");
	
	String uniqueEmail = "linta" + System.currentTimeMillis() + "@gmail.com";
	String passwordValue="xyz12";
    email.sendKeys(uniqueEmail);
    System.out.println(uniqueEmail);
    ExcelWebShopUtilites.registeredEmail=uniqueEmail;
    ExcelWebShopUtilites.registeredPassword=passwordValue;
	password.sendKeys(passwordValue);
	confirmpassword.sendKeys(passwordValue);
	String pwd = password.getAttribute("value");
	String confirmPwd = confirmpassword.getAttribute("value");
	//wait=new WebDriverWait(driver,Duration.ofSeconds(10));

	if (pwd.equals(confirmPwd)) {
	    System.out.println("Passwords match. Proceeding with registration...");
	    registerbutton.click();
	    
	} else {
	    System.out.println("Passwords do not match! Please re-enter.");
	    Assert.fail("Password and Confirm Password do not match!");
	}
	
}

public void invalidRegistrationShowsErrors() {
	female.click();
	firstname.sendKeys("Linta");
	lastname.sendKeys("Simon");
	email.sendKeys("invalid email");
	password.sendKeys("an");
	confirmpassword.sendKeys("am");

    String emailError = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]")).getText();
    Assert.assertEquals(emailError, "Wrong email");
    System.out.println(emailError);

    String passwordError = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]")).getText();
    Assert.assertEquals(passwordError, "Password is required.");
    System.out.println(passwordError);

    String confirmPasswordError = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]")).getText();
    Assert.assertEquals(confirmPasswordError, "Password is required.");
    System.out.println(confirmPasswordError);
}

}
