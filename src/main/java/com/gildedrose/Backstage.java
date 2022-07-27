package com.gildedrose;

public class Backstage extends ItemClass {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            quality++;
            if (quality < 50) {
                if (sellIn < 11) {
                    quality++;
                }
                if (sellIn < 6) {
                    quality++;
                }
            }

        }


    }

    @Override
    public void updateSellIn() {
        super.updateSellIn();
        if (sellIn < 0) {
            quality = 0;
        }

    }
}
