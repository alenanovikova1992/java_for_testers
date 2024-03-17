package model;

public record ContactDate(String firstname, String middlename, String lastname) {
    public ContactDate(){
        this ("firstname","middlename","lastname");
    }

    public ContactDate withName(String someName) {
        return new ContactDate(firstname, this.middlename, this.lastname);
    }

    public ContactDate withMiddlename(String middlename) {
        return new ContactDate(this.firstname, middlename, this.lastname);

    }

    public ContactDate withlastname(String lastname) {
        return new ContactDate(this.firstname, this.middlename, lastname);

    }
}