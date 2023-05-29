package Odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");


//        Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://amazon.com");

//        Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Basligi : " + driver.getTitle());

//        Sayfa basliginin “Amazon” icerdigini test edin
        if (driver.getTitle().contains("Amazon")) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

//        Sayfa adresini(url) yazdirin
        System.out.println("Sayfa url adresi : " + driver.getCurrentUrl());

//        Sayfa url’inin “amazon” icerdigini test edin.
        if (driver.getCurrentUrl().contains("amazon")) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");


//        Sayfa handle degerini yazdirin
        System.out.println("Sayfa Handle degeri : " + driver.getWindowHandle());
//
//        Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        if (driver.getPageSource().contains("Gateway")) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

//        Sayfayi kapatin.
        driver.close();


}
}

