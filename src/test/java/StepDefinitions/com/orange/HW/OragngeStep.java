package StepDefinitions.com.orange.HW;

import Pages.OrangePageHw.OrangePage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class OragngeStep {
    WebDriver driver = Driver.getDriver();
    OrangePage orangePage = new OrangePage(driver);

    @Given("the user go to the orangehrm")
    public void the_user_go_to_the_orangehrm() {
        driver.navigate().to(ConfigReader.getProperty("orangeUrl"));

    }

    @Then("the orUser enters username {string}")
    public void the_orUser_enters_username(String username) {
        orangePage.username.sendKeys(username);

    }

    @Then("the orUser enters password {string}")
    public void the_orUser_enters_password(String password) {
        orangePage.password.sendKeys(password);
        orangePage.login.click();
    }

    @Then("the orUser validate the home page")
    public void the_orUser_validate_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser clicked the Admin function")
    public void the_orUser_clicked_the_Admin_function() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser click the checkbox next to the username")
    public void the_orUser_click_the_checkbox_next_to_the_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser validate all checkboxes are selected")
    public void the_orUser_validate_all_checkboxes_are_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser clicked on top of username {int} times")
    public void the_orUser_clicked_on_top_of_username_times(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate username are listed descending order")
    public void validate_username_are_listed_descending_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
