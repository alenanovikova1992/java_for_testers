package tests.Contact;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.Group.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.ArrayList;
/*public class ContactCreationTest extends TestBase {
    @Test
    public void canCreateContact() {
    app.contacts().createContact(new ContactDate("firstname", "middlename","lastname"));
    }
    @Test
    public void canCreateContactEmpty() {
        app.contacts().createContact(new ContactDate());
    }
   @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactDate().withlastname("some name"));


    }
}*/
public class ContactCreationTest extends TestBase {
    public static List<ContactDate> contactProvider() {
        var result = new ArrayList<ContactDate>();
        for (var firstname :List.of("", " firstname")){
            for (var middlename : List.of(""," middlename")){
                for (var lastname: List.of(""," lastname")){
                    result.add(new ContactDate(firstname, middlename,lastname)); }
            }
        }
        for (int i=0; i < 2; i++) {
            result.add(new ContactDate(randomString(i*10),randomString(i*10), randomString(i*10)));
        }
        return result;
    }
    public static List<ContactDate> negativeContactProvider() {
        var result = new ArrayList<ContactDate>(List.of(
                new ContactDate("firstname'","","")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactDate contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount+1,newContactCount);
    }


    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateGroup(ContactDate contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount,newContactCount);
    }
}
