package AutomationPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C17_AutomationPractice extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]")).click();

        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.cssSelector("button[class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());

        //7. Belirli bir ürüne karşılık gelen 'X' düğmesine tıklayın
        driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();

        //8. Ürünün sepetten çıkarıldığını doğrulayın
        Thread.sleep(2000);
        WebElement verifyRemove = driver.findElement(By.xpath("//b[normalize-space()='Cart is empty!']"));
        Assert.assertTrue(verifyRemove.isDisplayed());
    }
}
