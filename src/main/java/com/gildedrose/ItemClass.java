package com.gildedrose;

public abstract class ItemClass extends Item {
    public ItemClass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public abstract void updateQuality();
    public  void updateSellIn(){
        sellIn--;
    };
}
