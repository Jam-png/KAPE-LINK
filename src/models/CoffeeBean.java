public class CoffeeBean {
    private final String farmerName;     // Farmer's name
    private final String contactInfo;    // Farmer's contact
    private final String productName;
    private final String variety;
    private final String quality;
    private final int quantity;
    private final double price;
    private final String availability;

    // Constructor used when creating a new product
    public CoffeeBean(String farmerName, String contactInfo, String productName,
                      String variety, String quality, int quantity,
                      double price, String availability) {
        this.farmerName = farmerName;
        this.contactInfo = contactInfo;
        this.productName = productName;
        this.variety = variety;
        this.quality = quality;
        this.quantity = quantity;
        this.price = price;
        this.availability = availability;
    }

    // Display product info
    public void display() {
        System.out.println("Farmer Name: " + farmerName);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Product: " + productName);
        System.out.println("Type/Variety: " + variety);
        System.out.println("Quality: " + quality);
        System.out.println("Quantity: " + quantity + " kg");
        System.out.println("Price: " + price + " per kg");
        System.out.println("Availability: " + availability);
        System.out.println("--------------------------");
    }

    // Getters
    public String getFarmerName() { return farmerName; }
    public String getContactInfo() { return contactInfo; }
    public String getProductName() { return productName; }
    public String getVariety() { return variety; }
    public String getQuality() { return quality; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getAvailability() { return availability; }
}
