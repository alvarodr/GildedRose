package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class Dexterity extends ItemFactory {
    public Dexterity(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.hasQuality()) {
            decreaseQuality();
        }
        decreaseExpiredCounterDay();
        if (this.isExpiredProduct() && this.hasQuality()) {
            decreaseQuality();
        }
    }
}
