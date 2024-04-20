package ru.stqa.mantis.manager;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class HelperBase {
    protected final ApplicationManager manager;
    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }
    protected void type(By locator, String text) throws MalformedURLException {
        click(locator);
        manager.driver().findElement(locator).clear();
        manager.driver().findElement(locator).sendKeys(text);
    }
protected boolean isElementPresent(By locator) throws MalformedURLException {
     return manager.driver().findElements(locator).size()>0;
}
    protected void click(By locator) throws MalformedURLException {
        manager.driver().findElement(locator).click();
    }
}
