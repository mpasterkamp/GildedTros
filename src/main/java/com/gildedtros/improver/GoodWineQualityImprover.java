package com.gildedtros.improver;

import com.gildedtros.Item;

import static com.gildedtros.Constants.MAXIMUM_QUALITY;

public class GoodWineQualityImprover implements QualityImprover {

    private final Item item;

    public GoodWineQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
        item.decreaseSellIn();
        if (item.getSellIn() < 0 && item.getQuality() < MAXIMUM_QUALITY) {
            item.increaseQuality();
        }
    }
}
