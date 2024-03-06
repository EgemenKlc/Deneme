package TestNG.day37;

import org.testng.annotations.Test;

public class InvocationCountDemo {

	@Test(invocationCount=5)
	void test()
	{
	System.out.println("testing...");	
	}
	
}
