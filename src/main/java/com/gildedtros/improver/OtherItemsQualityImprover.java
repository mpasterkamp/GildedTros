package com.gildedtros.improver;

import com.gildedtros.Item;

public class OtherItemsQualityImprover implements QualityImprover {

    private final Item item;

    public OtherItemsQualityImprover(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
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
