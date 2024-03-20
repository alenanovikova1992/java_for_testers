package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Test;
import manager.TestBase;

public class GroupRemovalTest extends TestBase {

    @Test
    public void canRemoveGroup() {
       // app.groups().openGroupsPage();
        if (app.groups().isGroupPresent()){
            app.groups().createGroup(new GroupDate("", "",""));
        }
        app.groups().removeGroup();
    }

}
