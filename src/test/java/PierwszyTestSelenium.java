import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PierwszyTestSelenium {

    WebDriver driver;
    ChromeOptions options;

    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Tester\\Desktop\\shop\\shop\\Selenium\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");

    }

    @Test
    public void otwarciePrzegladarki(){

        driver = new ChromeDriver(options);

    }

    @AfterMethod
    public void zamknij(){
        driver.close();
    }

}
