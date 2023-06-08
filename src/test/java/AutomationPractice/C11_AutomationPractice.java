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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C11_AutomationPractice {
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
    public void test() {
        ///2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        //5. Altbilgiye doğru aşağı kaydırın
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END).perform();

        //6. 'ABONELİK' metnini doğrulayın
        WebElement subscription = driver.findElement(By.xpath("(//h2)"));
        System.out.println(subscription.getText());
        Assert.assertTrue(subscription.isDisplayed());

        //7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("mehmet.fatihh57@gmail.com" , Keys.ENTER);
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();

        //8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
