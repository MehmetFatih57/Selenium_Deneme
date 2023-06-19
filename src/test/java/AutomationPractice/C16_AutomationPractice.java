package AutomationPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C16_AutomationPractice {
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
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement actual = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(actual.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//input)[2]")).sendKeys("fatih57.aba.aba.aba.aba.aba.@gmail.com" , Keys.TAB , "123456789" , Keys.ENTER);

        //6. En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın
        Assert.assertEquals(driver.findElement(By.xpath("(//li//a)[10]")).getText(), "Logged in as Fatih");

        //7. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();

        //8. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //9. Sepet sayfasının görüntülendiğini doğrulayın
        String sepetSayfasi = driver.findElement(By.cssSelector("div[class='breadcrumbs']")).getText();
        Assert.assertTrue(sepetSayfasi.contains("Home Shopping Cart"));

        //10. Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        driver.findElement(By.xpath("(//div[@class='container'])[2]")).isDisplayed();

        //12. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Aciklama");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        //14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Mehmet YILDIRIM",Keys.TAB,"5282080029365764",Keys.TAB,"698",Keys.TAB,"11",Keys.TAB,"2028",Keys.TAB,Keys.ENTER);

        //15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        Assert.assertEquals(driver.findElement(By.xpath("//h2//b")).getText(),"ORDER PLACED!");

        //16. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //17. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
        String silindi=driver.findElement(By.xpath("//h2//b")).getText();
        Assert.assertEquals(silindi,"ACCOUNT DELETED!");
    }
}
