package com.tausif;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class PromotionOnQuantityOfItemTest {

    PromotionOnQuantityOfItem promotionOnQuantityOfItem ;
    TestInfo testInfo;
    TestReporter testReporter;
    ArrayList<Item> itemList ;
    Item totebag;
    Item belt;
    Item keychain;


    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        promotionOnQuantityOfItem = new PromotionOnQuantityOfItem("3000-002");
        this.testInfo=testInfo;
        this.testReporter= testReporter;
        itemList = new ArrayList<>();
        totebag= new Item("1011-005", "Tote Bag", 8950);
        belt= new Item("2010-001", "Belt", 990);
        keychain= new Item("3000-002", "Keychain", 95);
        testReporter.publishEntry("Running "+testInfo.getDisplayName());
    }

    @Nested
    @DisplayName("Testing ApplyPromotion")
     class applyPromotion {
        @Test
        @DisplayName("test ApplyPromotion Without Keychain")
        void testApplyPromotion() {
            PromotionOnQuantityOfItem promotionOnQuantityOfItem = new PromotionOnQuantityOfItem("3000-002");
            itemList.add(totebag);
            assertEquals(8950, promotionOnQuantityOfItem.applyPromotion(itemList, 8950));
        }

        @Test
        @DisplayName("test ApplyPromotion OneKey Chain")
        void testApplyPromotion1() {
            PromotionOnQuantityOfItem promotionOnQuantityOfItem = new PromotionOnQuantityOfItem("3000-002");

            List<Item> itemList = new ArrayList<>();
            itemList.add(keychain);
            itemList.add(totebag);
            assertEquals(9045, promotionOnQuantityOfItem.applyPromotion(itemList, 9045));
        }

        @Test
        @DisplayName("test ApplyPromotion two Chain")
        void testApplyPromotion2() {
            PromotionOnQuantityOfItem promotionOnQuantityOfItem = new PromotionOnQuantityOfItem("3000-002");

            ArrayList<Item> itemList = new ArrayList<>();
            itemList.add(keychain);
            itemList.add(keychain);
            itemList.add(belt);
            assertEquals(1170, promotionOnQuantityOfItem.applyPromotion(itemList, 1180));
        }

        @Test
        @DisplayName("test ApplyPromotion more than two Chain")
        void testApplyPromotion3() {
            PromotionOnQuantityOfItem promotionOnQuantityOfItem = new PromotionOnQuantityOfItem("3000-002");

            ArrayList<Item> itemList = new ArrayList<>();
            itemList.add(keychain);
            itemList.add(keychain);
            itemList.add(keychain);
            assertEquals(270, promotionOnQuantityOfItem.applyPromotion(itemList, 285));
        }
    }

    @Test
    void testIsActive() {
        assertTrue((new PromotionOnQuantityOfItem("3000-002")).isActive());
    }
}

