package manager;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

import java.util.Map;

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


}
