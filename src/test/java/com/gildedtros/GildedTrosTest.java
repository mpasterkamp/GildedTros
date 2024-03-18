package com.gildedtros;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedTrosTest {

    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    private static final String OTHER_ITEMS = "Other";

    static Stream<Arguments> goodWineArguments() {
        return Stream.of(
                Arguments.of(new Item(GOOD_WINE, 1, 50), new Item(GOOD_WINE, 0, 50)),
                Arguments.of(new Item(GOOD_WINE, 1, 49), new Item(GOOD_WINE, 0, 50)),
                Arguments.of(new Item(GOOD_WINE, 0, 49), new Item(GOOD_WINE, -1, 50)),
                Arguments.of(new Item(GOOD_WINE, 0, 48), new Item(GOOD_WINE, -1, 50))
        );
    }

    static Stream<Arguments> passArguments() {
        return Stream.of(
                // re:factor
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 1, 50), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 0, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 0, 50), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, -1, 0)),

                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 1, 49), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 0, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 11, 49), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 10, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 10, 49), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 9, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 11, 48), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 10, 49)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 10, 48), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 9, 50)),

                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 6, 48), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 5, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 5, 48), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 4, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 6, 47), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 5, 49)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 5, 48), new Item(BACKSTAGE_PASSES_FOR_RE_FACTOR, 4, 50)),

                // HAXX
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 1, 50), new Item(BACKSTAGE_PASSES_FOR_HAXX, 0, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 0, 50), new Item(BACKSTAGE_PASSES_FOR_HAXX, -1, 0)),

                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 1, 49), new Item(BACKSTAGE_PASSES_FOR_HAXX, 0, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 11, 49), new Item(BACKSTAGE_PASSES_FOR_HAXX, 10, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 10, 49), new Item(BACKSTAGE_PASSES_FOR_HAXX, 9, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 11, 48), new Item(BACKSTAGE_PASSES_FOR_HAXX, 10, 49)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 10, 48), new Item(BACKSTAGE_PASSES_FOR_HAXX, 9, 50)),

                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 6, 48), new Item(BACKSTAGE_PASSES_FOR_HAXX, 5, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 5, 48), new Item(BACKSTAGE_PASSES_FOR_HAXX, 4, 50)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 6, 47), new Item(BACKSTAGE_PASSES_FOR_HAXX, 5, 49)),
                Arguments.of(new Item(BACKSTAGE_PASSES_FOR_HAXX, 5, 48), new Item(BACKSTAGE_PASSES_FOR_HAXX, 4, 50))
        );
    }

    static Stream<Arguments> keyChainArguments() {
        return Stream.of(
                Arguments.of(new Item(B_DAWG_KEYCHAIN, 1, 50), new Item(B_DAWG_KEYCHAIN, 1, 50)),
                Arguments.of(new Item(B_DAWG_KEYCHAIN, 0, 50), new Item(B_DAWG_KEYCHAIN, 0, 50)),
                Arguments.of(new Item(B_DAWG_KEYCHAIN, 1, 49), new Item(B_DAWG_KEYCHAIN, 1, 49)),
                Arguments.of(new Item(B_DAWG_KEYCHAIN, 0, 49), new Item(B_DAWG_KEYCHAIN, 0, 49))
        );
    }

    static Stream<Arguments> otherArguments() {
        return Stream.of(
                Arguments.of(new Item(OTHER_ITEMS, 1, 0), new Item(OTHER_ITEMS, 0, 0)),
                Arguments.of(new Item(OTHER_ITEMS, 1, 1), new Item(OTHER_ITEMS, 0, 0)),
                Arguments.of(new Item(OTHER_ITEMS, 0, 1), new Item(OTHER_ITEMS, -1, 0)),
                Arguments.of(new Item(OTHER_ITEMS, 0, 2), new Item(OTHER_ITEMS, -1, 0))
        );
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

    @ParameterizedTest
    @MethodSource("passArguments")
    void backstagePasses_differentArguments_returnExpectedResult(Item input, Item expectedItem) {
        // given
        Item[] inputs = new Item[]{input};
        Item[] expected = new Item[]{expectedItem};
        GildedTros gildedTros = new GildedTros(inputs);

        // when
        gildedTros.updateQuality();

        // then
        assertThat(gildedTros.items).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("keyChainArguments")
    void keychain_differentArguments_returnExpectedResult(Item input, Item expectedItem) {
        // given
        Item[] inputs = new Item[]{input};
        Item[] expected = new Item[]{expectedItem};
        GildedTros gildedTros = new GildedTros(inputs);

        // when
        gildedTros.updateQuality();

        // then
        assertThat(gildedTros.items).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("otherArguments")
    void otherItems_differentArguments_returnExpectedResult(Item input, Item expectedItem) {
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
