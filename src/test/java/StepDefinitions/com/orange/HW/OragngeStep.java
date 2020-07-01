package StepDefinitions.com.orange.HW;

import Pages.OrangePageHw.OrangePage;
import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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

    @Then("the orUser clicked the Admin function")
    public void the_orUser_clicked_the_Admin_function() {
        orangePage.adminFunction.click();
    }

    @Then("the orUser click the checkbox next to the username")
    public void the_orUser_click_the_checkbox_next_to_the_username() {


        orangePage.selectAllChekBoxes.click();
    }

    @Then("the orUser validate all checkboxes are selected")
    public void the_orUser_validate_all_checkboxes_are_selected() {
        Assert.assertTrue(orangePage.selectAllChekBoxes.isSelected());
        System.out.println("fdgs" + orangePage.selectAllChekBoxes.isSelected());
    }

    @Then("the orUser clicked on top of username {int} times")
    public void the_orUser_clicked_on_top_of_username_times(Integer int1) {
        Actions actions = new Actions(driver);
        actions.doubleClick(orangePage.selectAllChekBoxes);
    }

    @Then("validate username are listed descending order")
    public void validate_username_are_listed_descending_order() {
        List<WebElement> list = new ArrayList<>(orangePage.listUsername);
    }


    @Then("the orUser click the Add button")
    public void the_orUser_click_the_Add_button() {

        orangePage.addButton.click();
    }

    @Then("the orUser select User role")
    public void the_orUser_select_User_role() {
        Select select = new Select(orangePage.userRole);
        select.selectByValue("2");
    }

    @Then("the orUser select employee name and enters username")
    public void the_orUser_select_employee_name_and_enters_username() {

        orangePage.EmployeeName.sendKeys("Steven Edwards");
        orangePage.userName.sendKeys("hjffkgh");
    }

    @Then("the orUser select status")
    public void the_orUser_select_status() {
        Select select = new Select(orangePage.selectStatus);
        select.selectByValue("1");


    }

    @Then("the orUser enters password  and confirm")
    public void the_orUser_enters_password_and_confirm() {
        orangePage.password2.sendKeys("id270363");
        orangePage.confirm.sendKeys("id270363");
    }

    @Then("the orUser click save button")
    public void the_orUser_click_save_button() throws InterruptedException {
        orangePage.saveButton.click();

       Thread.sleep(200);

    }

    @Then("Validate {string} message")
    public void validate_message(String str) {
//        String actual =orangePage.message.getText();
//        String expected =str;
////        softAssert.assertEquals(str,actual);
    }
    @Then("the orUser search userName which provided and click search button")
    public void the_orUser_search_userName_which_provided_and_click_search_button() {

        orangePage.searchButton.click();
    }


    @Then("Validate only one user displayed after search")
    public void validate_only_one_user_displayed_after_search() {

    }

    @Then("Validate Username")
    public void validate_Username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate User Role")
    public void validate_User_Role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate Employee Name")
    public void validate_Employee_Name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate status of the employee")
    public void validate_status_of_the_employee() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser clicked on top of the username")
    public void the_orUser_clicked_on_top_of_the_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the orUser clicked edit button and change the status")
    public void the_orUser_clicked_edit_button_and_change_the_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate {string} message Search with the username")
    public void validate_message_Search_with_the_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate status is updated for the user")
    public void validate_status_is_updated_for_the_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
