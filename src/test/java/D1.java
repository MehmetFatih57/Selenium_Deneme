import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D1 {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrom.driver" , "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");

    }
}
