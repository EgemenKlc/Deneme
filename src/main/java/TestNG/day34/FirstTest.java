package TestNG.day34;

import org.testng.annotations.Test;

public class FirstTest
{

    @Test(priority=1)
    void openapp()
    {
        System.out.println("testing 1");
    }

    @Test(priority=20)
    void login()
    {
        System.out.println("testing 2");

    }

    @Test(priority=50)
    void logout()
    {
        System.out.println("testing 3");
    }

}
