package ECOMMERCE_PLATFORM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ecommerce_main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "T-shirt", "Clothing"),
            new Product("4", "Jeans", "Clothing"),
            new Product("5", "Coffee Maker", "Home Appliances")
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name to search:");
        String productName = scanner.nextLine();

        // Linear Search
        int linearIndex = LinearSearch.linearSearch(products, productName);
        if (linearIndex != -1) {
            System.out.println("Product found using linear search: " + products[linearIndex]);
        } else {
            System.out.println("Product not found using linear search.");
        }

        // Binary Search
        int binaryIndex = BinarySearch.binarySearch(products, productName);
        if (binaryIndex != -1) {
            System.out.println("Product found using binary search: " + products[binaryIndex]);
        } else {
            System.out.println("Product not found using binary search.");
        }

        scanner.close();
    }
}

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class LinearSearch {
    public static int linearSearch(Product[] products, String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}

class BinarySearch {
    public static int binarySearch(Product[] products, String productName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = productName.compareTo(products[mid].getProductName());
            if (result == 0) {
                return mid;
            }
            if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
