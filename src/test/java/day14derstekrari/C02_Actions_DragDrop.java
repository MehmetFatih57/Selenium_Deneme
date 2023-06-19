package day14derstekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım

        /*
            drag ve drop WebElement'leri iframe icinde oldugu icin iframe gecis yapmaliyiz
         */

        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag , drop).perform();

        //actions.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")) , driver.findElement(By.xpath("//div[@id='droppable']")));

        /*
            Eger bir hareketli WebElement'i tutup baska bir WebElement'in uzerine birakmak istersek suruklemek istedigimiz
            WebElement'in locatini alip uzerine birakacagimiz WebElement'in locate'ini de alarak dragAndDrop(kaynak,hedef) methodu
            ile islemi gerceklestirebiliriz
         */
    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basili tuttuk
                moveToElement(drop).//-->Bu method ile basili tuttugumuz webelementi diger webelement'in uzerine goturduk
                release().//-->Bu method ile basili tuttugumuz webelement'i serbest biraktik
                perform();//-->Islemi sonlandirdik
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basili tuttuk
                moveByOffset(160 , 45).//-->Belirtmis oldugumuz koordinatlara we'ti tasir
                release().//-->Bu method ile basili tuttugumuz webelement'i serbest biraktik
                perform();//-->Islemi sonlandirdik
    }
}
