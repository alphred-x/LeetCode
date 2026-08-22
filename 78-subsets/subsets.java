import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Convert the given array into a dynamic List for our Input
        List<Integer> input = new ArrayList<>();
        for (int num : nums) {
            input.add(num);
        }
        // Our starting Output is empty
        List<Integer> output = new ArrayList<>();
        // Fire up the recursive engine
        solve(input, output, result);
        return result;
    }
    private void solve(List<Integer> input, List<Integer> output, List<List<Integer>> result) {
        // Base Case: When the input is completely empty, the output is a finished subset.
        if (input.size() == 0) {
            result.add(output);
            return;
        }
        // We make a decision based on the 0th element of the current input
        int element = input.get(0);
        // Branch 1: EXCLUDE the element
        // We just take the current output exactly as it is
        List<Integer> output1 = new ArrayList<>(output); 
        // Branch 2: INCLUDE the element
        // We copy the current output and add the decision element to it
        List<Integer> output2 = new ArrayList<>(output); 
        output2.add(element);
        // Shrink the input for the next recursive steps
        List<Integer> newInput = new ArrayList<>(input);
        newInput.remove(0);
        // Call the function again with the smaller input and our two different outputs
        solve(newInput, output1, result); // The "Exclude" path
        solve(newInput, output2, result); // The "Include" path
    }
}