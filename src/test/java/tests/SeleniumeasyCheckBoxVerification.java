package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class SeleniumeasyCheckBoxVerification {

    @Test
    public void TC2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Verify “Success – Check box is checked” message is NOT displayed.
        WebElement checkBoxMessage = driver.findElement(By.id("txtAge"));
        Assert.assertFalse(checkBoxMessage.isDisplayed());

        //Click to checkbox under “Single Checkbox Demo” section
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        checkBox.click();

        Thread.sleep(2000);

        Assert.assertTrue(checkBoxMessage.isDisplayed());


    }
    @Test
    public void TC3(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllButton = driver.findElement(By.id("check1"));

        //Verify “Check All” button text is “Check All”
        Assert.assertEquals(checkAllButton.getAttribute("value"),"Check All","verify that Check All button text is Check All");

        //Click to “Check All” button
        checkAllButton.click();

        //Verify all check boxes are checked

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement checkBox3 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement checkBox4 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));

        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());
        Assert.assertTrue(checkBox3.isSelected());
        Assert.assertTrue(checkBox4.isSelected());

        //Verify button text changed to “Uncheck All”
        Assert.assertEquals(checkAllButton.getAttribute("value"),"Uncheck All","verify that Check All button text is Uncheck All");
    }

}
