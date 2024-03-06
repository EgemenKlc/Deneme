package WebDriver.day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithHiddenOptions {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        //Dropwdown


        driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']")).click();// opens the dropdown

        List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));

        for(WebElement option:options)
        {
            //System.out.println(option.getText());
            if(option.getText().equals("Finance Manager"))
            {
                option.click();
                break;
            }
        }
    }

}
