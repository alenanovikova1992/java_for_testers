package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import manager.TestBase;

public class GroupRemovalTest extends TestBase {

    @Test
    public void canRemoveGroup() {
       // app.groups().openGroupsPage();
        if (app.groups().getCount()==0){
            app.groups().createGroup(new GroupDate("", "",""));
        }
        int groupCount = app.groups().getCount();
        app.groups().removeGroup();
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount-1,newGroupCount);

    }

}
