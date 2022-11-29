package nonPageObjectModelTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterNewUserSimple {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpSimple() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://shop.pragmatic.bg");
    }

   @AfterMethod
    public void tearDownSimple() {driver.quit();}

    @Test
    public void registerNewUserSimple() {
        driver.findElement(By.xpath("//i[@class = 'fa fa-user']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href = 'https://shop.pragmatic.bg/index.php?route=account/register']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'content']/h1")));

        var inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("Antoaneta");
        driver.findElement(By.id("input-lastname")).sendKeys("Marinova");

        var prefix = RandomStringUtils.randomAlphabetic(7);
        var domainPrefix = RandomStringUtils.randomAlphabetic(5);
        var mainDomain = RandomStringUtils.randomAlphabetic(3);
        var randomEmailAddress = prefix + "@" + domainPrefix + "." + mainDomain;
        var inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys(randomEmailAddress);

        driver.findElement(By.id("input-telephone")).sendKeys("+359 88888888");
        var inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.sendKeys("pass123!");
        driver.findElement(By.id("input-confirm")).sendKeys("pass123!");
        driver.findElement(By.xpath("//div[@class = 'pull-right']//input[1]")).click();
        driver.findElement(By.className("btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        var verifyRegistration = driver.findElement(By.id("content"));
        Assert.assertTrue(verifyRegistration.getText().contains("Your Account Has Been Created!"));



    }
}
