package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Aleksandra on 06.01.18.
 */
public class phpTravelersTest {
        private WebDriver driver;

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

        @BeforeMethod(alwaysRun = true)
        public void openMainPage(){
            //Open ss.com page
            driver.get("http://phptravels.net/admin");

        }

        @AfterClass(alwaysRun = true)
        public void tearDown()

        {
            //Close browse
            driver.quit();

        }

    @Test
    public void mainPageTest() {
        //check that main page is opened

        String url = driver.getCurrentUrl();
        assertEquals(url ,"http://phptravels.net/admin","phptravels admins page opened fail");


    }

    @Test
    public void adminLoginTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("admin@phptravels.com")
                .enterPassword("demoadmin")
                .clickLogin();

        Thread.sleep(2000);


        String pageTitle = driver.getTitle();
        assertFalse(pageTitle.equals("Administator Login"),"login failed");


    }




    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][] {
                { "demo@phptravels.com", "demoadmin" },
                { "admin@phptravels.com", "demoaasfdmin" }};

    }


    @Test(dataProvider = "Authentication", dataProviderClass = phpTravelersTest.class)
    public void adminNegativeLoginTest (String email, String pass) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(2000);

        loginPage.enterEmail(email)
        .enterPassword(pass)
        .clickLogin();

        Thread.sleep(2000);


        String pageTitle = driver.getTitle();
        softAssert.assertTrue(pageTitle.equals("Administator Login"), "Login failed");

        softAssert.assertTrue(loginPage.isErrorDisplayed(),"Alert is not displayed" );
        softAssert.assertAll();

    }



}
