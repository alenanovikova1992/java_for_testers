package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.manager.ApplicationManager;
import ru.stqa.mantis.manager.HelperBase;

import java.net.MalformedURLException;

public class SessionHelper  extends HelperBase {
public SessionHelper(ApplicationManager manager) {
super(manager);
}
   public void login(String user, String password) throws MalformedURLException {
        type(By.name("username"), user);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));
    }
    public boolean isLoggedIn() throws MalformedURLException {
    return isElementPresent(By.cssSelector("span.user-info"));
    }
}
