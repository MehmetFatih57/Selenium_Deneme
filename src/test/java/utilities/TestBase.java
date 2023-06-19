package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    public void kapat() {
        driver.quit();
    }

    public void dur(int saniye){
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //AcceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //DismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //GetTextAlert
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //SendKeysAlert
    public void sendKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm , String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm , int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm , String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
}
