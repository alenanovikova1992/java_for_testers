package manager;

import org.openqa.selenium.By;

public class loginHelper extends  HelperBase {
    private ApplicationManager manager;

   public  loginHelper (ApplicationManager manager ){
    super(manager);
     //   this.manager = manager;
    }
     void login(String user, String password) {
       type(By.name("user"),user);
       type(By.name("pass"),password);
       click(By.cssSelector("input:nth-child(7)"));
    }
}
