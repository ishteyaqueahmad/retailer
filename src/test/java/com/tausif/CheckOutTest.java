package com.tausif;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckOutTest {

    TestInfo testInfo;
    TestReporter testReporter;
    Item totebag;
    Item belt;
    Item keychain;


    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {

        this.testInfo = testInfo;
        this.testReporter = testReporter;
        totebag = new Item("1011-005", "Tote Bag", 8950);
        belt = new Item("2010-001", "Belt", 990);
        keychain = new Item("3000-002", "Keychain", 95);

    }

    @Test
    void testConstructor() {
        PromotionalRules promotionalRules = new PromotionalRules();
        assertTrue((new CheckOut(promotionalRules)).getItems().isEmpty());
        List<Promotion> expectedPromotions = promotionalRules.promotions;
        List<Promotion> promotions = promotionalRules.getPromotions();
        assertSame(expectedPromotions, promotions);
        assertTrue(promotions.isEmpty());
    }

    @Nested
    @DisplayName("Testing add to basket")
     class AddToBasket {
        @Test
        @DisplayName("Testing Add to Basket with one item")
        void testAddToBasket1() {
            CheckOut checkOut = new CheckOut(new PromotionalRules());
            assertEquals(1, checkOut.addToBasket(totebag).size());
        }

        @Test
        @DisplayName("Testing Add to Basket with more than one item")
        void testAddToBasket2() {
            CheckOut checkOut = new CheckOut(new PromotionalRules());
            checkOut.addToBasket(totebag);
            checkOut.addToBasket(keychain);
            checkOut.addToBasket(belt);
            assertEquals(3, checkOut.getItems().size());
        }


    }

    @Nested
    @DisplayName("Testing total")
     class testTotals {

        @Test
        @DisplayName("Testing total without any offer")
        void testTotal1() {
            testReporter.publishEntry("Running " + testInfo.getDisplayName());
            CheckOut checkOut = new CheckOut(new PromotionalRules());
            checkOut.addToBasket(totebag);
            checkOut.addToBasket(keychain);
            checkOut.addToBasket(belt);
            assertEquals(10035, (checkOut.total()));

        }

        @Test
        @DisplayName("Testing total with only PromotionOnQuantityOfItem offer")
        void testTotal2() {
            testReporter.publishEntry("Running " + testInfo.getDisplayName());
            PromotionalRules promotionalRules = new PromotionalRules();

            promotionalRules.addPromotions(new PromotionOnQuantityOfItem("3000-002"));
            CheckOut checkOut = new CheckOut(promotionalRules);
            checkOut.addToBasket(keychain);
            checkOut.addToBasket(belt);
            checkOut.addToBasket(keychain);
            assertEquals(1170, (checkOut.total()));
        }

        @Test
        @DisplayName("Testing total with only PromotionOnTotalPurchaseAmount offer")
        void testTotal3() {
            PromotionalRules promotionalRules = new PromotionalRules();
            promotionalRules.addPromotions(new PromotionOnTotalPurchaseAmount(9000d,10));
            CheckOut checkOut = new CheckOut(promotionalRules);
            checkOut.addToBasket(totebag);
            checkOut.addToBasket(keychain);
            checkOut.addToBasket(belt);
            checkOut.addToBasket(keychain);
            assertEquals(9117, (checkOut.total()));
        }

        @Test
        @DisplayName("Testing total with both PromotionOnTotalPurchaseAmount and PromotionOnQuantityOfItem offer")
        void testTotal4() {
            PromotionalRules promotionalRules = new PromotionalRules();
            promotionalRules.addPromotions(new PromotionOnQuantityOfItem("3000-002"));
            promotionalRules.addPromotions(new PromotionOnTotalPurchaseAmount(9000d, 10));
            CheckOut checkOut = new CheckOut(promotionalRules);
            checkOut.addToBasket(totebag);
            checkOut.addToBasket(keychain);
            checkOut.addToBasket(belt);
            checkOut.addToBasket(keychain);
            assertEquals(9108, (checkOut.total()));

        }
    }

    @Test
    @DisplayName("Testing rounding value upto 1 decimal")
    void testRoundToHalf() {
        assertEquals(59.5, (new CheckOut(new PromotionalRules())).roundToHalf(59.6666));
    }


    }
                  