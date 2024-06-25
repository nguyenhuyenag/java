package jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@Fork(1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class IndexOfAndContainsPerfTest {

    private char c;
    private String s;
    private String str;

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Setup
    public void setup() {
        str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        c = 'z';
        s = "z";
    }

    @Benchmark
    public int indexOfChar() {
        return str.indexOf('z');
    }

    @Benchmark
    public int indexOfString() {
        return str.indexOf("z");
    }

    @Benchmark
    public int indexOfCharIndirect() {
        return str.indexOf(c);
    }

    @Benchmark
    public int indexOfStringIndirect() {
        return str.indexOf(s);
    }

    @Benchmark
    public boolean containsString() {
        return str.contains("z");
    }

    @Benchmark
    public boolean containsStringIndirect() {
        return str.contains(s);
    }

}
