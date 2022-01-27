package com.tausif;

import java.util.List;

public interface Promotion {
     boolean isActive();
     double applyPromotion(List<Item> items, double totalPurchaseAmount);
}
