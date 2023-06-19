package day11derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iframe01() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//p)[1]")).getText().contains("black border"));

        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String appList = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(appList);
        Assert.assertEquals(appList , "Applications lists");

        //➢    Son olarak footer daki 'Povered By' yazisini varligini test edilip
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("(//p)[3]")).getText().contains("Povered By"));

        //Son olarak sayfa başlığında iframe yazısının görünür olduğunu test edin
        driver.findElement(By.xpath("//h3")).isDisplayed();

    }
}
