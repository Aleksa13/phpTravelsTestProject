package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Aleksandra on 07.01.18.
 */
public class HotelsTest extends BaseTest {
    MainPage firstPage;
    ResultsPage secondPage;

        @BeforeMethod(alwaysRun = true)


    public void openMainPage() throws InterruptedException {
            firstPage = new MainPage(driver);
            firstPage.openPage("http://www.phptravels.net/");
        }


    @Test
    public void mainPageTest() {
        //check that main page is opened

        String url = firstPage.getPageUrl();
        assertEquals(url, "http://www.phptravels.net/", "phpBooking page opened fail");
    }

    @Test (dataProvider = "Hotels", dataProviderClass = TestDataProvider.class)
    public void hotelsTest(String name, String checkInDates, String checkOutDates, int childIndex, int index)throws InterruptedException {
        //check Hotels
        firstPage.selectHotelTitle()
                .enterCity(name)
                .checkInDate(checkInDates)
                .checkOutDate(checkOutDates);

        Thread.sleep(2000);

        firstPage.childIndex(childIndex)
                .kidsAge(index)
                .clickDoneButton();

        Thread.sleep(2000);

        firstPage.clickSearchButton();

        String url = driver.getCurrentUrl();
        assertTrue(url.contains( "http://www.phptravels.net/properties/search?city="), "phpSearch page opened fail");
    }


     public void openResultsPage() throws InterruptedException {
            secondPage = new ResultsPage(driver);

        String url = secondPage.getPageUrl();
        assertTrue(url.contains( "http://www.phptravels.net/properties/search?city="), "phpSearch page opened fail");

     }

     @Test(dataProvider = "Results", dataProviderClass = TestDataProvider.class)
     public void resultsTest(String stars) {

         secondPage
                 .clickFilterButton()
                 .selectStars(stars)
                 .clickSearchButton();


         //List<WebElements>??

         WebElement searchResult1 = driver.findElement(By.cssSelector(" tr:nth-child(1) > td > div.col-md-4.col-xs-5.go-right.rtl_pic > div > a > img"));
         WebElement searchResult2 = driver.findElement(By.cssSelector(" tr:nth-child(2) > td > div.col-md-4.col-xs-5.go-right.rtl_pic > div > a > img"));
         WebElement searchResult3 = driver.findElement(By.cssSelector(" tr:nth-child(3) > td > div.col-md-4.col-xs-5.go-right.rtl_pic > div > a > img"));


     }


}

