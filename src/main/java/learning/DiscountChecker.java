package learning;

import java.time.LocalDate;

/**
 * DiscountChecker
 */
public class DiscountChecker {

    public static double applyAbsoluteDiscount(double originalPrice, Discount absoluteDiscount) {

        double finalPrice = originalPrice - absoluteDiscount.discountValue;
        return finalPrice;
    }

    public static double applyPercentageDiscount(double originalPrice, Discount percentageDiscount) {
        
        double finalPrice = originalPrice - (originalPrice * (percentageDiscount.discountValue/100));
        return finalPrice;
    }

    public static double applyValidityPeriod(double originalPrice, Discount absoluteDiscount, LocalDate orderDate) {
        
        if (orderDate.isBefore(absoluteDiscount.discountExpiryDate) || orderDate.equals(absoluteDiscount.discountExpiryDate)) {

            double finalPrice = originalPrice - absoluteDiscount.discountValue;
            return finalPrice;

        } else {

            double finalPrice = originalPrice;
            return finalPrice;
        } 
    }

    public static double applyProductSpecificDiscount(double originalPrice, Discount percentageDiscount, String productType) {
        
        boolean validityFlag = false; 

        for (String p: percentageDiscount.applicableProducts) {  
            if (productType.equals(p)) {
                validityFlag = true;
            }
            
        }

        if (validityFlag) {

            double finalPrice = originalPrice - (originalPrice * (percentageDiscount.discountValue/100));
            return finalPrice;

        } else {

            double finalPrice = originalPrice;
            return finalPrice;
        } 
    }

    public static double applyShoppingCart(Discount percentageDiscount, ShoppingCart[] shoppingCart) {
 
        double totalPrice = 0;
        
        
        for (ShoppingCart c: shoppingCart) {
            
            double finalPrice = 0;
            boolean validityFlag = false; 

            for (String p: percentageDiscount.applicableProducts) {
                if (c.productType.equals(p)) {
                    validityFlag = true;

                }
            }

            if (validityFlag) {

                finalPrice = c.originalPrice - (c.originalPrice * (percentageDiscount.discountValue/100));
    
            } else {
    
                finalPrice = c.originalPrice;
            }

            totalPrice += finalPrice;
        }

        return totalPrice;
    }
}