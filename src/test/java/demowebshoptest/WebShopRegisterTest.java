package demowebshoptest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demowebshopbase.WebShopBaseClass;

public class WebShopRegisterTest extends WebShopBaseClass{
	
	@BeforeMethod
	public void openRegistrationPage()
	{
	    driver.get("https://demowebshop.tricentis.com/register");
	}
	@Test
	public void signpage()
	{
		register.login();
	}
	
	@Test(priority=2)
	public void signin()
	{
		register.logindetails();
	}

	@Test(priority=1)
	public void invalidlogin()
	{
		register.invalidRegistrationShowsErrors();
	}
}
