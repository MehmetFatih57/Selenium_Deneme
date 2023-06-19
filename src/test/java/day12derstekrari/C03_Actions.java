package day12derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountList=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();

        dur(2);

        driver.findElement(By.xpath("//span[.='Account']")).click();

        //moveToElement() methodu ile mouse' u istedigimiz webElementin uzerine goturebiliriz.

        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
