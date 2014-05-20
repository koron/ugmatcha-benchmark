package net.kaoriya.ugmatcha_benchmark;

import com.eaio.stringsearch.BoyerMooreHorspoolRaita;
import com.eaio.stringsearch.StringSearch;

public class BMHREngine extends SSearchEngine {

    @Override
    public String getName() {
        return "BMHR:SS";
    }

    public StringSearch getStringSearch() {
        return new BoyerMooreHorspoolRaita();
    }

}
