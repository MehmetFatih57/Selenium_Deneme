package deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_HepsiBurada {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.hepsiburada.com/");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='theme-IYtZzqYPto8PhOx3ku3c']"));
        aramaKutusu.sendKeys("tencere", Keys.ENTER);

       List<WebElement> urunler=driver.findElements(By.xpath("//div[@class='moria-ProductCard-bOkJXM efwrlA s2owbwg7vaq']"));
        for (WebElement w:urunler) {
            System.out.println(w);
       }

        //WebElement urunisim = driver.findElement(By.xpath("//div[@class='moria-ProductCard-iymOAa bEuPwT sxgjrp1g7ve']"));
       // System.out.println(urunisim.getText());

        //driver.close();
    }
}