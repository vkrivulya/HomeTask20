package HW23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class CookieTest {

        private WebDriver driver;

        private final String homeUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

        @BeforeClass
        public void setupBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @AfterClass
        public void closeBrowser() {
            driver.quit();
        }

        @BeforeMethod
        public void navigateAction() {
            driver.get(homeUrl);
        }


        @Test(priority = 1)
        public void positiveLoginTest() {
            String validLogin = "1303";
            driver.findElement(By.name("uid")).sendKeys(validLogin);
            String validPassword = "Guru99";
            driver.findElement(By.name("password")).sendKeys(validPassword);
            driver.findElement(By.name("btnLogin")).click();
        }

        @Test(priority = 2)
        public void cookiesDelete() {
            String navUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
            driver.navigate().to(navUrl);
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println(cookies);
            Cookie auth = driver.manage().getCookieNamed("PHPSESSID");
            driver.manage().deleteCookie(auth);
            driver.navigate().refresh();
        }

        @Test(priority = 3)
        public void checkVerifySession() {
            String resultUrl = driver.getCurrentUrl();
            assertEquals(resultUrl, homeUrl);
        }



}

