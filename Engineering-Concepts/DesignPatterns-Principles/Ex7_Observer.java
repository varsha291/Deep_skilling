import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName);
}

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;

    public void setStock(String stockName) {
        this.stockName = stockName;
        notifyObservers();
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stockName) {
        System.out.println("Mobile App Notification: " + stockName);
    }
}

class WebApp implements Observer {
    public void update(String stockName) {
        System.out.println("Web App Notification: " + stockName);
    }
}

public class Ex7_Observer {
    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setStock("TCS Stock Price Updated");
    }
}