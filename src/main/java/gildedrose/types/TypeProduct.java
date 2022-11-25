package gildedrose.types;

import gildedrose.factory.ItemFactory;
import gildedrose.products.*;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TypeProduct {
    AGED_BRIE("Aged Brie", AgedBrie.class),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert", Backstage.class),
    DEXTERITY("+5 Dexterity Vest", Dexterity.class),
    ELIXIR_MONGOOSE("Elixir of the Mongoose", ElixirMongoose.class),
    SULFURAS("Sulfuras, Hand of Ragnaros", Sulfuras.class);
    private String nameProduct;
    private Class<? extends ItemFactory> clazz;
    private static Map<String, TypeProduct> REVERSE = Arrays.stream(TypeProduct.values())
        .collect(Collectors.toMap(TypeProduct::getNameProduct, Function.identity()));
    TypeProduct(String nameProduct, Class<? extends ItemFactory> clazz) {
        this.nameProduct = nameProduct;
        this.clazz = clazz;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public Class<? extends ItemFactory> getClazz() {
        return this.clazz;
    }

    public static TypeProduct fromNameProduct(String nameProduct) {
        return REVERSE.get(nameProduct);
    }
}
