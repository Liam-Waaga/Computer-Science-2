
public class PhoneBook {

    private String name;
    private String address;
    private String email;
    private String cellnumber;

    /* null is permitted, substituted for "unknown" */
    public PhoneBook(String name, String address, String email, String cellnumber) {
        this.name = name == null ? "unkown" : name;
        this.address = address == null ? "unkown" : address;
        this.email = email == null ? "unkown" : email;
        this.cellnumber = cellnumber == null ? "unkown" : cellnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public String toString() {
        return String.format("%s lives at %s and can be contacted at %s or %s", name, address, email, cellnumber);
    }
}
