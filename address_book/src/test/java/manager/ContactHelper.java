package manager;

import model.ContactDate;
import model.GroupDate;
import org.openqa.selenium.By;

public class ContactHelper extends  HelperBase{
    public ContactHelper(ApplicationManager manager ){
        super(manager);

    }
    public void createContact(ContactDate contact) {
        openContactPage();
        openNewContactPage();
        fillContactForm(contact);
        // initContactCreation();
        // submitContactCreation();
        //  returnToContactPage();


    }
    private void fillContactForm(ContactDate contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        click(By.cssSelector("input:nth-child(75)"));
    }

    public void modifyContact(ContactDate contact) {
        openContactPage();
        openNewContactPage();
      //  selectContact();
     //   initContactModification();
      //  fillContactForm(contact);
     //   submitContactModification();
     //   returnToContactPage();
    }
    public void removeContact() {
        openContactPage();
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

        return manager.isElementPresesent(By.name("selected[]"));
    }



    private void removeSelectedContact() {
        click(By.name("delete"));
    }




    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void initContactCreation() {
        click(By.name("add new"));
    }



    private void returnToContactPage() {
        click(By.linkText("add new"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }


    private void selectContact() {
        openContactPage();
        click(By.linkText("new"));
        click(By.name("selected[]"));

    }

    private void initContactModification() {
        click(By.name("edit"));
    }

}
