package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class Backstage extends ItemFactory {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

    }
}
