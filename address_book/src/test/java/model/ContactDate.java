package model;

public record ContactDate(String id, String firstname, String middlename, String lastname) {
    public ContactDate(){
        this ("","","","");
    }

    public ContactDate withName(String firstname) {
        return new ContactDate(this.id,firstname, this.middlename, this.lastname);
    }
    public ContactDate withID(String id) {
        return new ContactDate(id, this.firstname, this.middlename, this.lastname);
    }

    public ContactDate withMiddlename(String middlename) {
        return new ContactDate(this.id, this.firstname, middlename, this.lastname);

    }

    public ContactDate withlastname(String lastname) {
        return new ContactDate(this.id, this.firstname, this.middlename, lastname);

    }
}