package manager;

import model.ContactDate;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends  HelperBase{
    public ContactHelper(ApplicationManager manager ){
        super(manager);
    }
    public void createContact(ContactDate contact) {
        openContactPage();
        openNewContactPage();
        fillContactForm(contact);
        submitContactCreation();
        openContactPage();
      //  returnToContactsPage();
    }

    private void fillContactForm(ContactDate contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        attach(By.name("photo"),contact.photo());
        // click(By.cssSelector("input:nth-child(75)"));
    }
    private void submitContactCreation() {
       // click(By.name("submit"));
        click(By.cssSelector("input:nth-child(75)"));
    }
    private void returnToContactsPage() {
        click(By.linkText("home"));
    }

    public void removeContact() {
        openContactPage();
        selectContactAll();
        removeSelectedContact();
        returnToContactPage();

    }
    public void modifyContact(ContactDate contact, ContactDate modifiedContact) {
        openContactPage();
        selectContact(contact);
        initContactModification();
        fillContactForm(contact);
        submitContactModification();
        returnToContactPage();
    }

    public void openNewContactPage() {
            click(By.linkText("add new"));
    }
    public void openContactPage() {
        click(By.linkText("home"));
    }
    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresesent(By.name("By.cssSelector(\".odd:nth-child(3) > .center:nth-child(8) img\") "));
    }
    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }
    private void returnToContactPage() {
        click(By.linkText("add new"));
    }
      private void selectContactAll() {
          // manager.driver.findElements(By.name("selected[]"));
          click(By.xpath("//input[@id=\'MassCB\']"));
    }
    private void selectContact(ContactDate contact) {
        // manager.driver.findElements(By.name("selected[]"));
        click(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }
    private void initContactModification() {
        click(By.name("edit"));
    }

    private void submitContactModification() {

       // click(By.name("update")

        click(By.cssSelector("input:nth-child(75)"));
    }
    public int getCount() {
        openContactPage();
                return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactDate> getList() {
        openContactPage();
        var contacts = new ArrayList<ContactDate>();
       // var spans = manager.driver.findElements(By.cssSelector("span.contact"));
        var spans = manager.driver.findElements(By.name("selected[]"));
        for (var span : spans ){
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id  = checkbox.getAttribute("value");
            contacts.add(new ContactDate().withID(id).withFirstname(name) );
        }
        return contacts;
    }
}
