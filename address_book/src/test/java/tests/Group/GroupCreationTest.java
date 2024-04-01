package tests.Group;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.CommonFunctions;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class GroupCreationTest extends TestBase {
    public static List<GroupDate> groupProvider() throws IOException {
        var result = new ArrayList<GroupDate>();
     /*   var json = "";
        try (var reader = new FileReader("groups.json");
             var breader = new BufferedReader(reader))
        { var line = breader.readLine();
        while (line != null){
            json = json +line;
            line = breader.readLine();
        }
        }*/
        var json = Files.readString(Paths.get("groups.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<GroupDate>>() {});
        result.addAll(value);
        return  result;


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
