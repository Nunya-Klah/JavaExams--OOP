import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Futures extends Product implements MontrealTradeProducts{
    private String exchange;
    private String contractCode;
    private int month;
    private int year;

    public Futures(String productID, double price, int quantity, String exchange, String contractCode, int month, int year, List<Product> futureList) {
        super(productID, price, quantity);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
        this.futureList = futureList;
    }

    public List<Product> getFutureList() {
        return futureList;
    }

    private List<Product> futureList = new ArrayList<>();


    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        List<Product> products = futureList.stream().filter(f -> f.getProductID() == product.getProductID()).collect(Collectors.toList());
        if (products.isEmpty()){
            futureList.add(product);
        }else {
            throw new ProductAlreadyRegisteredException("Future is ID already exists");
        }
    }

    @Override
    public void trade(Product product, int quantity) throws ProductNotRegisteredException {
        Optional<Product> futures = futureList.stream().filter(p -> product.getProductID() == p.getProductID()).findFirst();
        if(futures.isEmpty()){
            throw new ProductNotRegisteredException("This future has not been registered for tracking");
        }else{
            futures.stream().map(Product:: getQuantity );
        }
    }

    @Override
    public int totalTradeQuantityForDay() {
        int totalQuantity = futureList.stream().map(Product::getQuantity).reduce(0,(a,b) -> a+b);
        return totalQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = getPrice() * totalTradeQuantityForDay();
        return totalValue;
    }
}
