package com.gildedtros;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";

    static Stream<Arguments> goodWineArguments() {
        return Stream.of(
                Arguments.of(Item.of(GOOD_WINE, 1, 50), Item.of(GOOD_WINE, 0, 50)),
                Arguments.of(Item.of(GOOD_WINE, 1, 49), Item.of(GOOD_WINE, 0, 50)),
                Arguments.of(Item.of(GOOD_WINE, 0, 49), Item.of(GOOD_WINE, -1, 50)),
                Arguments.of(Item.of(GOOD_WINE, 0, 48), Item.of(GOOD_WINE, -1, 50))
        );
    }

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedTros app = new GildedTros(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @ParameterizedTest
    @MethodSource("goodWineArguments")
    void goodWine_differentArguments_returnExpectedResult(Item input, Item expectedItem) {
        // given
        Item[] inputs = new Item[]{input};
        Item[] expected = new Item[]{expectedItem};
        GildedTros gildedTros = new GildedTros(inputs);

        // when
        gildedTros.updateQuality();

        // then
        assertThat(gildedTros.items).isEqualTo(expected);
    }
}
