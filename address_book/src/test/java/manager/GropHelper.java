package manager;

import model.GroupDate;
import org.openqa.selenium.By;

public class GropHelper extends  HelperBase{
    public GropHelper (ApplicationManager manager ){
        super(manager);

    }
    public void createGroup(GroupDate group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();

    }
    private void fillGroupForm(GroupDate group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    public void modifyGroup(GroupDate modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }
    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }
    public void openGroupsPage() {
        if ( !manager.isElementPresesent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }



    private void removeSelectedGroup() {
        click(By.name("delete"));
    }




    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }



    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }


    private void selectGroup() {
        openGroupsPage();
        click(By.linkText("groups"));
        click(By.name("selected[]"));

    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
