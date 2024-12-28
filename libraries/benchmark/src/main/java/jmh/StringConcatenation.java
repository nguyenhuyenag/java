package jmh;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Fork(1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class StringConcatenation {

    @Benchmark
    public void usingAdditionOperator() {
        String str1 = "String";
        String str2 = "Concat";
        String result = str1 + str2;
    }

    @Benchmark
    public void usingConcat() {
        String str1 = "String";
        String str2 = "Concat";
        String result = str1.concat(str2);
    }

    @Benchmark
    public void usingJoin() {
        String str1 = "String";
        String str2 = "Concat";
        String result = String.join("", str1, str2);
    }

    @Benchmark
    public void usingFormat() {
        String str1 = "String";
        String str2 = "Concat";
        String result = String.format("%s%s", str1, str2);
    }

    @Benchmark
    public void usingStreamAPI() {
        List<String> strList = List.of("String", "Concat");
        String result = strList.stream().collect(Collectors.joining());
    }

    @Benchmark
    public void usingStringBuffer() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("String");
        buffer.append("Concat");
        String result = buffer.toString();
    }

    @Benchmark
    public void usingStringBuilder() {
        StringBuilder builder = new StringBuilder();
        builder.append("String");
        builder.append("Concat");
        String result = builder.toString();
    }

    @Benchmark
    public void usingStringJoiner() {
        StringJoiner joiner = new StringJoiner("");
        joiner.add("String");
        joiner.add("Concat");
        String result = joiner.toString();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
