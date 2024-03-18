package com.gildedtros.improver;

import com.gildedtros.Item;

import static com.gildedtros.Constants.*;

public class BackstagePassQualityImprover implements QualityImprover {

    private final Item item;

    public BackstagePassQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public Item updateQuality() {
        Item.Builder builder = new Item.Builder(item);

        if (builder.getQuality() < MAXIMUM_QUALITY) {
            builder.increaseQuality();
        }
        if (builder.getSellIn() < RARE_BACKSTAGE_PASS_SELL_IN_LIMIT && builder.getQuality() < MAXIMUM_QUALITY) {
            builder.increaseQuality();
        }
        if (builder.getSellIn() < EXTRA_RARE_BACKSTAGE_PASS_SELL_IN_LIMIT && builder.getQuality() < MAXIMUM_QUALITY) {
            builder.increaseQuality();
        }
        builder.decreaseSellIn();
        if (builder.getSellIn() < 0) {
            builder.quality(0);
        }

        return builder.build();
    }
}
