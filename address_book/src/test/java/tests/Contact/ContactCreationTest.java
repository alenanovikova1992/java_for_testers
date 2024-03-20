package tests.Contact;

import model.ContactDate;
import org.junit.jupiter.api.Test;
import manager.TestBase;
public class ContactCreationTest extends TestBase {
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
}
