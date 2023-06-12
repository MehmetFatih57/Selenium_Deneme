package AutomationPractice;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15_AutomationPractice {

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
        //5. Kaydol'daki tüm ayrıntıları doldurun ve hesap oluşturun
        //6. 'HESAP OLUŞTURULDU!'nu doğrulayın. ve 'Devam Et' düğmesini tıklayın
        //7. Üstte "Kullanıcı adı olarak oturum açıldı"yı doğrulayın
        //8. Sepete ürün ekleyin
        //9. 'Sepet' düğmesine tıklayın
        //10. Sepet sayfasının görüntülendiğini doğrulayın
        //11. Ödeme İşlemine Devam Et'i tıklayın
        //12. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        //13. Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        //14. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma Tarihi
        //15. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        //16. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
    }
}
