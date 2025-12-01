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
import java.util.List;
import java.util.Random;

public class Topic_05_Textbox_TextArea {
    WebDriver driver;
    Random rand;
    String firstName, lastName, emailAddress, password, fullName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Binh";
        lastName = "Nguyen";
        fullName = firstName + " " + lastName;
        emailAddress = "binhnguyen" + rand.nextInt(99999) + "gmail.com";
        password = "123456789";
        fullName = firstName + " " + lastName;
    }

    @Test
    public void Login_05_Create_A_New_Account() {
        driver.get("https://live.techpanda.org/");

        driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
        sleepInSeconds(2);

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#middlename")).sendKeys(""); // giữ nguyên logic: không đổi, không thêm biến
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        sleepInSeconds(5);
        System.out.println("Đã đki thành công");

//        //Tuyệt đối
//        Assert.assertEquals(driver.findElement(By.cssSelector("ul.messages span")).getText(),
//                "Thank you for registering with Main Website Store.");
//        sleepInSeconds(5);

        String contactInformationText = driver.findElement(By.xpath(
                "//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        //tương đối
        Assert.assertTrue(contactInformationText.contains("") && contactInformationText.contains("")); //Fullname + Email



    }

    @Test
    public void TC_02_() {
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
