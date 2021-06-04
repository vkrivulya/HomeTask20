package HW24;

import HW24.PageFactory.MobilePhonesListPageFactory;
import HW24.PageFactory.RozetkaMainPageFactory;
import HW24.PageFactory.SamsungProductsListPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RozetkaTest2 {

    public static final String EXCEPTION_TEXT = " :is not present";

    private WebDriver driver;
    private WebDriverWait wait;
    private MobilePhonesListPageFactory mobilePhonesListPageFactory;


    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @BeforeMethod
    public void navigateAction() {
        String homeUrl = "https://rozetka.com.ua";
        driver.get(homeUrl);
        RozetkaMainPageFactory rozetkaMainPageFactory = new RozetkaMainPageFactory(driver, wait);
        SamsungProductsListPageFactory samsungProductsListPage = new SamsungProductsListPageFactory(driver, wait);
        mobilePhonesListPageFactory = new MobilePhonesListPageFactory(driver, wait);
        rozetkaMainPageFactory.searchProduct("samsung");
        rozetkaMainPageFactory.clickOnSearchButton();
        samsungProductsListPage.mobilePhonesButtonClick();

    }


    @Test
    public void searchManufacturers() {
        mobilePhonesListPageFactory.selectManufacturer();
        assertTrue(mobilePhonesListPageFactory.verifyProductsListByName(), "APPLE, SAMSUNG or HUAWEI " + EXCEPTION_TEXT);
    }


    @Test
    public void searchByPrice() {
        mobilePhonesListPageFactory.setPrice();
        mobilePhonesListPageFactory.clickOnSubmitButton();
        assertTrue(mobilePhonesListPageFactory.verifyProductsListByPrice(), "Price from 5000 to 15000 " + EXCEPTION_TEXT);
    }

    @Test
    public void searchBuiltInMemory() {
        mobilePhonesListPageFactory.setMemoryToFilter();
        assertTrue(mobilePhonesListPageFactory.verifyProductsListByMemory(), "128Gb " + EXCEPTION_TEXT);

    }


}
