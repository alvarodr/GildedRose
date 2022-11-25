package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class AgedBrie extends ItemFactory {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.increaseQuality();
        }
        this.decreaseExpiredCounterDay();
        if (this.isExpiredProduct() && this.quality < 50) {
            this.increaseQuality();
        }
    }
}
