package Account_Types;

import java.util.UUID;

public abstract class Account {
    private UUID accID;
    private String username;
    private String password;

    public Account() {

    }

    public Account(String username, String password) {
        this.accID = UUID.randomUUID();
        this.username = username;
        this.password = password;
    }

    public UUID getAccID() {
        return accID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void editUserName(String newUsername){
        if (newUsername.equals(this.getUsername())){
            System.out.println("Nothing Changed.");
        } else {
            setUsername(newUsername);
            System.out.println("Changed.");
        }
    }

    public void editPassword(String newPassword){
        if (newPassword.equals(this.getPassword())){
            System.out.println("Nothing Changed.");
        } else {
            setPassword(newPassword);
            System.out.println("Changed.");
        }
    }

    @Override
    public String toString() {
        return
        "\nAccount ID: " + this.getAccID() +
        "\nUsername: " + this.getUsername() +
        "\nPassword: " + this.getPassword();
    }

    public abstract boolean doesAccountExist(String username);
    public abstract boolean accountLogin(String username, String password);

}
