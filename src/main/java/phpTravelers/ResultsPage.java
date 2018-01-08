package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.transform.Result;
import java.util.List;

/**
 * Created by Aleksandra on 08.01.18.
 */
public class ResultsPage extends AbstractWebPage{
    ResultsPage(WebDriver driver) {
        super(driver);
    }

//    public ResultsPage getArticles(String selector) {
//        List<WebElement> starsResults = driver.findElements(By.cssSelector(selector));
//        return selector;
//    }


    public ResultsPage clickSearchButton() {
    WebElement searchButton = driver.findElement(By.cssSelector("#searchform"));
    searchButton.click();
    return this;
    }

    public ResultsPage selectStars(String stars) {
        WebElement selectStars = driver.findElement(By.cssSelector("div.hpadding20 > div > div:nth-child(9) > div"));
        selectStars.click();
        return this;
    }

    public ResultsPage clickFilterButton() {
        WebElement filterButton = driver.findElement(By.cssSelector("div:nth-child(4) > div > a"));
        filterButton.click();
        return this;
    }

}


