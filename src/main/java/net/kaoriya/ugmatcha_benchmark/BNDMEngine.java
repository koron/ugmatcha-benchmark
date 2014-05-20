package net.kaoriya.ugmatcha_benchmark;

import com.eaio.stringsearch.BNDM;
import com.eaio.stringsearch.StringSearch;

public class BNDMEngine extends SSearchEngine {

    @Override
    public String getName() {
        return "BNDM:SS";
    }

    public StringSearch getStringSearch() {
        return new BNDM();
    }

}
