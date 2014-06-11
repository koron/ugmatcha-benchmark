package net.kaoriya.ugmatcha_benchmark;

import java.util.List;

import net.kaoriya.ugmatcha2.AhoCorasick;
import net.kaoriya.ugmatcha2.MatchHandler;

/**
 * My Aho-Corasick Engine (experimental).
 */
public class MyAhoCoraEngine implements Engine, MatchHandler<Object> {

    private final AhoCorasick<Object> aho = new AhoCorasick<>();

    private String lastPattern = null;

    public void add(String word) {
        this.aho.add(word, null);
    }

    public void prepare() {
        this.aho.compile();
    }

    public boolean matched(int index, String pattern, Object value) {
        this.lastPattern = pattern;
        return false;
    }

    public String findOne(String text) {
        this.lastPattern = null;
        this.aho.match(text, this, 0);
        return this.lastPattern;
    }

    public String getName() {
        return "MyAhoCora";
    }
}
