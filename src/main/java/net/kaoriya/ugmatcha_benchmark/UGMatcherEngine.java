package net.kaoriya.ugmatcha_benchmark;

import java.util.ArrayList;

import net.kaoriya.ugmatcha.UGMatcher;
import net.kaoriya.ugmatcha.MatchHandler;

public class UGMatcherEngine implements Engine, MatchHandler {

    private ArrayList<String> list = new ArrayList<>();

    private UGMatcher matcher = null;

    private String scanResult = null;

    public void add(String word) {
        this.list.add(word);
        this.matcher = null;
    }

    public void prepare() {
        getMatcher();
    }

    public String findOne(String text) {
        this.scanResult = null;
        UGMatcher m = getMatcher();
        m.match(text, this, 1);
        return this.scanResult;
    }

    UGMatcher getMatcher() {
        if (this.matcher == null) {
            this.matcher = UGMatcher.newMatcher(this.list);
        }
        return this.matcher;
    }

    public boolean matched(UGMatcher matcher, int wordId,
            String text, int index)
    {
        this.scanResult = matcher.getWord(wordId);
        return true;
    }

    public String getName() {
        return "UGMatcher";
    }
}
