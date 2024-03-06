package org.WebD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo1 {
	public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
	Thread.sleep(5000);

    //Open app
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize(); // maximize browser window

    //search box
		driver.findElement(By.name("search_query")).sendKeys("final Space");

    //search button
		driver.findElement(By.id("search-icon-legacy")).click();

    //link text & partial linktext
    //driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		//driver.findElement(By.partialLinkText("Printed Chiffon")).click();




}
}
