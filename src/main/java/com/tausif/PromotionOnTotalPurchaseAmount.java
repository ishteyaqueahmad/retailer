package com.tausif;

import java.util.List;

public class PromotionOnTotalPurchaseAmount implements Promotion{
    private double thresholdAmount;
    private  int percentageAmount;

    public PromotionOnTotalPurchaseAmount(double thresholdAmount, int percentageAmount) {
        this.thresholdAmount = thresholdAmount;
        this.percentageAmount = percentageAmount;
    }


    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public double applyPromotion(List<Item> items, double totalPurchaseAmount) {
        double discount = 0;

        if (totalPurchaseAmount > thresholdAmount)
        {

            discount = totalPurchaseAmount*(percentageAmount /100.0f);
        }
        return totalPurchaseAmount - discount;
    }
}
