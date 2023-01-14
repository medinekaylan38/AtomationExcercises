package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day03_TestCase03 {

    @Test
    public void test01() throws InterruptedException {

        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String exceptedUrl = driver.getTitle();
        String actualUrl= "Automation Exercise";
        Assert.assertEquals("Url uyusmuyor!",exceptedUrl, actualUrl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//h2[text()='Login to your account']")).click();

       // 5. Verify 'Login to your account' is visible
       WebElement nameTextBox = driver.findElement(By.xpath("//h2[text()='Login to your account']");
        nameTextBox.click();
      //  6. Enter incorrect email address and password
       // 7. Click 'login' button
       // 8. Verify error 'Your email or password is incorrect!' is visible
