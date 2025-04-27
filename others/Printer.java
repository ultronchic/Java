import org.springframework.stereotype.Component;
public class Printer implements StockObserver {

    @Override
    public void update(Stock stock) {
        System.out.println("Акция " + stock.getName() + " теперь стоит " + stock.getPrice());
    }

}