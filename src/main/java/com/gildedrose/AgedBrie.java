package com.gildedrose;

public class AgedBrie extends ItemClass {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality ++;
        }

    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
        if ( sellIn <0 && quality < 50) {
           quality ++;
        }

    }
}
