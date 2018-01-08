package phpTravelers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksandra on 06.01.18.
 */
public class BaseTest {

    public WebDriver driver;

    @BeforeClass(alwaysRun= true)
    public void setUp()
    {
        //Open chrome browser
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();
        //Set timeouts
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//    @BeforeMethod(alwaysRun = true)
//    public void openMainPage(){
//        //Open page
//        //driver.get("http://phptravels.net/admin");
//        driver.get("http://www.phptravels.net/");
//
//    }

    @AfterClass(alwaysRun = true)
    public void tearDown()

    {
        //Close browse
        driver.quit();

    }
}
