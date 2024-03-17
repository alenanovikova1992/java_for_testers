package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup(){
        if (app.groups().isGroupPresent()){
            app.groups().createGroup(new GroupDate("l", "lala","lalala"));
        }
        app.groups().modifyGroup(new GroupDate().withHeader("modified name"));
    }
}

