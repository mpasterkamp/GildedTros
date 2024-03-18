package com.gildedtros.improver;

import com.gildedtros.Item;

import static com.gildedtros.Constants.*;

public class BackstagePassQualityImprover implements QualityImprover {

    private final Item item;

    public BackstagePassQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
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
}
