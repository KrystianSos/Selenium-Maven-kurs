import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        driver = new ChromeDriver(options);

    }

    @Test
    public void otwarciePrzegladarki(){
        driver.get("http://google.pl");
    }

    @Test
    public void wyszukajLublin(){
        driver.get("http://google.pl");
        driver.findElement(By.cssSelector("[title='Szukaj']")).sendKeys("Lublin");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.RETURN);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        boolean nieZnaleziono = true;
        while (nieZnaleziono) {
            if (driver.findElement(By.cssSelector("[href='https://pl.wikipedia.org/wiki/Lublin']:first-child")).isDisplayed()) {
                nieZnaleziono =false;
            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        driver.findElement(By.cssSelector("[href='https://pl.wikipedia.org/wiki/Lublin']:first-child")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".firstHeading")).getText(), "Lublin[edytuj]");

    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }

}
