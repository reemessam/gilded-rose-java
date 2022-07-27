package com.gildedrose;

public class GeneralItem extends ItemClass {
    public GeneralItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality >0) {
            quality--;
        }


}

    @Override
    public void updateSellIn() {
        super.updateSellIn();
        if (sellIn < 0 && quality>0) {
            quality--;
        }

    }
}
