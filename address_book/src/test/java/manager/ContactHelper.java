package manager;

import model.ContactDate;
import org.openqa.selenium.By;
public class ContactHelper extends  HelperBase{
    public ContactHelper(ApplicationManager manager ){
        super(manager);
    }
    public void createContact(ContactDate contact) {
        openContactPage();
        openNewContactPage();
        fillContactForm(contact);
    }
    private void fillContactForm(ContactDate contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        click(By.cssSelector("input:nth-child(75)"));
    }

    public void removeContact() {
        openContactPage();
        selectContact();
        removeSelectedContact();
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
        click(By.name("Delete"));
    }
    private void returnToContactPage() {
        click(By.linkText("add new"));
    }
      private void selectContact() {
     click(By.id("8"));
    }

}
