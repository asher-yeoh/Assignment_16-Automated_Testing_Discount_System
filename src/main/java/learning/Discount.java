package learning;

import java.time.LocalDate;

/**
 * DiscountSystem
 */
public class Discount {

    public double discountValue;
    LocalDate discountExpiryDate;
    String[] applicableProducts = new String[3];

    Discount(double discountValue) {

        this.discountValue = discountValue;
        this.discountExpiryDate = LocalDate.of(2019, 8, 31);
        this.applicableProducts[0] = "Home Appliance";
        this.applicableProducts[1] = "Gaming Console";
        this.applicableProducts[2] = "Computer";
    }
}