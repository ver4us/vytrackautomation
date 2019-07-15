package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class utility {

    /**
     * @param browser name
     * @return browser object, otherwise throw exception to prevent test run
     */
    public static WebDriver getDriver(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Wrong browser name!");
        }


    }

    public static void browse(WebDriver dr) {
        dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dr.manage().window().maximize();
        dr.get("http://qa2.vytrack.com/user/login");
    }

    public static void hold(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {

        }
    }

    public static void login(String u, String p, WebDriver driver) {
        driver.findElement(By.id("prependedInput")).clear();
        driver.findElement(By.id("prependedInput")).sendKeys(u);
        hold(1);
        driver.findElement(By.id("prependedInput2")).clear();
        driver.findElement(By.id("prependedInput2")).sendKeys(p);
        hold(1);
        driver.findElement(By.id("_submit")).click();
        hold(3);

    }

    public static void verifyIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("PASSED");
            System.out.println(element.getText() + ": is visible");
        } else {
            System.out.println("FAILED");
            System.out.println(element.getText() + ": is not visible!");
        }
    }


    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param driver
     * @param tab
     * @param module
     */
    public static void navigateToModule(WebDriver driver, String tab, String module) {
        String tabLocator = "//span[contains(text(),'" + tab + "') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'" + module + "') and contains(@class, 'title title-level-2')]";
//        driver.findElement(By.xpath(tabLocator)).click();
        clickWithWait(driver, By.xpath(tabLocator), 5);
        hold(1);
        driver.findElement(By.xpath(moduleLocator)).click();
        hold(2);
    }

    /**
     * This method will recover in case of exception after unsuccessful the click,
     * and will try to click on element again.
     *
     * @param driver
     * @param by
     * @param attempts
     */
    public static void clickWithWait(WebDriver driver, By by, int attempts) {
        int counter = 0;
        //click on element as many as you specified in attempts parameter
        while (counter < attempts) {
            try {
                //selenium must look for element again
                driver.findElement(by).click();
                //if click is successful - then break
                break;
            } catch (WebDriverException e) {
                //if click failed
                //print exception
                System.out.println(e);
                //print attempt
                System.out.println("Attempt :: " + ++counter);
                //wait for 1 second, and try to click again
                hold(1);
            }
        }

    }

    /*
    Logout
     */
    public static void logMeOut(WebDriver driver) {
        WebElement logoutMenu = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));
        if (logoutMenu.isDisplayed()) {
            logoutMenu.click();
            hold(3);
            driver.findElement(By.linkText("Logout")).click();
            hold(2);
            if (driver.findElement(By.id("_submit")).isEnabled())
                System.out.println("Successful Logout");
            else System.out.println("Unsuccessful Logout");
        } else {
            System.out.println("It seems you are not Login yet");
        }

    }

}


