package tests.Contact;

import model.ContactDate;
import org.junit.jupiter.api.Test;
import tests.Group.TestBase;

public class ContactRemovalTest extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contacts().isContactPresent()){
            app.contacts().createContact(new ContactDate("udalenie","udalenie","udalenie"));
        }
        app.contacts().removeContact();
    }

}
