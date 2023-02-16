package Pages;

import Utilities.WebDriverBasic;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Parent {
    WebDriverWait wait = new WebDriverWait(WebDriverBasic.getDriver(), Duration.ofSeconds(30));
    public void clickFunction(WebElement element){ // Elemente click yapmak için kullanıldı.
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element){ // Element görünene kadar beklemek için kullanıldı.
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) { // javascriptexecuter ile elemente kadar scroll yapmak için kullanıldı.
        JavascriptExecutor js = (JavascriptExecutor) WebDriverBasic.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public void waitUntilClickable(WebElement element){ // Element tıklanabilir olana kadar beklemek için kullanıldı.
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsText(WebElement element, String text){ // Elementin textinde doğrulama işlemi yapmak için kullanıldı.
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

}
