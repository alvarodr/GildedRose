package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class ElixirMongoose extends ItemFactory {
    public ElixirMongoose(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

    }
}
