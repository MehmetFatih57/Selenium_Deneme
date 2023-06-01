package deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_Trendyol {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.trendyol.com/");

        WebElement buton = driver.findElement(By.xpath("//img[@src='https://cdn.dsmcdn.com/web/production/new-gender-popup-male.png']"));
        buton.click();

        WebElement anneCocuk = driver.findElement(By.xpath("//a[@href='/butik/liste/3/anne--cocuk']"));
        anneCocuk.click();

        WebElement ayakkabi = driver.findElement(By.xpath("(//img[@loading='lazy'])[7]"));
        ayakkabi.click();

        WebElement urun = driver.findElement(By.xpath("(//span[@class='prdct-desc-cntnr-name hasRatings'])[2]"));
        urun.click();
        Thread.sleep(3000);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        WebElement sepeteEkle = driver.findElement(By.xpath("//*[.='Sepete Ekle']"));
        sepeteEkle.click();
        Thread.sleep(3000);

        WebElement sepet = driver.findElement(By.xpath("//div[@class='account-nav-item basket-preview']"));
        sepet.click();
        Thread.sleep(3000);

        WebElement sil = driver.findElement(By.xpath("//i[@class='i-trash']"));
        sil.click();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.close();
    }
}
