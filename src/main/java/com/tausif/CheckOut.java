package com.tausif;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private PromotionalRules promotionalRules;

    public CheckOut(PromotionalRules promotionalRules) {
        this.promotionalRules = promotionalRules;
    }

    private List<Item> items = new ArrayList<>();

    public List<Item> addToBasket(Item item){
        items.add(item);
        return items;
    }

    public List<Item> getItems() {
        return items;
    }

    public double total(){
        double totalPurchase = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
        if (promotionalRules.getPromotions().isEmpty())
            return totalPurchase;

        return applyPromotion(totalPurchase);
    }

    private double applyPromotion(double totalPurchase){
        for (Promotion promotion: this.promotionalRules.getPromotions()) {
            if (promotion.isActive()){
                totalPurchase = promotion.applyPromotion(items,totalPurchase);
            }
        }
        return round(totalPurchase,2);
    }

    public  double roundToHalf(double d) {
        return Math.round(d * 2) / 2.0;
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
