package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
        @BeforeMethod(alwaysRun = true)
    public void openMainPage() throws InterruptedException {
        //Open page
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
    public void hotelsTest (String checkinDates , String checkOutDates, int childIndex)throws InterruptedException {
        //check Hotels
        firstPage.selectHotelTitle();

        WebElement enterCity = driver.findElement(By.cssSelector("div #citiesInput"));
        enterCity.click();
        enterCity.clear();
        enterCity.sendKeys("London");

        WebElement checkInDate = driver.findElement(By.cssSelector("#dpean1 > input"));
        checkInDate.click();
        checkInDate.clear();
        checkInDate.sendKeys(checkinDates);


        WebElement checkOutDate =driver.findElement(By.cssSelector("#dpd2 > input"));
        checkOutDate.click();
        checkOutDate.clear();
        checkOutDate.sendKeys(checkOutDates);
        //checkInDate.click();



        Select childCount =new Select(driver.findElement(By.id("child")));
        childCount.selectByIndex(childIndex);

        Thread.sleep(2000);

        Select kidsAge = new Select(driver.findElement(By.cssSelector("#ages > div > div > div.modal-body > div > div > select")));
        kidsAge.selectByIndex(2);

        WebElement agesDoneButton = driver.findElement(By.cssSelector("#ages > div > div > div.modal-footer > button"));
        agesDoneButton.click();


        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.cssSelector("div.bgfade.col-md-4.col-xs-12 > button"));
        searchButton.click();



        //Select enterDay = new Select(driver.findElement(By.cssSelector("body > div:nth-child(17)")));
        //enterDay.enterDay ("body > div:nth-child(17) > div.datepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(4)");

//    }
//
//    @Test
//    public void TestSearchPage () throws InterruptedException {

        String url = driver.getCurrentUrl();
        assertTrue(url.contains( "http://www.phptravels.net/properties/search?city="), "phpSearch page opened fail");
    }




//    @Test
//    public void FlightsTest() throws InterruptedException {




}
