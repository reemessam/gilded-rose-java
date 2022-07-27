package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void zeroQualityTest() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 5, 0),
                new Item("Elixir of the Mongoose", 15, 0), //

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));

    }
    @Test
    void maxQualityTest() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),


        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(50, x.quality));

    }

    @Test
    void negativeSellInAgedTest() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(42, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-2, x.sellIn));

    }
    @Test
    void positiveSellInAgedTest() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(41, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.sellIn));
    }
    @Test
    void negativeSellInTest() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(38, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-2, x.sellIn));
    }
    @Test
    void sulfurasTest() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(40, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }
    @Test
    void backstageLessThan11Test() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(42, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(9, x.sellIn));
    }

    @Test
    void backstageLessThan6Test() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(43, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(3, x.sellIn));
    }


    @Test
    void backstageNegativeSellInTest() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }

}
