package com.gildedtros;

class GildedTros {
    private static final String GOOD_WINE = "Good Wine";
    private static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    private static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    private static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case GOOD_WINE -> goodWine(item);
                case BACKSTAGE_PASSES_FOR_HAXX, BACKSTAGE_PASSES_FOR_RE_FACTOR -> backstagePass(item);
                case B_DAWG_KEYCHAIN -> keychain(item);
                default -> other(item);
            }
        }
    }

    private void goodWine(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void backstagePass(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void keychain(Item item) {

    }

    private void other(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }
}