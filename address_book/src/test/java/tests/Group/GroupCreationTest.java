package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import manager.TestBase;

public class GroupCreationTest extends TestBase {
    @Test
    public void canCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupDate("name", "header","footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount+1,newGroupCount);
    }
    @Test
    public void canCreateGroupEmpty() {
        app.groups().createGroup(new GroupDate());
    }
    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupDate().withHeader("some name"));
    }
}
