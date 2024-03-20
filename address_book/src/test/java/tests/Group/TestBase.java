package tests.Group;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

import java.util.Map;
import java.util.Random;

public class TestBase {
    protected  static ApplicationManager app;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        if (app == null){
            app = new ApplicationManager();
        }
         app.init(System.getProperty("browser", "Google Chrome"));
    }

public String randomString (int n){
        var rnd = new Random();
        var result = "";
        for (int i=0; i<n; i++) {
        result = result + (char)('a'+rnd.nextInt(26));
        }
        return  result;
}
}
