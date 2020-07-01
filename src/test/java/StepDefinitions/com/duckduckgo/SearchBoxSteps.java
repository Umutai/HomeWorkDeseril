package StepDefinitions.com.duckduckgo;

import Pages.DuckDuckGoPages.SearchPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBoxSteps {
    WebDriver driver= Driver.getDriver();
    SearchPage page;

    @Given("the user goes to the duckduckgo")
    public void the_user_goes_to_the_duckduckgo() throws InterruptedException {

        page = new SearchPage(driver);
        driver.get(ConfigReader.getProperty("url"));
        Thread.sleep(2000);
    }
    @When("the user send the  selenium keyword")
    public void the_user_send_the_selenium_keyword() {
        page.searchBox.sendKeys(ConfigReader.getProperty("searchValue"));
    }


    @Then("the user click search button")
    public void the_user_click_search_button() {
        page.searchButton.click();

    }

    @Then("the user validate title contains the selenium keyword")
    public void the_user_validate_title_contains_the_selenium_keyword() {
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(ConfigReader.getProperty("searchValue")));

    }

    @Then("the user validate url contains the selenium keyword")
    public void the_user_validate_url_contains_the_selenium_keyword() {
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ConfigReader.getProperty("searchValue")));

    }

    @Then("the user validate all results contains the selenium keyword")
    public void the_user_validate_all_results_contains_the_selenium_keyword() {
      for (WebElement element:page.searchResults){
          String actualResult=element.getText();
          Assert.assertTrue(actualResult.contains(ConfigReader.getProperty("result")));
      }

    }

    @When("the user search with {string}")
    public void the_user_search_with(String searchValue) {
       page.searchBox.sendKeys(searchValue);
    }

    @Then("the user validate title contains {string}")
    public void the_user_validate_title_contains(String expectde) {
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expectde));
    }
    @Then("the user validate all result contains {string}")
    public void the_user_validate_all_result_contains(String text) {
        for (WebElement result: page.searchResults){
            Assert.assertTrue(result.getText().contains(text));
        }
    }
    @Then("the user validate number of result is {int}")
    public void the_user_validate_number_of_result_is(int expected) {
       Assert.assertEquals(expected,page.searchResults.size());
    }

}
