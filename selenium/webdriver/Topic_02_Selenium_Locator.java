package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    //Khai báo
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // khởi tạo biến driver lên
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    @Test
    public void TC_01_ID() {
        //tìm 1 Element
        driver.findElement(By.id("small-searchterms"));
    }

    @Test
    public void TC_02_Class() {
        // nó ko lấy hết toàn bộ giá trị nếu có khoản trắng
        driver.findElement(By.className("register-next-step-button"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("Email"));
    }

    @Test
    public void TC_04_LinkText() {
        //chỉ làm việc với element là text (1:14:01)
        //thẻ a và có thuộc tính href
        // Độ chính xác cao = tuyệt đối = toàn bộ
        driver.findElement(By.linkText("Register"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.linkText("Wishlist"));
    }

    @Test
    public void TC_05_Partial_Link_Test() {
        //chỉ làm việc với element là link
        // Độ chính xác ko cao = tương đối = 1 phần (đầu/ giữa/ cuối)
        driver.findElement(By.partialLinkText("Digital"));
        driver.findElement(By.partialLinkText("Wishlist"));
        driver.findElement(By.partialLinkText("downloads"));
    }

    @Test
    public void TC_06_Tagname() {
        //tên thẻ html
        //tìm tất cả các element giống nhau(thẻ của component giống nhau)
        //tất cả các textbox/radio/button
        driver.findElement(By.tagName("input"));
        driver.findElement(By.tagName("button"));
        driver.findElement(By.tagName("label"));
    }


    @Test
    public void TC_07_Css() {
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.cssSelector("button.register-next-step-button"));

        driver.findElement(By.cssSelector("select[name='customerCurrency']"));
        driver.findElement(By.cssSelector("input[id='Company']"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("a[href*='register']"));
        driver.findElement(By.cssSelector("a[href*='login?']"));

        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("input"));

    }

    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        driver.findElement(By.xpath("//button[contains(@class, 'register-next-step-button')]"));

        driver.findElement(By.xpath("//select[@name='customerCurrency']"));

        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Log in']"));
        driver.findElement(By.xpath("//a[text()='Shipping & returns']"));

        driver.findElement(By.xpath("//a[contains(text(), '& returns')]"));
        driver.findElement(By.xpath("//a[contains(text(), 'Register')]"));

        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));
    }
    @Test
    public void TC_09_Relative_locater() {
        By passwordTextBoxBy = By.cssSelector("input#Password");
        By rememberMe = By.id("RememberMe");
        By forgotPassword = By.cssSelector("span.forgot-password");
        By loginbtn = By.cssSelector("button.button-1");
        WebElement rememberMeLabeltext = driver.findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginbtn)
                .below(passwordTextBoxBy)
                .toRightOf(rememberMe)
                .toLeftOf(forgotPassword)
        );
    }

    @AfterClass
    public void clearBrowser() {
        driver.quit();
    }
}
