//package jmh;
//
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;
//
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.BenchmarkMode;
//import org.openjdk.jmh.annotations.Fork;
//import org.openjdk.jmh.annotations.Mode;
//import org.openjdk.jmh.annotations.OutputTimeUnit;
//import org.openjdk.jmh.annotations.Scope;
//import org.openjdk.jmh.annotations.State;
//
///*-
//    https://github.com/tedyoung/indexof-contains-benchmark
// */
//@Fork(1)
//@State(Scope.Benchmark)
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//public class BenchMarkTest {
//
//    private final int M = 100;
//    private final int N = 100;
//    int[][] matrix = new int[M][N];
//
//    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }
//
//    @Benchmark
//    public void method1() {
//        for (int i = 0; i < M * N; i++) {
//            int row = i / N;
//            int col = i % N;
//            matrix[row][col] = -1;
//        }
//    }
//
//    @Benchmark
//    public void method2() {
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                matrix[i][j] = -1;
//            }
//        }
//    }
//
//    @Benchmark
//    public void method3() {
//        for (int[] row : matrix) {
//            Arrays.fill(row, -1);
//        }
//    }
//
//}
