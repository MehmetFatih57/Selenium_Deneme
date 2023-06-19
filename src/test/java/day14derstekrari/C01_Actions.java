package day14derstekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions01() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        dur(2);

        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();

    }

    @Test
    public void actions02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        dur(2);

        //sayfanın en altına scroll gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        dur(3);

        //sayfanın en ustune scroll gidelim
        actions.sendKeys(Keys.HOME).perform();
        //actions.sendKeys(Keys.HOME).build.perform();--> Build() methodu action'lari birlestirmek icin kullanilan methoddur.
        //Birden fazla olusturdugumuz action objesini baglar.
        //release()--> methodu mouse'u serbest birakir.

    }

    @Test
    public void actions03() {

        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        dur(2);

        //sayfanın altına dogru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1500).perform();

        dur(3);

        //sayfanın ustune dogru gidelim
        actions.scrollByAmount(0, -1500).perform();
    }
}
