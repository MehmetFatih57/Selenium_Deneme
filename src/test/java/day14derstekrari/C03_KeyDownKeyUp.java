package day14derstekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//-->Arama Kutusunda shift tusuna bastik
                sendKeys("selenium").//-->selenium metnini shift tusuna basili kaldigi icin buyuk yazmistir
                keyUp(Keys.SHIFT).//-->shift tusunu serbest biraktik
                sendKeys("-java", Keys.ENTER).//--> bu kismi shift'i serbest biraktigimiz icin kucuk yazdi
                perform();
    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "-java", Keys.ENTER);
        /*
            Mouse islemleri icin actions class'ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin
            actions class'ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir, hatta birden
            fazla klavye tuslarina bastirabiliriz. Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek sonrasinda
            yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT kullanrak
            shift tusunu serbest birakmis olduk
         */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("selenium", Keys.ENTER);

        //Sayfayı bekleyin
        dur(4);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).//-->sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.CONTROL, "a");//-->Metni kesebilmemiz icin once ctrl+a ile secmemiz gerekir
        dur(2);
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).
                sendKeys(Keys.CONTROL, "x");//-->Secilen metni ctrl+x ile kestik
        dur(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).
                sendKeys(Keys.CONTROL , "v" , Keys.ENTER);//-->Kestigimiz metni ctrl+v tusu ile tekrar arama kutusuna yapistirdik ve arattik
    }
}
