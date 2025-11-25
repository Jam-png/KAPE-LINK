public class Buyer extends User {
    public Buyer(String name, String username, String password, String contactInfo, String location) {
        super(name, username, password, contactInfo, location);
    }

    @Override
    public String getRole() {
        return "Buyer";
    }
}
