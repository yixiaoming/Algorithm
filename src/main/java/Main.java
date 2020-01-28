import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{10, 1, 2, 7, 6, 1, 5}));
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int record = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            if (record != nums[i]) {
                break;
            } else {
                record++;
            }
        }
        return record;
    }
}

