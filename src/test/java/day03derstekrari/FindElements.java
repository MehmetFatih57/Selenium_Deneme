package day03derstekrari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //Amazon sayfasında kac tane link olduğunu konsolda yazdırın
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("linklerListesi = " + linklerListesi.size());

        //Linkleri konsolda yazdırın
        for (WebElement eache : linklerListesi) {
            System.out.println(eache.getText());
        }

        //sayfayıkapatın
        driver.close();
    }
}
