package demowebshoptest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshopbase.WebShopBaseClass;

public class WebShopHomeTest extends WebShopBaseClass{
	
	@Test(priority=11)
	public void comp()
	{
		home.compmousehover();
	}
	
	@Test(priority=9)
	public void hometab()
	{
		home.homebar();
	}
    @Test(priority=7)

	public void alerthandle()
	{
		home.alert();
	}
	@Test(priority=8)
	public void linkcount()
	  {
		 
		  List<WebElement> linklist=driver.findElements(By.tagName("a"));
		  int actualcount=linklist.size();
		  int expectedcount=85;
		  System.out.println("Total number of links:  " + actualcount);
		  Assert.assertEquals(actualcount, expectedcount);
		  
		  
	  }
	
	@Test(priority=10)
	public void search()
	{
	    home.searchbar();
	}
}
