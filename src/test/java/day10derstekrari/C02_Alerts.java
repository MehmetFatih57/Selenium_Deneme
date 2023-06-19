package day10derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Alerts extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        dur(2);
        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Cikan yazi : " + getTextAlert());
        Assert.assertEquals("You clicked a button" , getTextAlert());
        dur(2);
        //Ve alert'ü kapatalım
        kapat();
    }

    @Test
    public void test02() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        dur(2);
        //Çıkan alertte iptale basalım.
        dismissAlert();
        dur(2);
        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText().contains("You selected Cancel"));
    }

    @Test
    public void test03() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");
        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).click();
        dur(2);
        //çıkan alerte ismimizi girelim
        sendKeysAlert("Fatih");
        acceptAlert();
        //ismi girdiğimizidoğrulayalım
        //Assert.assertTrue(driver.findElement(By.xpath("//span[@id='promptResult']")).getText().contains("Fatih"));
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText() , "You entered Fatih");
    }
}
