package tests.Group;

import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class GroupModificationTests extends TestBase {

    @Test
    void canModifyGroup(){
        if (app.groups().getCount() == 0){
            app.groups().createGroup(new GroupDate("", "l", "lala","lalala"));
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testDate = new GroupDate().withName("modified name");
        app.groups().modifyGroup(oldGroups.get(index), testDate);
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index,testDate.withId(oldGroups.get(index).id()));
        Comparator<GroupDate> compareByID = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareByID);
        expectedList.sort(compareByID);
        Assertions.assertEquals(newGroups,expectedList);

    }
}

