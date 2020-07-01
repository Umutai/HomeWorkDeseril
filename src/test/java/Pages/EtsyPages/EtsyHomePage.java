package Pages.EtsyPages;

import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class EtsyHomePage {
    public  EtsyHomePage(WebDriver  driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@data-id='gnav-search-submit-button']")
    public WebElement searchButton;
}
