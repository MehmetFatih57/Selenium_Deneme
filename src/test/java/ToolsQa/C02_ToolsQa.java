package ToolsQa;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ToolsQa extends TestBase {
    @Test
    public void test01() {

        // yerel makine yolundan krom tarayıcının konumunu ayarla
        // Tarayıcıyı başlat WebDriver sürücüsü=yeni ChromeDriver();
        // Demo sitesine gidin
        driver.get("https://demoqa.com/nestedframes");

        // Sayfadaki Çerçeve Sayısı
        int cerceveSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println(cerceveSayisi);

        // frame1'i web sayfasında bulun
        WebElement frame1 = driver.findElement(By.id("frame1"));

        // Frame1'e geç
        driver.switchTo().frame("frame1");

        // Elemanı Frame1'in içine yerleştir
        WebElement frame1Element = driver.findElement(By.tagName("body"));
        System.out.println(frame1Element.getText());

        // frame1 elemanı için metni al
        String metin1 = driver.findElement(By.xpath("//*[.='Parent frame']")).getText();

        // Ana cerceve icinde bulunan metni yazdirmayi deneyin
        System.out.println(metin1);

        // Frame2'ye gec
        driver.switchTo().frame(0);

        // Elemani Frame2'in icine bulun
        WebElement frame2Element = driver.findElement(By.tagName("body"));
        System.out.println(frame2Element.getText());

        // frame2 elemani icin metni al
        String metin2 = driver.findElement(By.xpath("//*[.='Child Iframe']")).getText();

        // Child frame icinde bulunan metni yazdirmayi deneyin
        System.out.println(metin2);
    }
}
