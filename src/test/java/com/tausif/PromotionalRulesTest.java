package com.tausif;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.*;

class PromotionalRulesTest {

    TestInfo testInfo;
    TestReporter testReporter;


    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){

        this.testInfo=testInfo;
        this.testReporter= testReporter;
        testReporter.publishEntry("Running "+testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Testing AddPromotion")
    void testAddPromotions() {
        PromotionalRules promotionalRules = new PromotionalRules();
        List<Promotion> actualAddPromotionsResult = promotionalRules.addPromotions(new PromotionOnQuantityOfItem("3000-002",2,5));
        assertSame(promotionalRules.promotions, actualAddPromotionsResult);
        assertEquals(1, actualAddPromotionsResult.size());
    }

    @Test
    @DisplayName("Testing constructor")
    void testConstructor() {
        PromotionalRules actualPromotionalRules = new PromotionalRules();
        List<Promotion> expectedPromotions = actualPromotionalRules.promotions;
        assertSame(expectedPromotions, actualPromotionalRules.getPromotions());
    }
}

