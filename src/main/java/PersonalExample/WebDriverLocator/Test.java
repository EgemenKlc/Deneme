package PersonalExample.WebDriverLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test {
     public String Test_Url;
     public String WebSiteTitle;
     WebDriver driver;


    public Test(String test_Url) {
        Test_Url = test_Url;
    }
    public void WebdriverInitializer() throws InterruptedException {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Test_Url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    public void Url_title_validation() {
        String url;
        url = driver.getCurrentUrl();
        WebSiteTitle = driver.getTitle();
        if("https://yizeng.me/blog/".equals(url))
        {
            System.out.println("Test Case Url Validation: passed   -->   Url is Correct.");
        }
        else {
            System.out.println("Test Case Url Validation: failed   --> Url Does not match!");
        }
        if("All Posts | Yi Zeng’s Blog".equals(WebSiteTitle))
        {
            System.out.println("Test Case Title Validation: passed   --> title is Correct");
        }
        else {
            System.out.println("Test Case Title Validation: failed   --> title does not match");
        }

    }

    public void Taglist () throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='Tags']")).click();
        Thread.sleep(3000);
        if("https://yizeng.me/blog/tags/".equals(driver.getCurrentUrl()))
        {
            System.out.println("Test Case TagList Url : passed   -->   Url is Correct.");

            //List<WebElement> tag_list = driver.findElements(By.xpath("//*[@id=\"page\"]/div/div/div/div/article/div/div/div/div/ul[1]/li"));
            //System.out.println("Total number of tags:"+ tag_list.size());
            List<WebElement> tagBoxElements = driver.findElements(By.className("tag_box"));

            int liItemCount = 0;

            String[] liItemTitle = new String[]{""};

            for (WebElement tagBoxElement : tagBoxElements) {
                // tag_box elementi içindeki li elementlerini bul
                List<WebElement> liElements = tagBoxElement.findElements(By.tagName("li"));

                for( WebElement link : liElements)
                {
                    int i=0;
                    WebElement Li_Title = link.findElement(By.tagName("a"));

                    liItemTitle[i]= Li_Title.getAttribute("title");

                    System.out.print("Tag List names:   " +liItemTitle[i]+", ");
                    System.out.println();
                    i++;
                }
                liItemCount += liElements.size();
            }
            System.out.println("tag_list içindeki toplam item sayısı: " + liItemCount);

        }
        else {
            System.out.println("Test Case TagList Url : failed   --> Url Does not match!");
        }

    }

    public void Tag_xpath() throws InterruptedException {

        driver.findElement(By.cssSelector("a[href*='blog/tags/#xpath']")).click();
        Thread.sleep(3000);
        if("https://yizeng.me/blog/tags/#xpath".equals(driver.getCurrentUrl()))
        {
            System.out.println("Test Case Xpath Url_validation : passed   -->   Url is Correct.");

            driver.findElement(By.cssSelector("a[href*='/2017/01/15/tips-for-locating-elements-in-ext-js-applications-with-selenium-webdriver/']")).click();
            Thread.sleep(3000);
            System.out.println("Tips for locating elements page is opened");
        }
        else {
            System.out.println("Test Case Xpath Url_validation : failed   --> Url Does not match!");
        }


        }

    public void Home_page() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[4]/header/div/div/nav/ul/li[1]/a")).click();
        Thread.sleep(3000);
        System.out.println("Returned to the Home Page");
    }

    public void Quit_driver(){

        driver.quit();
        System.out.println("Browser Closed.");

    }
}

