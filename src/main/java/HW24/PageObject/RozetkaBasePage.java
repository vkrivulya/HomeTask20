package HW24.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public RozetkaBasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void navigateBack(){
        driver.navigate().back();
    }
}
