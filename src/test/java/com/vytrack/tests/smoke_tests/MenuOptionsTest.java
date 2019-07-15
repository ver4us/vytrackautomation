package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.vytrack.utilities.utility.getDriver;
import static com.vytrack.utilities.utility.navigateToModule;

public class MenuOptionsTest {
    WebDriver driver = getDriver("chrome");

    @BeforeClass
    public void homepage() {
        utility.browse(driver);
    }

    @Test(priority = 0)
    public void test_0() {
        String username = "user177";
        String password = "UserUser123";
        utility.login(username, password, driver);
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Dashboard"));
    }

    @Test(priority = 1, enabled = false)
    public void test1() {

    }

    /*
    Navigate to Fleet à Vehicles, verify page title Car - Entities - System - Car - Entities - System, page name All Cars (updated)
     */
    @Test(priority = 2, description = "Navigate to Fleet")
    public void test2() {
        navigateToModule(driver, "Fleet", "Vehicles");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Car - Entities - System - Car - Entities - System"));

    }

    /*
    Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page name Accounts
     */
    @Test(priority = 3, description = "Navigate to Customers")
    public void test3() {
        navigateToModule(driver, "Customers", "Accounts");
        Assert.assertTrue(driver.getTitle().equals("Accounts - Customers"));

    }

    /*
    Navigate to Customers à Contacts, verify page title Contacts - Customers, verify page name Contacts (updated)
      */
    @Test(priority = 4, description = "Navigate to Customers")
    public void test4() {
        navigateToModule(driver, "Customers", "Contacts");

        Assert.assertTrue(driver.getTitle().equals("Contacts - Customers"));

    }

    /*
    Navigate to Activities à Calendar Events, verify page title Calendar Events - Activities, page
    name Calendar Events
     */
    @Test(priority = 5, description = "Navigate to Fleet")
    public void test5() {
        navigateToModule(driver, "Activities", "Calendar Events");
        Assert.assertTrue(driver.getTitle().equals("Calendar Events - Activities"));
    }
/*
Logout
 */
    @Test(priority = 6)
    public void test_6() {
        utility.logMeOut(driver);
        Assert.assertTrue(driver.findElement(By.id("_submit")).isEnabled());
    }

    //----------------------------------------------------------
    //TEST CASE: Menu options, store manager

    @Test(priority = 7)
    public void test_7() {
        String username = "storemanager210";
        String password = "UserUser123";
        utility.login(username, password, driver);
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Dashboard"));
    }
/*
Navigate to Dashboards à Dashboard, verify page title Dashboard - Dashboards, verify
page name Dashboard
 */

    @Test(priority = 8, description = "Navigate to Dashboards")
    public void test8() {
        navigateToModule(driver, "Dashboards", "Dashboard");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Dashboard - Dashboards"));

    }
/*
Navigate to Fleet à Vehicles, verify page title All - Car - Entities - System - Car - Entities -
System, page name All Cars (updated)
 */
    @Test(priority = 9, description = "Navigate to Fleet")
    public void test9() {
        navigateToModule(driver, "Fleet", "Vehicles");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("All - Car - Entities - System - Car - Entities - System"));

    }
/*
Navigate to Customers à Accounts, verify page title All - Accounts – Customers, verify
page name All Accounts(updated)
 */

    @Test(priority = 10, description = "Navigate to Customers")
    public void test10() {
        navigateToModule(driver, "Customers", "Accounts");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("All - Accounts – Customers"));

    }
/*
Navigate to Customers à Contacts, verify page title All - Contacts - Customers, verify page
name All Contacts (updated)
 */
    @Test(priority = 11, description = "Navigate to Customers")
    public void test11() {
        navigateToModule(driver, "Customers", "Contacts");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("All - Contacts - Customers"));

    }
/*
Navigate to Sales à Opportunities, verify page title Open Opportunities - Opportunities -
Sales, verify page name Open Opportunities
 */
    @Test(priority = 12, description = "Navigate to Sales")
    public void test12() {
        navigateToModule(driver, "Sales", "Opportunities");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Open Opportunities - Opportunities - Sales"));

    }
/*
Navigate to Activities à Calls verify page title All - Calls - Activities, page name All Calls
(updated)
 */
    @Test(priority = 13, description = "Navigate to Activities")
    public void test13() {
        navigateToModule(driver, "Activities", "Calls");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("All - Calls - Activities"));

    }
/*
Navigate to Activities à Calendar Events, verify page title Calendar Events - Activities, page
name All Calendar Events (updated)
 */

    @Test(priority = 14, description = "Navigate to Activities")
    public void test14() {
        navigateToModule(driver, "Activities", "Calendar Events");
        utility.hold(2);
        Assert.assertTrue(driver.getTitle().equals("Calendar Events - Activities"));
    }

    /*
Logout
 */
    @Test(priority = 15)
    public void test_15() {
        utility.logMeOut(driver);
        Assert.assertTrue(driver.findElement(By.id("_submit")).isEnabled());
    }

}
