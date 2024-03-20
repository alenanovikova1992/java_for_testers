package manager;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ApplicationManager {
    protected WebDriver driver;
    private loginHelper session;
    private GropHelper groups;
    private ContactHelper contacts;
  public    void init(String browser) {
        if (driver == null){
            if ("Google Chrome".equals(browser)){
                driver = new ChromeDriver();
            }
            else if ("Microsoft Edge".equals(browser))
            {
             driver= new EdgeDriver();}
            else {
            throw  new IllegalArgumentException(String.format("Unknown browser %s", browser));}
            //js = (JavascriptExecutor) manager.ApplicationManager.driver;
            //vars = new HashMap<String, Object>();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/addressbook/");
            driver.manage().window().setSize(new Dimension(1302, 732));
           // driver.findElement(By.linkText("addressbook/")).click();
            session().login ("admin", "secret");
        }
    }

    public  loginHelper session(){
if (session == null){
session = new loginHelper(this);
    }
    return session;}

    public GropHelper groups()
    {
        if (groups == null){
            groups = new GropHelper (this);
        }
        return groups;
    }
    public ContactHelper contacts()
    {
        if (contacts == null){
            contacts = new ContactHelper(this);
        }
        return contacts;
    }

    public boolean isElementPresesent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }

    }

    @AfterEach
    public void tearDown() {
        //driver.findElement(By.linkText("logout")).click();
        driver.quit();
    }
}
