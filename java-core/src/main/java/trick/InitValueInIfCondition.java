package trick;

public class InitValueInIfCondition {

    public static void init(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) { // <- here
            return;
        }
        System.out.println("Length: " + strLen);
    }

    public static void main(String[] args) {
        String input = "Java123";
        init(input);
    }

}
