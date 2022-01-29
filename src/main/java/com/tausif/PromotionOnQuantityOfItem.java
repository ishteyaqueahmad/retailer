package com.tausif;

import java.util.List;

public class PromotionOnQuantityOfItem implements Promotion{


    private String promotionalItemCode ;

    public PromotionOnQuantityOfItem(String promotionalItemCode) {
        this.promotionalItemCode = promotionalItemCode;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public double applyPromotion(List<Item> items, double totalPurchaseAmount) {
        long itemCount = items.stream()
                .filter(item -> item.getProductCode().equals(promotionalItemCode))
                .count();
        if (itemCount >= 2)
            totalPurchaseAmount -= itemCount * 5;
        return totalPurchaseAmount;
    }
}
