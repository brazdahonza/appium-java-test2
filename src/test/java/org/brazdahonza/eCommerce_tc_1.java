package org.brazdahonza;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void fillForm() throws InterruptedException {
        Thread.sleep(4000);
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Johnson");
        androidDriver.hideKeyboard();
        androidDriver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollToText("Bolivia");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Bolivia\"]"))
                .click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // All the android toasts are identified by the class name "android.widget.Toast"
//        String widgetName = androidDriver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
//        Assert.assertEquals(widgetName, "Please enter your name");

        Thread.sleep(5000);
    }
}
