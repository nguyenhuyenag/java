//package jmh;
//
//import org.openjdk.jmh.annotations.*;
//
//import java.util.concurrent.TimeUnit;
//
//@Fork(3)
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
//@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
//public class IndexOfAndContainsTest {
//
//    private String str;
//    private char c;
//    private String s;
//
//    @Setup
//    public void setup() {
//        str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        c = 'z';
//        s = "z";
//    }
//
//    @Benchmark
//    public int indexOfChar() {
//        return str.indexOf('z');
//    }
//
//    @Benchmark
//    public int indexOfString() {
//        return str.indexOf("z");
//    }
//
//    @Benchmark
//    public int indexOfCharIndirect() {
//        return str.indexOf(c);
//    }
//
//    @Benchmark
//    public int indexOfStringIndirect() {
//        return str.indexOf(s);
//    }
//
//    @Benchmark
//    public boolean containsString() {
//        return str.contains("z");
//    }
//
//    @Benchmark
//    public boolean containsStringIndirect() {
//        return str.contains(s);
//    }
//
//}
