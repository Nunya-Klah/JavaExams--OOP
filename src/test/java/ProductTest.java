import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductTest {

    @Test
    void getPriceForStocks() {
        Stocks stocks = mock(Stocks.class);
        when(stocks.getPrice()).thenReturn(10.0);
        assertTrue(stocks.getPrice() != 0);
    }
}