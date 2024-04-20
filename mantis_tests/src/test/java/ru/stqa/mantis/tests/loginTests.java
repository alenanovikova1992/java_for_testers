package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class loginTests extends TestBase{
    @Test
    void canLogin() throws MalformedURLException {
        app.session().login("administrator","root");
        Assertions.assertTrue(app.session().isLoggedIn());
    }

}
