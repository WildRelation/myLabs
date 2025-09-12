public class User {
    private final String username;
    private final String mail;
    private String password;

    public User(String username, String mail, String password){
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
