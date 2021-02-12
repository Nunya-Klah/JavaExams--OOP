import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stocks extends Product implements MontrealTradeProducts {
    private String ticker;
    private String exchange;

    public Stocks(String productID, double price, int quantity, String ticker, String exchange, List<Product> stockList) {
        super(productID, price, quantity);
        this.ticker = ticker;
        this.exchange = exchange;
        this.stockList = stockList;
    }

    public List<Product> getStockList() {
        return stockList;
    }

    private List<Product> stockList = new ArrayList<>();

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        List<Product> stocks = stockList.stream().filter(s -> s.getProductID() == product.getProductID()).collect(Collectors.toList());
        if (stocks.isEmpty()){
            stockList.add(product);
        }else{
            throw new ProductAlreadyRegisteredException("Stock ID already exists");
        }
    }

    @Override
    public void trade(Product product, int quantity) throws  ProductNotRegisteredException {
        Optional<Product> stocks = stockList.stream().filter(p -> product.getProductID() == p.getProductID()).findFirst();
        if(stocks.isEmpty()){
            throw new ProductNotRegisteredException("This stock has not been registered for tracking");
        }else{
            stocks.stream().map(Product:: getQuantity );
        }
    }

    @Override
    public int totalTradeQuantityForDay() {
        int totalQuantity = stockList.stream().map(Product::getQuantity).reduce(0,(a,b) -> a+b);
        return totalQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {

        return 0;
    }
}
