package com.gildedtros.improver;

import com.gildedtros.Item;

import static com.gildedtros.Constants.MAXIMUM_QUALITY;

public class GoodWineQualityImprover implements QualityImprover {

    private final Item item;

    public GoodWineQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public Item updateQuality() {
        Item.Builder builder = new Item.Builder(item);

        if (builder.getQuality() < MAXIMUM_QUALITY) {
            builder.increaseQuality();
        }
        builder.decreaseSellIn();
        if (builder.getSellIn() < 0 && builder.getQuality() < MAXIMUM_QUALITY) {
            builder.increaseQuality();
        }

        return builder.build();
    }
}
