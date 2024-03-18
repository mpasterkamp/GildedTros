package com.gildedtros;

import static com.gildedtros.Constants.*;

class GildedTros {

    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.getName()) {
                case GOOD_WINE -> goodWine(item);
                case BACKSTAGE_PASSES_FOR_HAXX, BACKSTAGE_PASSES_FOR_RE_FACTOR -> backstagePass(item);
                case B_DAWG_KEYCHAIN -> keychain(item);
                default -> other(item);
            }
        }
    }

    private void goodWine(Item item) {
        if (item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
        item.decreaseSellIn();
        if (item.getSellIn() < 0 && item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
    }

    private void backstagePass(Item item) {
        if (item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
        if (item.getSellIn() < RARE_BACKSTAGE_PASS_SELL_IN_LIMIT && item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
        if (item.getSellIn() < EXTRA_RARE_BACKSTAGE_PASS_SELL_IN_LIMIT && item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
        item.decreaseSellIn();
        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
    }

    private void keychain(Item item) {

    }

    private void other(Item item) {
        if (item.getQuality() > 0) {
            item.decreaseQuality();
        }
        item.decreaseSellIn();
        if (item.getSellIn() < 0) {
            if (item.getQuality() > 0) {
                item.decreaseQuality();
            }
        }
    }
}