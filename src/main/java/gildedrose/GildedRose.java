package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = decreaseQuality(i);
                    }
                }
            } else { // para aged bri y backstage
                if (items[i].quality < 50) {
                    items[i].quality = increaseQuality(i);

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = increaseQuality(i);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = increaseQuality(i);
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = decreaseExpiredCounterDay(i);
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = decreaseQuality(i);
                            }
                        }
                    } else {
                        items[i].quality = 0; // para backstage && withoutexpirationcounter
                    }
                } else { // para aged brie
                    if (items[i].quality < 50) {
                        items[i].quality = increaseQuality(i);
                    }
                }
            }
        }
    }

    private int decreaseExpiredCounterDay(int i) {
        return items[i].sellIn - 1;
    }

    private int increaseQuality(int i) {
        return items[i].quality + 1;
    }

    private int decreaseQuality(int i) {
        return items[i].quality - 1;
    }
}