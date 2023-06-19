package day10derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Alerts extends TestBase {

    @Test
    public void acceptAlert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunutestedin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You successfully clicked an alert"));
    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunutestedin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("You successfully"));

    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğinidoğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        driver.switchTo().alert().sendKeys("Fatih");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("Fatih"));
    }
}
