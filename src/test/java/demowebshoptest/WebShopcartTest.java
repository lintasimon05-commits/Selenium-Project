package demowebshoptest;

import org.testng.annotations.Test;

import demowebshopbase.WebShopBaseClass;

public class WebShopcartTest extends WebShopBaseClass{

	@Test(priority=12)
	public void itemincart()
	{
		cart.shoppingcart();
	}

   @Test(priority=13)
   public void quantity()
   {
	   cart.updatequantity(2);
   }
   
   @Test(priority=14)
   public void basket()
   {
	   cart.upcart();
   }

   @Test(priority=15)
   public void voucher()
   {
	   cart.coupon();
   }
   
   @Test(priority=16)
   public void validcode()
   {
	   cart.apply();
   }

   @Test(priority=17)
   public void checkoutbutton()
   {
	   cart.termsandcheckout();
   }



}
