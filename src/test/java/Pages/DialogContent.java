package Pages;

import Utilities.WebDriverBasic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(WebDriverBasic.getDriver(), this);
    }
    @FindBy(css = "[class='ins-close-button']")
    private WebElement clickButton;
    @FindBy(css = "[class= 'clicker']")
    private WebElement searchBox;
    @FindBy(xpath = "(//*[text()='Logo ile iletişime geçmek istiyorum'])[2]")
    private WebElement clickText;
    @FindBy(css="[data-marker-id='elazig-subesi']")
    private WebElement clickBranch;
    @FindBy(xpath = "//*[text()='Elazığ Şubesi']")
    private WebElement verification;

    WebElement myElement;
    public void findAndClick(String strElement){ // Parametre ilgili case de Weblement ile eşitlenip clickFunction methoda gönderildi.

        switch (strElement){
            case "clickButton" : myElement = clickButton; break;
            case "searchBox" : myElement = searchBox; break;
            case "clickText" : myElement = clickText; break;
            case "clickBranch" : myElement = clickBranch; break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) { // Parametre ilgili case de Weblement ile eşitlenip verifyContainsText methoda gönderildi.
        switch (strlement) {
            case "verification"  : myElement = verification;break;
        }
        verifyContainsText(myElement, text);
    }
}
