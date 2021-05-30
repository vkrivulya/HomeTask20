package HW23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class SendGmailTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private String homeUrl = "https://gmail.com";

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
    public void sendEmailCheck() throws AWTException {
        WebElement email = wait.until(presenceOfElementLocated(By.id("identifierId")));
        email.sendKeys("vkryvulia@gmail.com");

        WebElement nextButton = wait.until(presenceOfElementLocated(By.cssSelector("[class*='DuMIQc']")));
        nextButton.click();

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        password.sendKeys("vkryvulia123");
        WebElement nextButton2 = wait.until(presenceOfElementLocated(By.cssSelector("[class*='DuMIQc']")));
        nextButton2.click();

        WebElement newEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='T-I T-I-KE L3']")));
        newEmail.click();
        WebElement addressee = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        addressee.sendKeys("vkryvulia@gmail.com");
        WebElement subjectEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("subjectbox")));
        subjectEmail.sendKeys("some subject text");
        WebElement bodyEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='Am Al editable LW-avf tS-tW']")));
        bodyEmail.sendKeys("some text");

//        WebElement upload_file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='Filedata']")));
//        WebElement upload_file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='attach']")));
//        WebElement upload_file = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='vI']")));
//        upload_file.sendKeys ("/Users/v.kryvulia/Desktop/file.txt");

        WebElement attachButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='a1 aaA aMZ']")));
        attachButton.click();

        Robot robot = new Robot();
        StringSelection ss = new StringSelection("/Users/v.kryvulia/Desktop/file.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement sendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")));
        sendButton.click();

        WebElement inbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-tooltip='Входящие']")));
        inbox.click();

        WebElement incomingEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'bog') and contains (.,'some subject text')]")));
        incomingEmail.click();

        WebElement incomingSubjectText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class, 'hP')]")));
        assertTrue(incomingSubjectText.getText().contains("some subject text"));

        WebElement incomingBodyText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'a3s aiL ')]")));
        assertTrue(incomingBodyText.getText().contains("some text"));

        WebElement incomingAttachment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'aV3 zzV0ie')]")));
        assertTrue(incomingAttachment.getText().contains("file.txt"));


    }

}