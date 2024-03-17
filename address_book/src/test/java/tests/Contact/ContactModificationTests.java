package tests.Contact;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyGroup(){
        if (app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactDate("l", "lala","lalala"));
        }
        app.contacts().modifyContact(new ContactDate().withlastname("modified name"));
    }
}

