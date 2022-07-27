package com.gildedrose;

public class Conjured extends ItemClass {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality == 1) {
            quality = 0;
        } else if (quality - 1 > 0) {
            quality -= 2;
        }
    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
        if (sellIn < 0) {
            updateQuality();
        }

    }
}
