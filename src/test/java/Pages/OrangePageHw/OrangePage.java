package Pages.OrangePageHw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangePage {
    public OrangePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @FindBy(id = "txtUsername")
    public WebElement username;
    @FindBy(id = "txtPassword")
    public WebElement password;
    @FindBy(id = "btnLogin")
    public WebElement login;
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminFunction;
    @FindBy(id = "ohrmList_chkSelectAll")
    public WebElement selectAllChekBoxes;
    @FindBy(xpath = "//td//a[text()]")
    public List<WebElement> listUsername;

    @FindBy(id = "btnAdd")
    public WebElement addButton;

    @FindBy(id = "systemUser_userType")
    public WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    public WebElement EmployeeName;
    @FindBy(id = "systemUser_userName")
    public WebElement userName;
    @FindBy(id = "systemUser_status")
    public WebElement selectStatus;

    @FindBy(xpath = "//input[@id='systemUser_password']")
    public WebElement password2;

    @FindBy(id = "systemUser_confirmPassword")
    public WebElement confirm;
    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id="successBodyEdit")
    public  WebElement message;

    @FindBy (id ="searchSystemUser_userName")
    public  WebElement searchLine;

    @FindBy (id ="searchBtn")
public  WebElement searchButton;


}

