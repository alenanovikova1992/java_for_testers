package tests;

import model.GroupDate;
import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase{


    @Test
    public void canCreateGroup() {
      // app.groups().openGroupsPage();
        app.groups().createGroup(new GroupDate("name", "header","footer"));
    }

    @Test
    public void canCreateGroupEmpty() {
        //app.groups().openGroupsPage();
        app.groups().createGroup(new GroupDate());

    }
    @Test
    public void canCreateGroupWithNameOnly() {
       // app.groups().openGroupsPage();
        app.groups().createGroup(new GroupDate().withHeader("some name"));


    }
}
