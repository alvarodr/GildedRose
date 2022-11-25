package gildedrose;

import gildedrose.factory.ItemFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/golden-master.input", delimiter = ';')
    public void golden_master_testing(String itemName,
                                      int initialSellIn,
                                      int initialQuality,
                                      int expectedSellIn,
                                      int expectedQuality) {
        Item item = new Item(itemName, initialSellIn, initialQuality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.sellIn).isEqualTo(expectedSellIn);
        assertThat(item.quality).isEqualTo(expectedQuality);
    }

}
