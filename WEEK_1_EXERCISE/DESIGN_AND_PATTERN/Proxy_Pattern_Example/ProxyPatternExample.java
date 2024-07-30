package DESIGN_AND_PATTERN.Proxy_Pattern_Example;

public class ProxyPatternExample {
    public static void main(String[] args) {
        ProxyImage image1 = new ProxyImage("image1.jpg");
        ProxyImage image2 = new ProxyImage("image2.jpg");

        image1.display();
        image1.display(); 

        image2.display();
    }
}