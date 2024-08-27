package basic.enums;

public class ArithmeticFunction {

    private enum Operation {
        add {
            @Override
            int apply(int a, int b) {
                return a + b;
            }
        }, subtract {
            @Override
            int apply(int a, int b) {
                return a - b;
            }
        }, multiply {
            @Override
            int apply(int a, int b) {
                return a * b;
            }
        }, divide {
            @Override
            int apply(int a, int b) {
                return a / b;
            }
        };

        abstract int apply(int a, int b);
    }

    public static int arithmetic(int a, int b, String operator) {
        return Operation.valueOf(operator).apply(a, b);
    }

    public static void main(String[] args) {
        System.out.println("add: " + arithmetic(1, 2, "add"));
        System.out.println("subtract : " + arithmetic(8, 2, "subtract"));
        System.out.println("multiply: " + arithmetic(5, 2, "multiply"));
        System.out.println("divide: " + arithmetic(8, 2, "divide"));
    }

}
