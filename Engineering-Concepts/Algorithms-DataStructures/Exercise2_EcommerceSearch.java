import java.util.Arrays;
import java.util.Comparator;

public class Exercise2_EcommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String productName) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = sortedProducts[mid].productName.compareToIgnoreCase(productName);

            if (comparison == 0) {
                return sortedProducts[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Book", "Education"),
                new Product(104, "Phone", "Electronics")
        };

        System.out.println("Linear search: " + linearSearch(products, "Phone"));

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(product -> product.productName.toLowerCase()));
        System.out.println("Binary search: " + binarySearch(sortedProducts, "Phone"));

        System.out.println("\nComplexity:");
        System.out.println("Linear search is O(n). Binary search is O(log n), but requires sorted data.");
    }
}
