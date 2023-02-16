package Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)

@Listeners({ExtentITestListenerClassAdapter.class})

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass // Rapor bittiği zaman bu metodu çalıştırıp, bilgilerin eklenmesi için kullanıldı.
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name", System.getProperty("user.name")); //Bilgisayar adını default ekler.
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone")); //Saat dilimini default ekler.
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name")); //İşletim sistemini default ekler.
        ExtentService.getInstance().setSystemInfo("Application Name", "Logo"); // Manuel bilgi ve açıklama eklemek için.
        ExtentService.getInstance().setSystemInfo("Department", "Test Birimi");
        ExtentService.getInstance().setSystemInfo("Test specialist", "Nazmiye Akdoğan");
    }
}
