package learning;

import junit.framework.TestCase;

import java.time.LocalDate;

/**
 * DiscountCheckerTest
 */
public class DiscountCheckerTest extends TestCase{

    public void testAbsoluteDiscount() {
        // Given
        double originalPrice = 5000;
        Discount absoluteDiscount = new Discount(100);

        // When
        double finalPrice = DiscountChecker.applyAbsoluteDiscount(originalPrice, absoluteDiscount);
    
        // Then
        assertEquals(4900.00, finalPrice);
    }

    public void testPercentageDiscount() {
        // Given
        double originalPrice = 6000;
        Discount percentageDiscount = new Discount(20);

        // When
        double finalPrice = DiscountChecker.applyPercentageDiscount(originalPrice, percentageDiscount);
    
        // Then
        assertEquals(4800.00, finalPrice);
    }

    public void testValidityPeriod() {
        // Given
        double originalPrice = 3000;
        Discount absoluteDiscount = new Discount(250);
        
        // HAPPY scenario
        LocalDate orderDate = LocalDate.of(2019, 8, 11);

        // UNHAPPY scenario
        // LocalDate orderDate = LocalDate.of(2019, 10, 31);

        // When
        double finalPrice = DiscountChecker.applyValidityPeriod(originalPrice, absoluteDiscount, orderDate);
    
        // Then
        assertEquals(2750.00, finalPrice);
    }

    public void testProductSpecificDiscount() {
        // Given
        double originalPrice = 5000;
        Discount percentageDiscount = new Discount(15);

        // HAPPY scenario
        String productType = "Home Appliance";

        // UNHAPPY scenario
        // String productType = "Mobile Gadget";

        // When
        double finalPrice = DiscountChecker.applyProductSpecificDiscount(originalPrice, percentageDiscount, productType);
    
        // Then
        assertEquals(4250.00, finalPrice);
    }

    public void testShoppingCart() {
        // Given
        Discount percentageDiscount = new Discount(10);
        ShoppingCart[] shoppingCart = new ShoppingCart[5];

        shoppingCart[0]  = new ShoppingCart(1000, "Mobile Gadget");
        shoppingCart[1]  = new ShoppingCart(6000, "Home Appliance");
        shoppingCart[2]  = new ShoppingCart(2550, "Gaming Console");
        shoppingCart[3]  = new ShoppingCart(9990, "Furniture");
        shoppingCart[4]  = new ShoppingCart(4550, "Computer");

        // When
        double finalPrice = DiscountChecker.applyShoppingCart(percentageDiscount, shoppingCart);
    
        // Then
        assertEquals(22780.00, finalPrice);
    }
}