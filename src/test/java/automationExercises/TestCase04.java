package automationExercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase04 {
    @Test
    public void Test01() {

        Faker faker = new Faker();

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

        driver.findElement(By.xpath("//a[@href='/login']")).click();

//5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());

        //6. Enter correct email address and password
        WebElement nameTextBox = driver.findElement(By.xpath("//input[]"));
        nameTextBox.sendKeys(faker.internet().emailAddress(), Keys.TAB,
                faker.internet().password(6,12,true,true,true));


        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Logout' button
        //10. Verify that user is navigated to login page

    }



}
