import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting is crucial for our early pruning optimization
        Arrays.sort(candidates);
        
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        // Base Case: If the remaining target hits 0, we found a valid combination!
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Pruning Optimization: 
            // If subtracting the current candidate drops us below 0, we stop.
            // Since the array is sorted, all future candidates will also drop us below 0.
            if (remain - candidates[i] < 0) {
                break; 
            }
            // 1. Choose
            current.add(candidates[i]);
            // 2. Explore 
            // Notice we pass 'i' instead of 'i + 1' because we can reuse the same element!
            backtrack(result, current, candidates, remain - candidates[i], i);
            // 3. Un-choose (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}