package tests.Contact;
import model.ContactDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import tests.Group.TestBase;
public class ContactModificationTest extends TestBase {

    @Test
    void canModifyContact(){
        if (app.contacts().getCount() == 0){
            app.contacts().createContact(new ContactDate("", "l", "lalja","lalajla","",""));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testDate = new ContactDate().withFirstname("modified name");
        app.contacts().modifyContact(oldContacts.get(index), testDate);
        var newContact = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index,testDate.withID(oldContacts.get(index).id()));
        Comparator<ContactDate> compareByID = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareByID);
        expectedList.sort(compareByID);
        Assertions.assertEquals(newContact,expectedList);

    }
}
