package HW21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class DemoGuruLoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private String homeUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

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
        driver.get(homeUrl);
    }


    @Test
    public void positiveLoginTest() {
        String validLogin = "1303";
        driver.findElement(By.name("uid")).sendKeys(validLogin);
        String validPassword = "Guru99";
        driver.findElement(By.name("validPassword")).sendKeys(validPassword);
        driver.findElement(By.name("btnLogin")).click();
        WebElement logOutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
        logOutLink.click();
        driver.switchTo().alert().accept();
        String resultUrl = driver.getCurrentUrl();
        assertEquals(resultUrl, homeUrl);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DataProviderNew.class)
    public void instanceDataProvider(String login, String password) {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("validPassword")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
        String errorText = "User or Password is not valid";
        assertEquals(driver.switchTo().alert().getText(), errorText);
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(resultUrl, homeUrl);
    }

}
