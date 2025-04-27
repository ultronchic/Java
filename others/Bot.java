import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Bot implements StockObserver {

    @Value("${stock.name.orcl}")
    private String stockName;

    @Override
    public void update(Stock stock) {
        if ("ORCL".equals(stock.getName()) && stock.getPrice() < 70) {
            System.out.println("Надо покупать ORCL");

    @Override
    public void update(Stock stock) {
        if (stockName.equals(stock.getName()) && stock.getPrice() < 70) {
            System.out.println("Надо покупать ORCL");
                }
        }
    @Component
    public class Bot implements StockObserver {
            }
