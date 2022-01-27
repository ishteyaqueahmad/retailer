package com.tausif;

import java.util.ArrayList;
import java.util.List;

public class PromotionalRules {
    List<Promotion> promotions = new ArrayList<>();


    public List<Promotion> addPromotions(Promotion promotion) {
        promotions.add(promotion);
        return promotions;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }
}
