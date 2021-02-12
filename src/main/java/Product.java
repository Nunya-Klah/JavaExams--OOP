import java.util.ArrayList;
import java.util.List;

public class Product{
    private String productID;
    private double price;
    private int quantity;

    public Product(String productID, double price, int quantity) {
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
