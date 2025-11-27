public class CoffeeBean {
    private final String name;
    private final String contactInfo;
    private final String productName;
    private final String variety;
    private String quality = null;
    private final int quantity;
    private final double price;
    private String availability = null;

    public CoffeeBean(String name, String contactInfo, String productName, String variety, String quality, int quantity, double price, String availability) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.productName = productName;
        this.variety = variety;
        this.quality = quality;
        this.quantity = quantity;
        this.price = price;
        this.availability = availability;
    }

    public void display() {
        System.out.println("Farmer Name: " + name);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Product: " + productName);
        System.out.println("Type/Variety: " + variety);
        System.out.println("Quality: " + quality);
        System.out.println("Quantity: " + quantity + " kg");
        System.out.println("Price: " + price + " per kg");
        System.out.println("Availability: " + availability);
        System.out.println("--------------------------");
    }
}
