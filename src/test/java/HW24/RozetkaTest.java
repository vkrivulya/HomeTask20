package HW24;

import HW24.PageFactory.ComparePageFactory;
import HW24.PageFactory.MonitorPageFactory;
import HW24.PageFactory.MonitorsListPageFactory;
import HW24.PageFactory.RozetkaMainPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RozetkaTest {

    private WebDriver driver;
    private WebDriverWait wait;


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

    }

    @Test
    public void monitorComparisonCheck() {

        RozetkaMainPageFactory rozetkaMainPageFactory = new RozetkaMainPageFactory(driver, wait);
        rozetkaMainPageFactory.monitorsLinkClick();
        MonitorsListPageFactory monitorsListPageFactory = new MonitorsListPageFactory(driver, wait);
        monitorsListPageFactory.findElementsByPrice(driver, 4000);

        MonitorPageFactory monitorPageFactory = new MonitorPageFactory(driver, wait);
        monitorPageFactory.clickMonitorDescription();
        monitorPageFactory.clickCompareButton();
        assertEquals(monitorPageFactory.checkCounter("1"), 1);

        int monitorPrice = MonitorPageFactory.getMonitorPrice(driver);
        monitorPageFactory.navigateBack();

        monitorsListPageFactory.findElementsByPrice(driver, monitorPrice);
        monitorPageFactory.clickMonitorDescription();
        monitorPageFactory.clickCompareButton();
        assertEquals(monitorPageFactory.checkCounter("2"), 2);

        monitorPageFactory.clickComparisonLink();
        ComparePageFactory comparePageFactory = new ComparePageFactory(driver, wait);
        assertEquals(comparePageFactory.elementsListIsMatches(), 2);


    }



}
