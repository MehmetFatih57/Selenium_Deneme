package day12derstekrari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actual = driver.manage().getCookieNamed("i18-prefs").getValue();
        String expected = "USD";
        Assert.assertEquals(actual , expected);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie" , "cikolatali");
        driver.manage().addCookie(cookie);
        cookies = driver.manage().getCookies();
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        int eklenmedenOnce = cookies.size();
        System.out.println(eklenmedenOnce);
        cookies = driver.manage().getCookies();
        int eklediktenSonra = cookies.size();
        System.out.println(eklediktenSonra);
        Assert.assertEquals(eklediktenSonra - eklenmedenOnce , 1);

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();
        int silindiktenSonra = cookies.size();
        System.out.println(silindiktenSonra);
        Assert.assertEquals(eklediktenSonra , silindiktenSonra , 1);

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty());
    }
}
