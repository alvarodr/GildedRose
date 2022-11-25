package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class Backstage extends ItemFactory {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) increaseQuality();
        if (this.sellIn < 11 && this.quality < 50) increaseQuality();
        if (this.sellIn < 6 && this.quality < 50) increaseQuality();
        decreaseExpiredCounterDay();
        if (this.isExpiredProduct()) this.setQuality(0);
    }
}
