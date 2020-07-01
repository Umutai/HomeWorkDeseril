package Pages.OrangePageHw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangePage {
    public OrangePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "txtUsername")
    public WebElement username;
    @FindBy(id = "txtPassword")
    public WebElement password;
    @FindBy(id = "btnLogin")
    public WebElement login;


}

