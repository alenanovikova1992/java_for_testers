package tests.Group;

import io.qameta.allure.Allure;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupRemovalTest extends TestBase {

    @Test
    public void canRemoveGroup() {

        Allure.step("Checking precondition",step ->{
            if (app.groups().getCount()==0) {
                app.groups().createGroup(new GroupDate("", "group", "header", "footer"));
            }});

        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Allure.step("Validating results", step ->{
            Assertions.assertEquals(newGroups,expectedList);
                });


    }
    @Test
    void canRemoveAllGroupsAtOnce(){
        if (app.groups().getCount()==0){
            app.groups().createGroup(new GroupDate("", "", "",""));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());
    }
}
