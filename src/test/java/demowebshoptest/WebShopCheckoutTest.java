package demowebshoptest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import demowebshopbase.WebShopBaseClass;

public class WebShopCheckoutTest extends WebShopBaseClass{
	
	@Test(priority=18)
	public void billing()
	{
		checkout.billadres();
	}

	@Test (priority=19)
	public void shipping()
	{
		checkout.shippadres();
	}
	
	@Test(priority=20)
	public void shippingmthd()
	{
		checkout.shipmethod();
	}
	
	@Test(priority=21)
	public void payment()
	{
		checkout.paymentmthd();
	}
	
	@Test(priority=22)
	public void payinfo()
	{
		checkout.infopay();
	}
	
	@Test(priority=23)
	public void orderplaced()
	{
		
		checkout.orderconfirm();
		
	}
	
	
}
