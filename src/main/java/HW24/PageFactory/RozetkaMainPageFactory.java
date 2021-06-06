//package HW24.PageFactory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
//
//public class RozetkaMainPageFactory extends RozetkaBasePageFactory {
//
//    @FindBy(css = "input[name='search']")
//    WebElement bySearchInput;
//    @FindBy(css = "button[class*='button_color_green']")
//    WebElement searchButton;
//
//    @FindBy(linkText = "Ноутбуки и компьютеры")
//    WebElement laptopsAndComputersLink;
//    @FindBy(linkText = "Мониторы")
//    WebElement monitorsLink;
//
//    public void monitorsLinkClick() {
//        WebElement laptopsAndComputers = wait.until(visibilityOf(laptopsAndComputersLink));
//        Actions hover = new Actions(driver);
//        hover.moveToElement(laptopsAndComputers).build().perform();
//        wait.until(visibilityOf(monitorsLink)).click();
//    }
//
//
//    public RozetkaMainPageFactory(WebDriver driver, WebDriverWait wait) {
//        super(driver, wait);
//        PageFactory.initElements(driver, this);
//    }
//
//    public void clickOnSearchButton() {
//        wait.until(visibilityOf(searchButton)).click();
//    }
//
//    public void searchProduct(String searchText) {
//        wait.until(visibilityOf(bySearchInput)).sendKeys(searchText);
//    }
//}
