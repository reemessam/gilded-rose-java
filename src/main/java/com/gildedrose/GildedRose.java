package com.gildedrose;

class GildedRose {
    ItemClass[] items;

    public GildedRose(ItemClass[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].updateQuality();
            items[i].updateSellIn();
        }
    }
}