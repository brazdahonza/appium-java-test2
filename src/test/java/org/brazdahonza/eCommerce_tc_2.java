package org.brazdahonza;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class eCommerce_tc_2 extends BaseTest {

    @Test
    public void addToCartTest() throws InterruptedException {
        Thread.sleep(4000);
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Johnson");
        androidDriver.hideKeyboard();
        androidDriver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollToText("Bolivia");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text=\"Bolivia\"]"))
                .click();
        androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        scrollToText("PG 3");

        int productCount = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i = 0; i < productCount; i++) {
            String text = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(text.equalsIgnoreCase("PG 3")) {
                androidDriver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        androidDriver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(5000);
    }
}
