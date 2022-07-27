package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void zeroQualityTest() {
        ItemClass[] items = new ItemClass[] {
                new GeneralItem("Elixir of the Mongoose", 5, 0),
                new GeneralItem("Elixir of the Mongoose", 15, 0), //

        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));

    }
    @Test
    void maxQualityTest() {
        ItemClass[] items = new ItemClass[] {
                new AgedBrie("Aged Brie", 2, 50),
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 50),


        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(50, x.quality));

    }

    @Test
    void negativeSellInAgedTest() {
        ItemClass[] items = new ItemClass[] {
                new AgedBrie("Aged Brie", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(42, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-2, x.sellIn));

    }
    @Test
    void positiveSellInAgedTest() {
        ItemClass[] items = new ItemClass[] {
                new AgedBrie("Aged Brie", 1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(41, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.sellIn));
    }
    @Test
    void negativeSellInTest() {
        ItemClass[] items = new ItemClass[] {
                new GeneralItem("Elixir of the Mongoose", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(38, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-2, x.sellIn));
    }
    @Test
    void sulfurasTest() {
        ItemClass[] items = new ItemClass[] {
                new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(40, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }
    @Test
    void backstageLessThan11Test() {
        ItemClass[] items = new ItemClass[] {
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(42, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(9, x.sellIn));
    }

    @Test
    void backstageLessThan6Test() {
        ItemClass[] items = new ItemClass[] {
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 4, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(43, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(3, x.sellIn));
    }


    @Test
    void backstageNegativeSellInTest() {
        ItemClass[] items = new ItemClass[] {
                new Backstage("Backstage passes to a TAFKAL80ETC concert", 0, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }


    @Test
    void ConjuredTest() {
        ItemClass[] items = new ItemClass[] {
                new Conjured("Conjured", 0, 40),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(36, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }
    @Test
    void ConjuredUpdateQualityBy1Test() {
        ItemClass[] items = new ItemClass[] {
                new Conjured("Conjured", 0, 1),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }

    @Test
    void ConjuredUpdateQualityBy3Test() {
        ItemClass[] items = new ItemClass[] {
                new Conjured("Conjured", 0, 3),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(0, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(-1, x.sellIn));
    }
    @Test
    void ConjuredPositiveSellInTest() {
        ItemClass[] items = new ItemClass[] {
                new Conjured("Conjured", 8, 5),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Arrays.stream(app.items).forEach( x ->assertEquals(3, x.quality));
        Arrays.stream(app.items).forEach( x ->assertEquals(7, x.sellIn));
    }

}
