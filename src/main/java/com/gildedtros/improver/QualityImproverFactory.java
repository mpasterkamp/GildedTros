package com.gildedtros.improver;

import com.gildedtros.Item;

import java.util.function.Function;

import static com.gildedtros.Constants.*;

public class QualityImproverFactory {

    public Function<Item, QualityImprover> createQualityImprover(String name) {
        return switch (name) {
            case GOOD_WINE -> GoodWineQualityImprover::new;
            case BACKSTAGE_PASSES_FOR_HAXX, BACKSTAGE_PASSES_FOR_RE_FACTOR -> BackstagePassQualityImprover::new;
            case B_DAWG_KEYCHAIN -> KeychainQualityImprover::new;
            default -> OtherItemsQualityImprover::new;
        };
    }
}
