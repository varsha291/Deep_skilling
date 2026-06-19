import java.util.Arrays;

public class Exercise3_SortingCustomerOrders {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return orderId + " - " + customerName + " - Rs." + totalPrice;
        }
    }

    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    swap(orders, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int smallerIndex = low - 1;

        for (int current = low; current < high; current++) {
            if (orders[current].totalPrice <= pivot) {
                smallerIndex++;
                swap(orders, smallerIndex, current);
            }
        }

        swap(orders, smallerIndex + 1, high);
        return smallerIndex + 1;
    }

    private static void swap(Order[] orders, int first, int second) {
        Order temp = orders[first];
        orders[first] = orders[second];
        orders[second] = temp;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(1, "Anika", 4500),
                new Order(2, "Rahul", 1200),
                new Order(3, "Meera", 8200),
                new Order(4, "Kiran", 3100)
        };

        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSorted);
        System.out.println("Bubble sort: " + Arrays.toString(bubbleSorted));

        Order[] quickSorted = Arrays.copyOf(orders, orders.length);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("Quick sort: " + Arrays.toString(quickSorted));

        System.out.println("\nComplexity:");
        System.out.println("Bubble Sort is O(n^2). Quick Sort averages O(n log n), so it is preferred for larger lists.");
    }
}
