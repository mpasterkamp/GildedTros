package com.gildedtros.improver;

import com.gildedtros.Item;

public class OtherItemsQualityImprover implements QualityImprover {

    private final Item item;

    public OtherItemsQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public Item updateQuality() {
        Item.Builder builder = new Item.Builder(item);

        if (builder.getQuality() > 0) {
            builder.decreaseQuality();
        }
        builder.decreaseSellIn();
        if (builder.getSellIn() < 0) {
            if (builder.getQuality() > 0) {
                builder.decreaseQuality();
            }
        }

        return builder.build();
    }
}
