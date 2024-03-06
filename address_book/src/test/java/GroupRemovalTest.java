import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class GroupRemovalTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1302, 732));
    driver.findElement(By.linkText("addressbook/")).click();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }
  @AfterEach
  public void tearDown() {
    //driver.findElement(By.linkText("logout")).click();
    driver.quit();
  }

  private boolean isElementPresesent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException exception) {
      return false;
    }

  }


  @Test
  public void canRemoveGroup() {
    if (!isElementPresesent(By.name("new"))) {
      driver.findElement(By.linkText("groups")).click();
    }
    if (!isElementPresesent(By.name("selected[]"))){
      driver.findElement(By.name("new")).click();
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).sendKeys("");
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).sendKeys("");
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).sendKeys("");
      driver.findElement(By.name("submit")).click();
      driver.findElement(By.linkText("groups")).click();
    }
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.name("delete")).click();
    driver.findElement(By.linkText("group page")).click();
   // driver.findElement(By.cssSelector(".group:nth-child(8) > input")).click();
  //  driver.findElement(By.cssSelector("input:nth-child(14)")).click();
  //  driver.close();
  }
}
