package tests.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.Group.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class ContactCreationTest extends TestBase {
    public static List<ContactDate> contactProvider() throws IOException {
        var result = new ArrayList<ContactDate>();
        var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();
        var value = mapper.readValue(json, new TypeReference<List<ContactDate>>() {});
        result.addAll(value);
        return  result;
    }
    @Test
    public void canCreateContact() {
    var  contact = new ContactDate()
            .withFirstname(randomString(10))
            .withlastname(randomString(10))
            .withPhoto(randomFile("src/test/resources/images"));
    app.contacts().createContact(contact);
    }
    public  static String randomString(int n){
        var rnd = new Random();
        var result = "";
        for (int i=0; i< n; i++){
            result=result+(char)('a'+rnd.nextInt(26));
        }
        return result;
    }
    public  static String randomFile(String dir){
        var fileNames =new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
      return   Paths.get(dir,fileNames[index]).toString();

    }



    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactDate contact) {
        var oldContacts= app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts= app.contacts().getList();
        Comparator<ContactDate> compareByID = (o1,o2) ->{
            return  Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt((o2).id()));

        };
        newContacts.sort(compareByID);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withID(newContacts.get(newContacts.size()-1).id()).withlastname("").withMiddlename(""));
        expectedList.sort(compareByID);
        Assertions.assertEquals(newContacts,expectedList);
    }}
/*
public class ContactCreationTest extends TestBase {
    public static List<ContactDate> contactProvider() {
        var result = new ArrayList<ContactDate>();
        for (var firstname :List.of("", " firstname")){
            for (var middlename : List.of(""," middlename")){
                for (var lastname: List.of(""," lastname")){
                    result.add(new ContactDate().withName(firstname).withMiddlename(middlename).withlastname(lastname)); }
            }
        }
        for (int i=0; i < 2; i++) {
            result.add(new ContactDate()
                    .withName(randomString(i*10))
                    .withMiddlename(randomString(i*10))
                     .withlastname(randomString(i*10)));

        }
        return result;
    }
    public static List<ContactDate> negativeContactProvider() {
        var result = new ArrayList<ContactDate>(List.of(
                new ContactDate("","'","","")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactDate contact) {
        var oldContacts= app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts= app.contacts().getList();
        Comparator<ContactDate> compareByID = (o1,o2) ->{
            return  Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt((o2).id()));

        };
        newContacts.sort(compareByID);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withID(newContacts.get(newContacts.size()-1).id()).withlastname("").withMiddlename(""));
        expectedList.sort(compareByID);
        Assertions.assertEquals(newContacts,expectedList);
    }*/

/*
    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactDate contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
         Assertions.assertEquals(newContacts, oldContacts);
    }
}*/
