package Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06 {
    public static void main(String[] args) {
        //Yeni bir class olusturun (TekrarTesti)
        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın  (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.youtube.com/");

        if (driver.getTitle().contains("youtube")){
            System.out.println("PASSED");
        }else System.out.println(driver.getTitle());

        //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.

        if (driver.getCurrentUrl().contains("youtube")){
            System.out.println("PASSED");
        }else System.out.println(driver.getCurrentUrl());

        //Daha sonra Amazon sayfasina gidin
        driver.get("https://www.amazon.com/");
        //Youtube sayfasina geri donun
        driver.navigate().back();
        //Sayfayi yenileyin
        driver.navigate().refresh();
        //Amazon sayfasina donun
        driver.navigate().forward();
        //Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa  doğru başlığı(Actual Title) yazdırın.
        if (driver.getTitle().contains("Amazon")){
            System.out.println("PASSED");
        }else System.out.println(driver.getTitle());

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        if (driver.getCurrentUrl().contains("https://www.amazon.com/")){
            System.out.println("PASSED");
        }else System.out.println(driver.getCurrentUrl());

        //Sayfayi kapatin

        driver.close();

}
}
