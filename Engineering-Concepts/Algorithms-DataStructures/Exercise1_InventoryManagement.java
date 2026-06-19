import java.util.HashMap;
import java.util.Map;

public class Exercise1_InventoryManagement {
    static class Product {
        int productId;
        String productName;
        int quantity;
        double price;

        Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + productId
                    + ", Name: " + productName
                    + ", Quantity: " + quantity
                    + ", Price: " + price;
        }
    }

    private final Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println("Product added: " + product.productName);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        product.quantity = quantity;
        product.price = price;
        System.out.println("Product updated: " + product.productName);
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) == null) {
            System.out.println("Product not found: " + productId);
        } else {
            System.out.println("Product deleted: " + productId);
        }
    }

    public void displayProducts() {
        System.out.println("Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        Exercise1_InventoryManagement system = new Exercise1_InventoryManagement();
        system.addProduct(new Product(101, "Laptop", 10, 55000));
        system.addProduct(new Product(102, "Mouse", 50, 500));

        system.displayProducts();

        system.updateProduct(101, 15, 53000);
        system.deleteProduct(102);
        system.displayProducts();

        System.out.println("\nComplexity:");
        System.out.println("HashMap add, update, and delete are O(1) on average and O(n) in rare collision-heavy cases.");
    }
}
