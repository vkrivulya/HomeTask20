package HW24.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RozetkaMainPage extends RozetkaBasePage {


    By bySearchInput = By.cssSelector("input[name='search']");
    By searchButton = By.cssSelector("button[class*='button_color_green']");

    By laptopsAndComputersLink = By.linkText("Ноутбуки и компьютеры");
    By monitorsLink = By.linkText("Мониторы");

    public void monitorsLinkClick(){
        WebElement laptopsAndComputers = wait.until(presenceOfElementLocated(laptopsAndComputersLink));
        Actions hover = new Actions(driver);
        hover.moveToElement(laptopsAndComputers).build().perform();
        wait.until(presenceOfElementLocated(monitorsLink)).click();
    }



    public RozetkaMainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnSearchButton(){
        wait.until(presenceOfElementLocated(searchButton)).click();
    }

    public void searchProduct(String searchText){
        wait.until(presenceOfElementLocated(bySearchInput)).sendKeys(searchText);
    }
}
