package net.kaoriya.ugmatcha_benchmark;

import java.util.Collection;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

/**
 * Aho-Corasick Engine.
 *
 * See:
 *      http://d.hatena.ne.jp/naoya/20090405/aho_corasick
 *      https://github.com/robert-bor/aho-corasick
 */
public class AhoCoraEngine implements Engine {

    private final Trie trie = new Trie();

    public void add(String word) {
        this.trie.addKeyword(word);
    }

    public void prepare() {
    }

    public String findOne(String text) {
        Collection<Emit> emits = this.trie.parseText(text);
        for (Emit emit : emits) {
            return emit.getKeyword();
        }
        return null;
    }

    public String getName() {
        return "AhoCora";
    }
}
