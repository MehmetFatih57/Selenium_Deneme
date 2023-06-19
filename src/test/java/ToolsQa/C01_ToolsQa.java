package ToolsQa;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_ToolsQa extends TestBase {
    @Test
    public void test01() {
        //Chrome tarayıcının konumunu yerel makineden ayarla
        // Tarayıcıyı başlat
        // url'ye git
        driver.get("https://demoqa.com/frames");
        // Sayfadaki toplam iframe sayısını bulun
        int iframeSayi = driver.findElements(By.xpath("//iframe")).size();

        // Sayfadaki toplam iframe'leri yazdır
        System.out.println(iframeSayi);

        // index=0 kullanarakilkkareyegeç
        driver.switchTo().frame("frame2");

        System.out.println(driver.findElement(By.xpath("//h1")).getText());
    }
}
