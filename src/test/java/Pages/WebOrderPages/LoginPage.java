package Pages.WebOrderPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        /*
         WebElement loginButton =driver.findElement(By.id("loginButton");
         driver.navigate ().refrsh()
 loginButton= driver.findElement(By.id("loginButton");
      loginButton.click
      */

        /*
        PageFactory.initElements (driver ,loginPage.class);
        --> it will solve the issue staleElementException if the element is refreshing on the page
        --> this is inside the stepDefinition class
         */
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;

    @FindBy(id="ctl00_MainContent_password")
    public  WebElement password;

    @FindBy(id ="ctl00_MainContent_login_button")
    public  WebElement loginButton;

    @FindBy(id ="ctl00_MainContent_status")
    public  WebElement error;
}
