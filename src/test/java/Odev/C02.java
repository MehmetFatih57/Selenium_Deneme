package Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) {
        //Yeni bir Class olusturalim.C05_NavigationMethods

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();

        driver.get("https://www.youtube.com/");
        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();
    }
}
