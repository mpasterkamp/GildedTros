package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void of_differentArguments_returnCorrectOrder() {
        // given
        Item constructorItem = new Item("A", 1, 2);

        // when
        Item ofItem = Item.of(constructorItem.name, constructorItem.sellIn, constructorItem.quality);

        // then
        assertEquals(ofItem, constructorItem);
    }
}