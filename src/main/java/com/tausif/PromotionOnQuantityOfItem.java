package com.tausif;

import java.util.List;

public class PromotionOnQuantityOfItem implements Promotion{


    private String promotionalItemCode ;
    private int noOfItem;
    private int discountAmount;

    public PromotionOnQuantityOfItem(String promotionalItemCode, int noOfItem, int discountAmount) {
        this.promotionalItemCode = promotionalItemCode;
        this.noOfItem = noOfItem;
        this.discountAmount = discountAmount;
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
        noOfItem = 2;
        if (itemCount >= noOfItem) {
            discountAmount = 5;
            totalPurchaseAmount -= itemCount * discountAmount;
        }
        return totalPurchaseAmount;
    }
}
