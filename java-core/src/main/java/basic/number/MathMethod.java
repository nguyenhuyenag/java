package basic.number;

public class MathMethod {

    // Convert `long` -> `int`
    public static void longToInt() {
        long longValue = 123;
        int intValue = Math.toIntExact(longValue);
        System.out.println(intValue);
    }

    /*-
     * x^y = a -> y = log_x(a)
     *
     * Ví dụ: 10^3 = 1000 -> Logarit cơ số 10 của 1000 là 3 -> log_10(1000) = 3
     *
     * log_b(x) = log_k(x)  /  log_k(x)
     *          = log_e(x)  /  log_e(x)
     *          = log_10(x) /  log_10(x)
     */
    public static void log() {
        double base = 3;
        double number = 27;
        double result = Math.log(number) / Math.log(base);
        System.out.println("Logarit cơ số 3 của 27 là: " + result);
    }

    public static void main(String[] args) {
        // longToInt();
        // System.out.println((int) Math.signum(-1));
         log();
    }

}
