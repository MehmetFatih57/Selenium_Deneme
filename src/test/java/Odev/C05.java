package Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05 {
    public static void main(String[] args) {
        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.facebook.com/");

        if (driver.getTitle().contains("facebook")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("PASSED");
        }else System.out.println(driver.getCurrentUrl());

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/https://www.walmart.com/");
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //Sayfayi yenileyin
        driver.navigate().refresh();
        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // 9.Browser’i kapatin
        driver.close();
}
}
