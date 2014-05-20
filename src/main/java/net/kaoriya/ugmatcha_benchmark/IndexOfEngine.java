package net.kaoriya.ugmatcha_benchmark;

import java.util.ArrayList;

public class IndexOfEngine implements Engine {

    private final ArrayList<String> list = new ArrayList<>();
    
    public void add(String word) {
        this.list.add(word);
    }

    public void prepare() {
    }

    public String findOne(String text) {
        for (int i = 0; i < this.list.size(); ++i) {
            String s = this.list.get(i);
            if (text.indexOf(s) >= 0) {
                return s;
            }
        }
        return null;
    }

    public String getName() {
        return "IndexOf";
    }
}
