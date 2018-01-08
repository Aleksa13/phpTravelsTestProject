package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksandra on 07.01.18.
 */
public class MainPage extends AbstractWebPage{
    MainPage(WebDriver driver) {
        super(driver);

    }
    public MainPage selectHotelTitle() {
        WebElement hotelTitle = driver.findElement(By.cssSelector("div.RTL_Bar.searcharea > div > ul > li.active > a"));
        hotelTitle.click();
        return this;
    }
}



