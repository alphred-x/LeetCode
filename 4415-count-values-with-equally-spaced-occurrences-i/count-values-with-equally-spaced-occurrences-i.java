import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> indexTracker = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexTracker.putIfAbsent(nums[i], new ArrayList<>());
            indexTracker.get(nums[i]).add(i);
        }
        int specialCount = 0;
        for (List<Integer> indices : indexTracker.values()) {
            if (indices.size() == 3) {
                int i1 = indices.get(0);
                int i2 = indices.get(1);
                int i3 = indices.get(2);
                if (i2 - i1 == i3 - i2) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }
}