package net.kaoriya.ugmatcha_benchmark;

import java.util.List;

import net.kaoriya.ugmatcha2.AhoCorasick;

/**
 * My Aho-Corasick Engine (experimental).
 */
public class MyAhoCoraEngine implements Engine {

    private final AhoCorasick<Object> aho = new AhoCorasick<>();

    public void add(String word) {
        this.aho.add(word, null);
    }

    public void prepare() {
        this.aho.compile();
    }

    public String findOne(String text) {
        List<AhoCorasick.Match<Object>> list = this.aho.matchAll(text);
        if (list.size() > 0) {
            return list.get(0).pattern;
        } else {
            return null;
        }
    }

    public String getName() {
        return "MyAhoCora";
    }
}
