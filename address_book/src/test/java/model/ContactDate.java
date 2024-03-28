package model;

public record ContactDate(String id, String firstname, String middlename, String lastname,String address, String photo) {
    public ContactDate(){
        this ("","","","","","");
    }

    public ContactDate withFirstname(String firstname) {
        return new ContactDate(this.id,firstname, this.middlename, this.lastname,this.address, this.photo);
    }
    public ContactDate withID(String id) {
        return new ContactDate(id, this.firstname, this.middlename, this.lastname,this.address, this.photo);
    }

    public ContactDate withMiddlename(String middlename) {
        return new ContactDate(this.id, this.firstname, middlename, this.lastname, this.address, this.photo);

    }

    public ContactDate withlastname(String lastname) {
        return new ContactDate(this.id, this.firstname, this.middlename, lastname, this.address, this.photo);

    }
    public ContactDate withAddress(String address) {
        return new ContactDate(this.id, this.firstname, this.middlename, lastname, address, this.photo);

    }
    public ContactDate withPhoto(String photo) {
        return new ContactDate(this.id, this.firstname, this.middlename, lastname, this.address, photo);

    }
}