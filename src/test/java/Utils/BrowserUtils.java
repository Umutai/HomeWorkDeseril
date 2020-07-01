package Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }
    public static void switchWindowByUrl(WebDriver driver, String url) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().contains(url)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void closeWindows(WebDriver driver, String parentId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    //Create a method for Fluent Wait
    public static WebElement fluentWait(WebDriver driver, long totalSec, long pollingEverySec, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSec))
                .pollingEvery(Duration.ofSeconds(pollingEverySec))
                .ignoring(RuntimeException.class);
        return wait.until(driver1 -> driver.findElement(locator));

    }

    public static WebElement visibilityOf(WebDriver driver, int timeInSecond, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static WebElement visibilityofElementLocated(WebDriver driver, int timeInSecond, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenshot() throws IOException {
        //First we cast drievr to take Screenshot
        //we get the screenshot as File
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        //we need the destination to store all my screenshots
        //=System.getProperty("user.dir")it will give the project location
        //+System.currentTimeMillis() helps us to give unique name for my screenshot

        String destinatoin = System.getProperty("user.dir") + "/Screenshot//" + System.currentTimeMillis() + ".png";
        File des = new File(destinatoin);
//    tr{
//        FileUtils.copyFile(srs,des);
        //copy file will get file from source and store to the destination
//           }catch(IOException e){
//        e.printStackTrace();
//           }

        FileUtils.copyFile(src, des);
        return destinatoin;
    }

    public static String todaysDate(String formatType) {
        LocalDate today = LocalDate.now();//2021-05-26
        DateTimeFormatter newformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return newformat.format(today);
    }
      public static void switchFrameByIndex(WebDriver driver,int index){
        driver.switchTo().frame(index);
    }
     public static void switchFrameByElement(WebDriver driver,By locator){
        driver.switchTo().frame(driver.findElement(locator));
    }
     public static void switchFrameWebElement(WebDriver driver,WebElement element){
        driver.switchTo().frame(element);
    }
    public static List<String> getTextsOfElement(List<WebElement> lists){
        List<String> texts=new ArrayList<>();
        for(WebElement list:lists){
            texts.add(list.getText().trim());
        }
             return texts;
    }

      public static void selectByVisibleText(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
      public static void selectByIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);

    }
      public static Select  getSelect(WebElement element){
        return new Select(element);
    }


}
