package gildedrose.factory;

import gildedrose.Item;
import gildedrose.types.TypeProduct;

import java.lang.reflect.InvocationTargetException;

public abstract class ItemFactory extends Item {

    public static final int MAX_QUALITY = 50;

    private static final int ONE_UNIT = 1;

    public ItemFactory(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();

    public static ItemFactory getFactory(Item item) {
        TypeProduct type = TypeProduct.fromNameProduct(item.name);
        try {
            return type.getClazz().getDeclaredConstructor(String.class, int.class, int.class)
                .newInstance(item.name, item.sellIn, item.quality);
        } catch (InstantiationException | RuntimeException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void decreaseExpiredCounterDay() {
        this.setSellIn(this.sellIn - ONE_UNIT);
    }

    public void increaseQuality() {
        this.setQuality(this.quality + ONE_UNIT);
    }

    public void decreaseQuality() {
        this.setQuality(this.quality - ONE_UNIT);
    }

    public Boolean isExpiredProduct() {
        return this.sellIn < 0;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public Boolean hasQuality() {
        return this.quality > 0;
    }
}
