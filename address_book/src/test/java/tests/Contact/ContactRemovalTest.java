package tests.Contact;

import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveGroup() {
       // app.groups().openGroupsPage();
        if (app.groups().isGroupPresent()){
            app.groups().createGroup(new GroupDate("", "",""));
        }
        app.groups().removeGroup();
    }

}
