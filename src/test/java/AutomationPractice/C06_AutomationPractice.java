package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_AutomationPractice {

    public static void main(String[] args) {
        //1. Tarayıcıyı başlatın
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        System.out.println("Ana Sayfanin Basariyla Gorundugunu DOgrulayin : " + driver.findElement(By.xpath("//div[@class='logo pull-left']")).isDisplayed());

        //4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();

        //5. "İLETİŞİME GEÇİN"in görünür olduğunu doğrulayın
        System.out.println("Iletisime Gecin : " + driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]")).isDisplayed());

        //6. Adı, e-postayı, konuyu ve mesajı girin
        //7. Dosya yükleyin
        //8. 'Gönder' düğmesini tıklayın
        //9. Tamam düğmesine tıklayın
        //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
        //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
    }
}
