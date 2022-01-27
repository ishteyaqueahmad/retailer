package com.tausif;

import java.util.List;

public class PromotionOnTotalPurchaseAmount implements Promotion{


    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public double applyPromotion(List<Item> items, double totalPurchaseAmount) {
        double discount = 0;
        if (totalPurchaseAmount > 9000d)
            discount = totalPurchaseAmount*(10/100.0f);
        return totalPurchaseAmount - discount;
    }
}
