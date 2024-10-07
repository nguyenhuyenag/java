package basic.strings;

public class StringBuilderApi {

    public static void compareSpeedStringStringBuilder() {
        String s = "";
        StringBuilder builder = new StringBuilder();

        long start, end;
        final int N = 10000;

        // String
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            s += " ";
        }
        end = System.currentTimeMillis();
        System.out.println("String: " + (int) (end - start) + "ms");

        // StringBuilder
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            builder.append(" ");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (int) (end - start) + "ms");
    }

    // Append part of a char[] to a string
    public static void appendCharArray() {
        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        StringBuilder builder = new StringBuilder();
        builder.append(chars, 6, 5);
        System.out.println(builder);
    }

    public static void delete() {
        StringBuilder builder = new StringBuilder("HelloWorld");
        System.out.println("Before: " + builder);
        builder.deleteCharAt(0);
        System.out.println("Delete specific index=0: " + builder);
        builder.delete(1, 3);
        System.out.println("Delete from range: " + builder);
    }

    public static void indexOf() {
        StringBuilder builder = new StringBuilder("HelloWorld");
        String key = "l";
        System.out.println("IndexOf (first index) = " + builder.indexOf(key));
        System.out.println("IndexOf from Index = " + builder.indexOf(key, 1));
        System.out.println("LastIndexOf = " + builder.indexOf(key));
        System.out.println("LastIndexOf from Index = " + builder.indexOf(key, 7));
    }

    public static void insert() {
        StringBuilder builder = new StringBuilder("HelloWorld");
        builder.insert(0, "123");
        System.out.println("Insert = " + builder);
    }

    /*
        replace(int start, int end, String str)
                = s.substring(0, start) + str + s.substring(end, s.length())
     */
    public static void replace() {
        StringBuilder builder = new StringBuilder("HelloWorld");
        builder.replace(0, 8, "Hi");
        builder = new StringBuilder("HelloWorld");
        builder.replace(0, 2, "Greetings");
        System.out.println(builder);
    }

    public static void reverse() {
        StringBuilder builder = new StringBuilder("HelloWorld");
        builder.reverse();
        System.out.println(builder);
    }

    public static void main(String[] args) {
        // compareSpeedStringStringBuilder();
        // appendCharArray();
        // delete();
        // indexOf();
        // insert();
        // replace();
        reverse();
    }

}
