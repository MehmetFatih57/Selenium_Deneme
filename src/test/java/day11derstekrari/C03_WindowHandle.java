package day11derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {

        //Window 1'de(yeni bir pencerede)  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle, expectedTitle);

        //Window 2'de(yeni bir pencerede)  https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        // WindowType.TAB -->Yeni bir sekme acar.

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
    }
}
