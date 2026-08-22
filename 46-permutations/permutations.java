import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking with an empty list and an empty boolean tracker
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, int[] nums, boolean[] used) {
        // Base Case: If the permutation size matches the array length, we are done
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation)); // Deep copy!
            return;
        }

        // Always start from 0 to capture every possible order
        for (int i = 0; i < nums.length; i++) {
            // Skip the number if it is already in the current permutation branch
            if (used[i]) {
                continue;
            }

            // 1. Choose
            used[i] = true;
            currentPermutation.add(nums[i]);

            // 2. Explore
            backtrack(result, currentPermutation, nums, used);

            // 3. Un-choose (Backtrack)
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}