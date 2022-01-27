package com.tausif;

import java.util.List;

public class PromotionOnQuantityOfItem implements Promotion{

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public double applyPromotion(List<Item> items, double totalPurchaseAmount) {
        long itemCount = items.stream()
                .filter(item -> item.getProductCode().equals("3000-002"))
                .count();
        if (itemCount >= 2)
            totalPurchaseAmount -= itemCount * 5;
        return totalPurchaseAmount;
    }
}
