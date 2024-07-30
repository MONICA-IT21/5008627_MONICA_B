
public class ObserverPatternExample {
    public static <StockMarket> void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApplication();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(120.0);

        stockMarket.deregisterObserver(webApp);

        stockMarket.setStockPrice(150.0);
    }
}