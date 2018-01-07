package phpTravelers;

import javafx.scene.control.Tab;
import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Aleksandra on 07.01.18.
 */
public class FlightsTest extends BaseTest {

    @Test
    public void mainPageTest() {
        //check that main page is opened

        String url = driver.getCurrentUrl();
        assertEquals(url, "http://www.phptravels.net/", "phpBooking page opened fail");
    }

    @Test
    public void FlightsTest () throws InterruptedException {
        WebElement flightTitle = driver.findElement(By.cssSelector("div.RTL_Bar.searcharea > div > ul > li:nth-child(2) > a"));
        flightTitle.click();

        Thread.sleep(2000);

        WebElement destinationCity = driver.findElement(By.name("destination_name"));
        destinationCity.click();
        destinationCity.clear();
        destinationCity.sendKeys("New York");

        WebElement originCity = driver.findElement(By.name("origin_name"));
        originCity.click();
        originCity.clear();
        originCity.sendKeys("London");



        WebElement passengers = driver.findElement(By.cssSelector("div.mewtwo-flights-trip_class > div"));
        passengers.click();

        WebElement passengersAge= driver.findElement(By.cssSelector("div:nth-child(2) > div.mewtwo-popup-ages-counter > span.mewtwo-popup-ages-counter__plus"));
        passengers.click();


        WebElement searchButton = driver.findElement(By.cssSelector("div.mewtwo-flights-submit_button > button"));
        searchButton.click();



        Thread.sleep(3000);
        driver.get("http://www.flights.phptravels.net/");
        Thread.sleep(3000);


        String url = driver.getCurrentUrl();
        assertTrue(url.contains("http://www.flights.phptravels.net/"),"flights page is not opened");


        //WebElement departDate = driver.findElement(By.cssSelector(" div.mewtwo-flights-dates-depart.mewtwo-flights-dates-depart--focused"));
        //departDate.click();

        //Select departData = new Select(driver.findElement(By.cssSelector("div.mewtwo-flights-dates-depart.mewtwo-flights-dates-depart--focused")));
        //departData.selectByVisibleText("#mewtwo-datepicker-2018-1-10 > div");
    }
}