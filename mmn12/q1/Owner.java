//class for owner details
public class Owner {

    private String ownerName;
    private String ownerPhone;

    //constructor
    public Owner(String ownerName, String ownerPhone) {
        this.ownerName = ownerName;
        this.ownerPhone= ownerPhone;
    }

    //return owner name
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    //return owner phone number
    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String toString(){
        return ("\nmy owner is: "+ownerName+" ,phone number:"+ownerPhone);
    }
}

