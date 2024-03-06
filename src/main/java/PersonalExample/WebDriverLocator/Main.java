package PersonalExample.WebDriverLocator;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Test driver = new Test("https://yizeng.me/blog/");

        driver.WebdriverInitializer();

        driver.Url_title_validation();

        driver.Taglist();

        driver.Tag_xpath();

        driver.Home_page();

        driver.Quit_driver();


    }
}


