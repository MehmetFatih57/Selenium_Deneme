package Odev;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) {
        //1.Yeni bir Class olusturalim.C07_ManageWindowSet
        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve ni yazdirin
        System.out.println("boyutlari = " + driver.manage().window().getPosition());//boyutlari = (10, 10)
        System.out.println("konumu = " + driver.manage().window().getSize());//konumu = (1050, 708)
        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde
        //ayarlayin
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(900,900));
        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test
        //edin

        System.out.println("boyutlari = " + driver.manage().window().getPosition());//boyutlari = (50, 50)
        System.out.println("konumu = " + driver.manage().window().getSize());//konumu = (900, 900)

        if (driver.manage().window().getPosition().x==50 && driver.manage().window().getPosition().y==50){
            System.out.println("PASSED");
        }else System.out.println("FAILED");//PASSED

        if (driver.manage().window().getSize().getHeight()==900 && driver.manage().window().getSize().getWidth()==900){
            System.out.println("PASSED");
        }else System.out.println("FAILED");//PASSED


        //8. Sayfayi kapatin
        driver.close();
    }
}
