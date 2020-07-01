package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver {
    //will implement singleton design pattern
    // will be using all drivers from this  class


    // Create private Static variables
    private static WebDriver driver;

    //2 create private constructor
    private Driver() { }
    //3 create the method to get your driver
    public static WebDriver getDriver(){
        //instantiate the driver if it is equals to null
        if(driver==null){
            switch (ConfigReader.getProperty("driverName")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver= new InternetExplorerDriver();
                    break;

            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return driver;
    }


//    public  String getRandomEmail(){
//        Random random=new Random();
//        String[] alphabetChar={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
//        int upperBound=26;
//        String emailAddress="";
//        for (int i=0; i<16;i++){
//            emailAddress+=alphabetChar[random.nextInt(upperBound)];
//        }
//        return  emailAddress+"@gmail.com";
//    }

}
