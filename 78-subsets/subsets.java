import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process with an empty subset and index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to the final result list
        result.add(new ArrayList<>(currentSubset));
        
        // Iterate through the remaining numbers
        for (int i = start; i < nums.length; i++) {
            // Include the number in the current subset
            currentSubset.add(nums[i]);
            
            // Recursively build subsets including this number
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: remove the number to explore other combinations
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}