package practice_automationtesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ThreeSlidersOnly {

    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders

    @Test
    public void test01 (){
        //1) Open the browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2) Enter the URL “http://practice.automationtesting.in/”
        String url = "http://practice.automationtesting.in";
        driver.get(url);
        //3) Click on Shop Menu
        WebElement shopMenu = driver.findElement(By.xpath("//li[@ id='menu-item-40']"));
                shopMenu.click();
                driver.navigate().back();
                shopMenu.click();

        //4) Now click on Home menu button
        WebElement homeMenu = driver.findElement(By.xpath("//a[text()='Home']"));
                   homeMenu.click();

        //5) Test whether the Home page has Three Sliders only
        //6) The Home page must contains only three sliders



    }
}
