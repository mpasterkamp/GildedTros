package com.gildedtros;

import com.gildedtros.improver.QualityImproverFactory;

import java.util.Arrays;

class GildedTros {

    private final QualityImproverFactory qualityImproverFactory;
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
        qualityImproverFactory = new QualityImproverFactory();
    }

    public void updateQuality() {
        items = Arrays.stream(items)
                .map(item -> qualityImproverFactory.createQualityImprover(item.name())
                        .apply(item)
                        .updateQuality())
                .toArray(Item[]::new);
    }
}