import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String name; // Имя акции (неизменяемое)
    private int price; // Цена акции
    private final List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, int initialPrice) {
        this.name = name;
        this.price = initialPrice;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }

        public void addObserver(StockObserver observer) {
            observers.add(observer);
        }
}