package phpTravelers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aleksandra on 06.01.18.
 */
public class LoginPage {

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passInput;

    @FindBy(css = "form.form-signin> button")
    WebElement loginButton;

    @FindBy (css = ".alert")
    WebElement alert;

    private WebDriver driver;

    LoginPage( WebDriver driver){
        this.driver = driver;
        driver.get("http://phptravels.net/admin");
    }

    public LoginPage enterEmail(String email) {
       // WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.clear();
        emailInput.sendKeys(email);
        return  this;
    }

    public LoginPage enterPassword(String password) {
        //WebElement passInput =driver.findElement(By.name("password"));
        passInput.clear();
        passInput.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        //WebElement loginButton =driver.findElement(By.cssSelector("form.form-signin> button"));
        loginButton.click();
    }
    public boolean isErrorDisplayed() {
        //WebElement alert = driver.findElement(By.cssSelector(".alert"));
        return alert.isDisplayed();
    }
}
