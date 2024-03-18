package com.gildedtros;

public record Item(String name, int sellIn, int quality) {

    public static final class Builder {

        private String name;
        private int sellIn;
        private int quality;

        public Builder() {
        }

        public Builder(Item item) {
            this.name = item.name();
            this.sellIn = item.sellIn();
            this.quality = item.quality();
        }

        public String getName() {
            return name;
        }

        public int getSellIn() {
            return sellIn;
        }

        public int getQuality() {
            return quality;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sellIn(int sellIn) {
            this.sellIn = sellIn;
            return this;
        }

        public Builder decreaseSellIn() {
            this.sellIn--;
            return this;
        }

        public Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        public Builder increaseQuality() {
            this.quality++;
            return this;
        }

        public Builder decreaseQuality() {
            this.quality--;
            return this;
        }

        public Item build() {
            return new Item(name, sellIn, quality);
        }
    }
}
