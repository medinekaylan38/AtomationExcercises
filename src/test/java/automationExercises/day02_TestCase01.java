package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day02_TestCase01 {

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

        driver.findElement(By.xpath("//a[@href='/login']")).click();

//5. Verify 'New User Signup!' is visible
       WebElement newUser = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());
//6. Enter name and email address

//7. Click 'Signup' button
        WebElement nameTextBox = driver.findElement(By.xpath("//*[@placeholder='Name']"));
        nameTextBox.sendKeys("Hello", Keys.TAB, "kl2333@gmail.com", Keys.TAB, Keys.ENTER);

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
        Thread.sleep(3000);

//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("freya",Keys.TAB);

        WebElement day = driver.findElement(By.id("days"));
        day.sendKeys("5", Keys.TAB,"April",Keys.TAB,"1994");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("hello", Keys.TAB,"ye",Keys.TAB,"Freya",Keys.TAB,"Adres1",Keys.TAB,
        "Adres2",Keys.TAB,"Canada",Keys.TAB,"state",Keys.TAB,"ISt",Keys.TAB,"01-212",Keys.TAB,"05224",Keys.TAB,Keys.ENTER);

//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        Thread.sleep(2000);

//15. Click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueButton.click();

//16. Verify that 'Logged in as username' is visible
        driver.navigate().back();
       continueButton.click();
        System.out.println("--------------------------------");

        WebElement username = driver.findElement(By.xpath("//b[text()='Hello']"));
        Assert.assertTrue(username.isDisplayed());
        Thread.sleep(2000);

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        Thread.sleep(2000);

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedButton = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deletedButton.isDisplayed());

        WebElement deleteButton = driver.findElement(By.xpath("(//a [@href='/'])[3]"));
        deleteButton.click();
}
}
