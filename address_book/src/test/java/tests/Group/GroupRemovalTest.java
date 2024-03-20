package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    @Test
    void canRemoveAllGroupsAtOnce(){
        if (app.groups().getCount()==0){
            app.groups().createGroup(new GroupDate("", "",""));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());
    }
}
