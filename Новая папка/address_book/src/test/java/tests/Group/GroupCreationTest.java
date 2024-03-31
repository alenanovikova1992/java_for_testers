package tests.Group;
import common.CommonFunctions;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class GroupCreationTest extends TestBase {
    public static List<GroupDate> groupProvider() {
        var result = new ArrayList<GroupDate>();
        for (var name :List.of("", "group name")){
            for (var header : List.of("","group header")){
                for (var footer: List.of("","group footer")){
                    result.add(new GroupDate().withName(name).withHeader(header).withFooter(footer)); }
            }
        }
        for (int i=0; i < 2; i++) {
            result.add(new GroupDate()
                    .withName(CommonFunctions.randomString(i*10))
                    .withHeader(CommonFunctions.randomString(i*10))
                    .withFooter(CommonFunctions.randomString(i*10)));
        }
        return result;
    }


    public static List<GroupDate> negativeGroupProvider() {
        var result = new ArrayList<GroupDate>(List.of(
                new GroupDate("", "'","","")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroup(GroupDate group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Comparator<GroupDate> compareByID = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareByID);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size()-1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareByID);
        Assertions.assertEquals(newGroups, expectedList);
    }
    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupDate group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
               Assertions.assertEquals(newGroups, oldGroups);
    }
}
