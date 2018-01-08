package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Aleksandra on 07.01.18.
 */
public class MainPage extends AbstractWebPage{

    //@FindBy(name = "cityName")
    //WebElement enterCity;

    MainPage(WebDriver driver) {
        super(driver);

    }
    public MainPage selectHotelTitle() {
        WebElement hotelTitle = driver.findElement(By.cssSelector("div.RTL_Bar.searcharea > div > ul > li.active > a"));
        hotelTitle.click();
        return this;
    }
    public MainPage enterCity(String name) {
            WebElement enterCity = driver.findElement(By.cssSelector("#citiesInput"));
            enterCity.click();
            //enterCity.clear();
            enterCity.sendKeys(name);
        return this;

    }

    public MainPage checkInDate(String checkInDates) {
        WebElement checkInDate = driver.findElement(By.cssSelector("#dpean1 > input"));
        checkInDate.click();
        checkInDate.clear();
        checkInDate.sendKeys(checkInDates);
        return this;

    }

    public MainPage checkOutDate(String checkOutDates) {
        WebElement checkOutDate = driver.findElement(By.cssSelector("#dpd2 > input"));
        checkOutDate.click();
        checkOutDate.clear();
        checkOutDate.sendKeys(checkOutDates);
        return this;
    }

    public MainPage clickSearchButton() {
        WebElement searchButton = driver.findElement(By.cssSelector("div.bgfade.col-md-4.col-xs-12 > button"));
        searchButton.click();
        return this;
    }

    public MainPage clickDoneButton() {
        WebElement agesDoneButton = driver.findElement(By.cssSelector("#ages > div > div > div.modal-footer > button"));
        agesDoneButton.click();
        return this;
    }

    public MainPage kidsAge(int index) {
        Select kidsAge = new Select(driver.findElement(By.cssSelector("div.modal-body > div > div > select")));
        kidsAge.selectByIndex(index);
        return this;
    }

    public MainPage  childIndex(int childIndex) {
        Select childCount =new Select(driver.findElement(By.id("child")));
        childCount.selectByIndex(childIndex);
        return this;
    }

}



