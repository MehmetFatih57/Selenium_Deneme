package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C06_AutomationPractice {
    public static void main(String[] args) throws InterruptedException {
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
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Mehmet Fatih", Keys.TAB,"mehmet.fatihh57@gmail.com",Keys.TAB,"Giriş",Keys.TAB,"Giriş yaparken sorun yaşıyorum");

        //7. Dosya yükleyin
        String dosyaYolu = "C:\\Users\\Rog\\Desktop\\WhatsApp Image 2023-05-23 at 00.44.23.jpg";
        driver.findElement(By.xpath("(//*[@class='form-control'])[5]")).sendKeys(dosyaYolu);

       //8. 'Gönder' düğmesini tıklayın
       Thread.sleep(2000);
       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).perform();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@class='btn btn-primary pull-left submit_form']")).click();

       //9. Tamam düğmesine tıklayın
       driver.switchTo().alert().accept();

       //10. Başarı mesajını doğrulayın 'Başarı! Bilgileriniz başarıyla gönderildi.' görünür
       assert driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed();

       //11. 'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();

       driver.navigate().back();

       //12. Sayfayı kapattım
       driver.close();
    }
}
