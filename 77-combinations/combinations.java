import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start backtracking from number 1
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base Case: If the current combination size equals k, we have a complete set
        if (current.size() == k) {
            result.add(new ArrayList<>(current)); // Deep copy
            return;
        }
        // Optimization (Pruning): Stop the loop early if there aren't enough numbers left 
        // to complete a combination of size k.
        int needed = k - current.size();
        int limit = n - needed + 1;
        for (int i = start; i <= limit; i++) {
            // 1. Choose
            current.add(i);
            // 2. Explore (move start pointer forward to avoid permutations)
            backtrack(result, current, i + 1, n, k);
            // 3. Un-choose (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}