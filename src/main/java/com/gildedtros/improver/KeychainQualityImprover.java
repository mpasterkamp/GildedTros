package com.gildedtros.improver;

import com.gildedtros.Item;

public class KeychainQualityImprover implements QualityImprover {

    private final Item item;

    public KeychainQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public Item updateQuality() {
        return item;
    }
}
