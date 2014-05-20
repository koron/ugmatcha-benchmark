package net.kaoriya.ugmatcha_benchmark;

import com.eaio.stringsearch.BoyerMooreHorspool;
import com.eaio.stringsearch.StringSearch;

public class BMHEngine extends SSearchEngine {

    @Override
    public String getName() {
        return "BMH:SS";
    }

    public StringSearch getStringSearch() {
        return new BoyerMooreHorspool();
    }

}
