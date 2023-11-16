package org.brazdahonza;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommetce_tc_3 extends BaseTest {

    @Test
    public void checkProductInCartTest() throws InterruptedException {
        Thread.sleep(4000);
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Johnson");
        androidDriver.hideKeyboard();
        androidDriver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollToText("Bolivia");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Bolivia\"]"))
                .click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        androidDriver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        androidDriver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(androidDriver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));

        String firstPrice = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        String secondPrice = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();

        int firstPriceInt = Integer.parseInt(firstPrice.substring(1));
        int secondPriceInt = Integer.parseInt(secondPrice.substring(1));

        int sum = firstPriceInt + secondPriceInt;

        String totalAmount = androidDriver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    }
}
