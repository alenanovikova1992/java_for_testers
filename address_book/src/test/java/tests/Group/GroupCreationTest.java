package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class GroupCreationTest extends TestBase {
    @Test
    public void canCreateGroup() {
        app.groups().createGroup(new GroupDate("name", "header","footer"));
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
