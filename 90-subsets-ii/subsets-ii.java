import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to easily identify duplicates
        Arrays.sort(nums);
        
        // Start backtracking
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current valid subset
        result.add(new ArrayList<>(currentSubset));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: 
            // If it's not the first element in this loop iteration (i > start) 
            // and it's equal to the previous element, skip to avoid duplicate subsets.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Choose
            currentSubset.add(nums[i]);
            
            // Explore
            backtrack(result, currentSubset, nums, i + 1);
            
            // Un-choose (Backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}