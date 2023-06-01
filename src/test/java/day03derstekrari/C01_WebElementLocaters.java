package day03derstekrari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebElementLocaters {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



        //https://www.amazon.com sayfasina gidiniz
        driver.get("https://www.amazon.com");

        //aramakutusunu locate ediniz ve Nutella aratiniz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Iphone" + Keys.ENTER);
        Thread.sleep(4000);

        //sayfayi kapatiniz
        driver.close();


    }
}
