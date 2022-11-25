package gildedrose;

import gildedrose.factory.ItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemFactory itemFactory = ItemFactory.getFactory(items[i]);
            itemFactory.updateQuality();
            items[i].quality = itemFactory.quality;
            items[i].sellIn = itemFactory.sellIn;
        }
    }
}