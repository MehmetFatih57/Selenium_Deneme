package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C13_AutomationPractice {

    //1. Tarayıcıyı başlatın
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {
        ///2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. Ana sayfadaki ilk ürün için 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Ürün detayının açıldığını doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());

        //6. Miktarı 4'e yükseltin
        driver.findElement(By.cssSelector("#quantity")).sendKeys(Keys.DELETE, "4");

        //7. 'Sepete ekle' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //9. Sepet sayfasında ürünün tam miktar ile görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='disabled']")).isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
