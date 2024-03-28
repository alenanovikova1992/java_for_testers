package tests.Contact;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.Group.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
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
    }

/*
    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactDate contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
         Assertions.assertEquals(newContacts, oldContacts);
    }*/
}
