package HW24.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaBasePageFactory {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public RozetkaBasePageFactory(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void navigateBack(){
        driver.navigate().back();
    }
}
