package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_WebElement_Commands_03 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("button#send2")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        WebElement errMessage1 = driver.findElement(By.cssSelector("div#advice-required-entry-email"));
        Assert.assertEquals(errMessage1.getText(), "This is a required field.");

        WebElement errMessage2 = driver.findElement(By.cssSelector("div#advice-required-entry-pass"));
        Assert.assertEquals(errMessage2.getText(), "This is a required field.");
    }

    @Test
    public void TC_02_invalid_Email() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("1232142@1231232.12312");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        WebElement errMessage1 = driver.findElement(By.xpath("//div[@class='validation-advice']"));
        Assert.assertEquals(errMessage1.getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Pass_less_than_6_chars() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        WebElement errMessage2 = driver.findElement(By.xpath("//div[@class='validation-advice']"));
        Assert.assertEquals(errMessage2.getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_04_Incorrect_email_or_password() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button[title='Login']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
