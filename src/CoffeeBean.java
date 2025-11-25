public class CoffeeBean {
    private final String productName;
    private final String variety;
    private final String quality;
    private final int quantity;
    private final double price;
    private final String availability;

    public CoffeeBean(String productName, String variety, String quality, int quantity, double price, String availability) {
        this.productName = productName;
        this.variety = variety;
        this.quality = quality;
        this.quantity = quantity;
        this.price = price;
        this.availability = availability;
    }

    public void display() {
        System.out.println("Product: " + productName);
        System.out.println("Type/Variety: " + variety);
        System.out.println("Quality: " + quality);
        System.out.println("Quantity: " + quantity + " kg");
        System.out.println("Price: ₱" + price + " per kg");
        System.out.println("Availability: " + availability);
        System.out.println("--------------------------");
    }
}
