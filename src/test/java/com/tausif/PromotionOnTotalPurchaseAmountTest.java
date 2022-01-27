package com.tausif;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PromotionOnTotalPurchaseAmountTest {

    @Nested
    @DisplayName("Testing ApplyPromotion")
     class applyPromotion {
        @Test
        @DisplayName("test ApplyPromotion below 9000")
        void testApplyPromotion() {
            PromotionOnTotalPurchaseAmount promotionOnTotalPurchaseAmount = new PromotionOnTotalPurchaseAmount();
            assertEquals(8000, promotionOnTotalPurchaseAmount.applyPromotion(new ArrayList<>(), 8000));
        }

        @Test
        @DisplayName("test ApplyPromotion equal 9000")
        void testApplyPromotion2() {
            PromotionOnTotalPurchaseAmount promotionOnTotalPurchaseAmount = new PromotionOnTotalPurchaseAmount();
            assertEquals(9000, promotionOnTotalPurchaseAmount.applyPromotion(new ArrayList<>(), 9000));
        }

        @Test
        @DisplayName("test ApplyPromotion greater 9000")
        void testApplyPromotion3() {
            PromotionOnTotalPurchaseAmount promotionOnTotalPurchaseAmount = new PromotionOnTotalPurchaseAmount();
            assertEquals(8100.899986587465, promotionOnTotalPurchaseAmount.applyPromotion(new ArrayList<>(), 9001));
        }
    }

    @Test
    void testisActive() {
        assertTrue((new PromotionOnTotalPurchaseAmount()).isActive());
    }
}

