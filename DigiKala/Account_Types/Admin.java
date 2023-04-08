package Account_Types;

public class Admin extends Account{

    private String emailAddress;

    public Admin() {

    }

    public Admin(String username, String password, String emailAddress) {
        super(username, password);
        this.emailAddress = emailAddress;
    }


    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nEmail Address: " + this.getEmailAddress();
    }

    @Override
    public boolean accountLogin(String username, String password) {
        return this.getUsername().equalsIgnoreCase(username) && this.getPassword().equals(password);
    }

    @Override
    public boolean doesAccountExist(String username) {
        return this.getUsername().equalsIgnoreCase(username);
    }

}
