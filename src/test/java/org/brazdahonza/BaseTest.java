package org.brazdahonza;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver androidDriver;
    public AppiumDriverLocalService appiumDriverLocalService;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        appiumDriverLocalService = new AppiumServiceBuilder().withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        appiumDriverLocalService.start();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("Pixel 7 API 33");
        uiAutomator2Options.setApp("/Users/brazdahonza/IdeaProjects/projekty/appium-java-test2/src/test/java/resources/General-Store.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
        appiumDriverLocalService.stop();
    }

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of("direction", "down", "left", 100, "top", 100, "width", 200, "height", 200, "percent", 3.0));
        } while (canScrollMore);
    }

    public void swipeGesture(WebElement ele, String direction) {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId()), "direction", direction);
    }

    public void scrollToText(String text) {
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }
}