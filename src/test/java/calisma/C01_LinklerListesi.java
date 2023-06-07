package calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_LinklerListesi {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // https://www.amazon.com sayfasına gidiniz

        driver.get("https://www.amazon.com");

        // aramakutusunu locate ediniz ve Nutella aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);



        for (int i = 0; i < 6; i++) {
            List<WebElement> linlerList=driver.findElements(By.xpath(
                    "(//a[@class='a-link-normal s-navigation-item'])[1] | " +
                            "(//a[@class='a-link-normal s-navigation-item'])[2] | " +
                            "(//li[@class='a-spacing-micro s-navigation-indent-1'])[1] | " +
                            "(//li[@class='a-spacing-micro s-navigation-indent-1'])[2] |" +
                            "(//span[@class='a-list-item'])[21] |" +
                            "(//span[@class='a-list-item'])[22]"));
            Thread.sleep(3000);
            System.out.println(linlerList.get(i).getText());
            //Thread.sleep(3000);
            //linlerList.get(i).click();
            //Thread.sleep(3000);
            //driver.navigate().back();
        }
        for (int i = 0; i < 5; i++) {
            List<WebElement> linlerList2=driver.findElements(By.xpath("(//a[@class='a-link-normal s-navigation-item'])[position()>=8 and position()<=14]"));
            Thread.sleep(3000);
            System.out.println(linlerList2.get(i).getText());

        }
    }
}
