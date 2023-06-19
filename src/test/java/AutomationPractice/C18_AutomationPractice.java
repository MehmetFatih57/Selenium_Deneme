package AutomationPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C18_AutomationPractice extends TestBase {
    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
        driver.findElement(By.xpath("//div[@class='left-sidebar']")).isDisplayed();

        //4. 'Kadınlar' kategorisine tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();

        //5. "Kadınlar" kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın
        driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/2']")).isDisplayed();

        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();

        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
    }
}
