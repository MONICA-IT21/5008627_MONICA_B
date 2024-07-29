package INVENTORY_MANAGEMENT_SYSTEM;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map <Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product product) {
        if (products.containsKey(productId)) {
            products.put(productId, product);
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}