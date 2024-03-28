package manager;

import model.GroupDate;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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
        selectGroup(null);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }
    public void removeGroup(GroupDate group) {
        openGroupsPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }
    public void openGroupsPage() {
        if ( !manager.isElementPresesent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }



    private void removeSelectedGroups() {
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


    private void selectGroup(GroupDate group) {
    //  openGroupsPage();
      click(By.cssSelector(String.format("input[value='%s']",group.id())));
       // click(By.linkText("groups"));
       // click(By.name("selected[]"));

    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllGroups() {
        openGroupsPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        var checkboxes =  manager.driver.findElements(By.name("selected[]"));
        for (var checkbox: checkboxes){
            checkbox.click();
        }
    }

    public List<GroupDate> getList() {
        var groups = new ArrayList<GroupDate>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        for (var span : spans ){
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id  = checkbox.getAttribute("value");
            groups.add(new GroupDate().withId(id).withName(name));
        }
        return groups;
    }
}
