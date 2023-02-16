package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.simple.SimpleLogger;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverBasic {
    public static WebDriver driver;
    public static WebDriver getDriver() {

        if (driver == null) {

            Locale.setDefault(new Locale("EN")); // Extent report da türkçe bilgi girilirse çalışması için eklendi
            System.setProperty("user.language", "EN");

            Logger.getLogger("").setLevel(Level.SEVERE); // loglarda SEVERE ile hata alınca mesaj gösterip diğer uyarı mesajlarını göstermemesi için eklendi
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void quitDriver() //Driver 3 sn bekletip kapatmak için kullanıldı.
    {
        try {
            Thread.sleep(3000); // Bekletme süresi
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null)  // driver dolu ise
        {
            driver.quit();
            driver = null; // Local driver boşaltıp null'a eşitlendi.
        }
    }
}
