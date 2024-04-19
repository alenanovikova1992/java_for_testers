package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {
  private   WebDriver driver;
    private String string;
    private Properties properties;

    private SessionHelper sessionHelper;

    public void init(String browser) {
       this.string = browser;
       this.properties = properties;
    }
    public SessionHelper session(){
        if (sessionHelper == null){
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }

    public    WebDriver driver() throws MalformedURLException {
        if (driver == null){
            var seleniumServer  = properties.getProperty("SeleniumServer");
            if ("Google Chrome".equals(string)){
                if (seleniumServer != null){
                    driver  = new RemoteWebDriver(new URL(seleniumServer), new ChromeOptions());
                } else
                {
                    driver = new ChromeDriver();
                }


            }
            else if ("Microsoft Edge".equals(string))
            {if (seleniumServer != null)
            {
                driver  = new RemoteWebDriver(new URL(seleniumServer), new EdgeOptions());
            }
             else {
                driver= new EdgeDriver();}}
            else {
                throw  new IllegalArgumentException(String.format("Unknown browser %s", string));}
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
          //  driver.get(properties.getProperty("web.baseUrl"));
            driver.get("http://localhost/mantisbt-2.26.1/mantisbt-2.26.1/");
            driver.manage().window().setSize(new Dimension(1302, 732));
          //   session().login (properties.getProperty("web.username"),properties.getProperty("web.password"));
          //  driver.manage().window().setSize(new Dimension(1302, 732));
            // driver.get("http://localhost/mantisbt-2.26.1/mantisbt-2.26.1/");
            session().login ("administrator", "root");
        }
        return driver;
    }

}
