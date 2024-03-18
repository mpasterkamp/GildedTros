package com.gildedtros;

class GildedTros {
    public static final String GOOD_WINE = "Good Wine";
    public static final String BACKSTAGE_PASSES_FOR_RE_FACTOR = "Backstage passes for Re:Factor";
    public static final String BACKSTAGE_PASSES_FOR_HAXX = "Backstage passes for HAXX";
    public static final String B_DAWG_KEYCHAIN = "B-DAWG Keychain";
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(GOOD_WINE)
                    && !items[i].name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR)
                    && !items[i].name.equals(BACKSTAGE_PASSES_FOR_HAXX))
            {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR) || items[i].name.equals(BACKSTAGE_PASSES_FOR_HAXX) ) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(GOOD_WINE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES_FOR_RE_FACTOR) && !items[i].name.equals(BACKSTAGE_PASSES_FOR_HAXX)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(B_DAWG_KEYCHAIN)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}