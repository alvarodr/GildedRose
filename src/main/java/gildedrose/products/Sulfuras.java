package gildedrose.products;

import gildedrose.factory.ItemFactory;

public class Sulfuras extends ItemFactory {

    private static int INMUTABLE_QUALITY = 80;
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.setQuality(INMUTABLE_QUALITY);
    }
}
