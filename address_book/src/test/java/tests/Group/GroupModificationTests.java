package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup(){
        if (app.groups().getCount() == 0){
            app.groups().createGroup(new GroupDate("", "l", "lala","lalala"));
        }
        app.groups().modifyGroup(new GroupDate().withHeader("modified name"));
    }
}

