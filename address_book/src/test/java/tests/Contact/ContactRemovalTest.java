package tests.Contact;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactDate("udalenie","udalenie","udalenie"));
        }
        app.contacts().removeContact();
    }

}
