package easy;

import java.util.Arrays;

public class Sum {

    public static void main(String[] args) {
        Sum sum = new Sum();
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
//        int target = 9;
        int target = 6;
        System.out.print("Target: " + target + " Input: ");
        Arrays.stream(nums).forEach(System.out::print);
        int[] ints = sum.twoSum(nums, target);
        System.out.println();
        System.out.print("Output: ");
        Arrays.stream(ints).forEach(System.out::print);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
