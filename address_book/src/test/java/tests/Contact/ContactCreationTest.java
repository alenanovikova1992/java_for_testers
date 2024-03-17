package tests.Contact;

import model.ContactDate;
import model.GroupDate;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactCreationTest extends TestBase {


    @Test
    public void canCreateContact() {
      // app.groups().openGroupsPage();
        app.contacts().createContact(new ContactDate("firstname", "middlename","lastname"));
    }

  /*  @Test
    public void canCreateContactEmpty() {
        //app.groups().openGroupsPage();
        app.contacts().createContact(new ContactDate());

    }*/


   /* @Test
    public void canCreateContactWithNameOnly() {
       // app.groups().openGroupsPage();
        app.contacts().createContact(new ContactDate().withHeader("some name"));


    }*/
}
