package DSA_1.INVENTORY_MANAGEMENT_SYSTEM;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product :");
            System.out.println("2. Update Product :");
            System.out.println("3. Delete Product :");
            System.out.println("4. Get Product :");
            System.out.println("5. Exit");

            System.out.print("Enter your need: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(inventory, scanner);
                    break;
                case 2:
                    updateProduct(inventory, scanner);
                    break;
                case 3:
                    deleteProduct(inventory, scanner);
                    break;
                case 4:
                    getProduct(inventory, scanner);
                    break;
                case 5:
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Invalid option. Please try later.");
            }
        }
    }

    private static void addProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Product Name: ");
        String productName = scanner.next();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(productId, productName, quantity, price);
        inventory.addProduct(product);
        System.out.println("Product added successfully! to your List");
    }

    private static void updateProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter new Product Name: ");
        String productName = scanner.next();
        System.out.print("Enter new Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(productId, productName, quantity, price);
        inventory.updateProduct(productId, product);
        System.out.println("Product updated successfully!");
    }

    private static void deleteProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        inventory.deleteProduct(productId);
        System.out.println("Product Deleted successfully!");
    }

    private static void getProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        Product product = inventory.getProduct(productId);
        if (product != null) {
            System.out.println("Product found!");
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
        } else {
            System.out.println("Product not found!");
        }
    }
}