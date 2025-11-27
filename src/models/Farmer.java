import java.util.ArrayList;
import java.util.List;

public class Farmer extends User {
    private final List<CoffeeBean> products = new ArrayList<>();

    public Farmer(String name, String username, String password, String contactInfo, String location) {
        super(name, username, password, contactInfo, location);
    }

    public void addProduct(CoffeeBean bean) {
        products.add(bean);
    }

    public List<CoffeeBean> getProducts() {
        return products;
    }

    @Override
    public String getRole() {
        return "Farmer";
    }
}
