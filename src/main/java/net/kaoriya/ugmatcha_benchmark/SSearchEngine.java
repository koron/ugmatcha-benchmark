package net.kaoriya.ugmatcha_benchmark;

import java.util.ArrayList;

import com.eaio.stringsearch.StringSearch;

/**
 * StringSearch (http://johannburkard.de/software/stringsearch/) engine.
 */
public abstract class SSearchEngine implements Engine {

    private final ArrayList<String> list = new ArrayList<>();

    private StringSearch searcher;

    public void add(String word) {
        this.list.add(word);
    }

    public void prepare() {
        this.searcher = getStringSearch();
    }

    public String findOne(String text) {
        for (int i = 0; i < this.list.size(); ++i) {
            String s = this.list.get(i);
            if (this.searcher.searchString(text, s) > 0) {
                return s;
            }
        }
        return null;
    }

    public abstract String getName();

    public abstract StringSearch getStringSearch();
}
