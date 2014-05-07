package net.kaoriya.ugmatcha_benchmark;

import java.util.List;
import java.io.File;

public class BenchmarkMain {

    public static double MEGABYTES = 1024 * 1024;

    public static final String WORDS_PATH = "data/words2.txt";

    public static final String TARGETS_PATH = "data/targets2.txt";

    public static final long FINDCOUNT = 100000;

    public static void benchmark(
            Engine engine,
            long findCount)
        throws Exception
    {
        List<String> words = Utils.readLines(new File(WORDS_PATH));
        List<String> targets = Utils.readLines(new File(TARGETS_PATH));
        benchmark(engine, words, targets, findCount);
    }

    public static void benchmark(
            Engine engine,
            List<String> words,
            List<String> targets,
            long findCount)
        throws Exception
    {
        for (String word : words) {
            engine.add(word);
        }
        engine.prepare();

        Runtime rt = Runtime.getRuntime();
        System.gc();
        System.gc();

        boolean loop = true;
        long count = 0;
        long found = 0;
        long memMin = rt.totalMemory() - rt.freeMemory();
        long memMax = memMin;
        long start = System.nanoTime();
        while (loop) {
            for (String target : targets) {
                if (engine.findOne(target) != null) {
                    ++found;
                }
                long mem = rt.totalMemory() - rt.freeMemory();
                if (mem > memMax) {
                    memMax = mem;
                }
                ++count;
                if (count >= findCount) {
                    loop = false;
                    break;
                }
            }
        }
        long elapsed = System.nanoTime() - start;

        double seconds = elapsed / 1e9;
        System.out.format(
                "%1$10s %2$10.3f Qs/sec (%3$d Qs in %4$6.3fs) found %5$d Ws",
                engine.getName(), count / seconds, count, seconds, found,
                memMax - memMin);
        System.out.println("");
        System.out.format(
                "%1$10s (used %2$d bytes, max %3$.3fMB, min %4$.3fMB)",
                "", memMax - memMin, memMax / MEGABYTES, memMin / MEGABYTES);
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        benchmark(new UGMatcherEngine(), FINDCOUNT);
        benchmark(new UGMatcherEngine(), FINDCOUNT);
        benchmark(new UGMatcherEngine(), FINDCOUNT);
        benchmark(new UGMatcherEngine(), FINDCOUNT);
        benchmark(new UGMatcherEngine(), FINDCOUNT);
        benchmark(new RegexpEngine(), FINDCOUNT);
        benchmark(new RegexpEngine(), FINDCOUNT);
        benchmark(new RegexpEngine(), FINDCOUNT);
        benchmark(new RegexpEngine(), FINDCOUNT);
        benchmark(new RegexpEngine(), FINDCOUNT);

        System.out.println("");
        System.out.println("# Qs=queries, Ws=words, MB=1024*1024");
    }
}
