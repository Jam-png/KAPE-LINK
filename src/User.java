public abstract class User {
    protected String name;
    protected String username;
    protected String password;
    protected String contactInfo;
    protected String location;

    public User(String name, String username, String password, String contactInfo, String location) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.contactInfo = contactInfo;
        this.location = location;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }

    public abstract String getRole();
}
