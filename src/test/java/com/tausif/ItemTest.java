package com.tausif;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

class ItemTest {

    Item actualItem;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        actualItem =new Item("1011-005", "Tote Bag", 8950);
        this.testInfo=testInfo;
        this.testReporter= testReporter;
        testReporter.publishEntry("Running "+testInfo.getDisplayName());
    }


    @Test
    @Tag("secondtest")
    @DisplayName("Testing constructor")
    void testItemConstructor() {
        assertEquals("Tote Bag", actualItem.getName()," should return correct item name");
        assertEquals(8950, actualItem.getPrice()," should return correct item price");
        assertEquals("1011-005", actualItem.getProductCode()," should return correct product code");
    }

    @Test
    @Tag("secondtest")
    @DisplayName("Testing Item setter and getter")
    void testItemSetGetItem() {
        actualItem.setName("Keychain");
        actualItem.setPrice(990);
        actualItem.setProductCode("2010-001");

        assertAll(
                ()-> assertEquals("Keychain",actualItem.getName(),()->" should return correct item name in "+testInfo.getDisplayName()),
                ()->assertEquals(990,actualItem.getPrice(),()->" should return correct item price in "+testInfo.getDisplayName()),
                ()->assertEquals("2010-001",actualItem.getProductCode(),()->" should return correct product code in "+testInfo.getDisplayName())
        );

    }
}

