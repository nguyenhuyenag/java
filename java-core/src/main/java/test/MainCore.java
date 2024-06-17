package test;

public class MainCore {

    public static void main(String[] args) throws Exception {
        int[] nums = {1, 2, 3, 4};
        int n = 3;

        int maxValueOnNBits = 1 << n;

        for (int i = 1; i <= maxValueOnNBits; i++) {
            for (int bit = 0; bit < n; bit++) {
                int mask = 1 << bit;
                if ((i & mask) == mask) System.out.print(nums[bit]);
            }
            System.out.println();
        }
    }

}
