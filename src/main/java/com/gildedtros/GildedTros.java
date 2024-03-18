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
        Arrays.stream(items)
                .forEach(item -> qualityImproverFactory.createQualityImprover(item.getName())
                        .apply(item)
                        .updateQuality());
    }
}