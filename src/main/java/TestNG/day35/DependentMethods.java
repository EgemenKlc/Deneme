package TestNG.day35;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentMethods {

	@Test(priority=1)
	void openapp()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search()
	{
		System.out.println("asdasda");
		Assert.assertTrue(false);
		System.out.println("After Fail");

	}
	
	@Test(priority=4, dependsOnMethods= {"login","search"})
	void advsearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=5, dependsOnMethods= {"login"})
	void logout()
	{
		Assert.assertTrue(true);
	}
}


