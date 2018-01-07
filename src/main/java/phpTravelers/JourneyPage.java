package phpTravelers;

import org.openqa.selenium.WebDriver;

/**
 * Created by Aleksandra on 07.01.18.
 */
public class JourneyPage {
    private WebDriver driver;

    JourneyPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://phptravels.net/");
    }}

//    public JourneyPage checkInDate(int checkInDate){
//            //WebElement checkInDate = driver.findElement(By.cssSelector("#dpean1 > input"));
//            checkInDate.click();
//            checkInDate.clear();
//            checkInDate.sendKeys("date");
//            return this;
//        }
//    }

