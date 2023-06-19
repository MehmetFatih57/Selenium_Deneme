package day11derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe01() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editor = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p")).clear();

        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        driver.findElement(By.xpath("//p")).sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a)[3]")).isDisplayed();
    }
}
