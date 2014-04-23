package net.kaoriya.ugmatcha_benchmark;

public interface Engine {

    void add(String word);

    void prepare();

    String findOne(String text);

    String getName();
}
