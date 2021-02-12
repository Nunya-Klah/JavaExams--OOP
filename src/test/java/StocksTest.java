import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StocksTest {

    @Test
    void addNewProduct() throws ProductAlreadyRegisteredException{
        Product stock = mock(Stocks.class);
        Stocks stocks = new Stocks();
    }

    @Test
    void trade() {
    }

    @Test
    void totalTradeQuantityForDay() {
    }

    @Test
    void totalValueOfDaysTradedProducts() {
    }
}