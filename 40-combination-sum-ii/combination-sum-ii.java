import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    void fun(List<Integer> input, List<Integer> output, List<List<Integer>> ans, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }
        if (target < 0 || input.size() == 0) {
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            List<Integer> ip = new ArrayList<>(input);
            List<Integer> op = new ArrayList<>(output);
            if (i > 0 && ip.get(i).equals(ip.get(i - 1))) {
                continue;
            }
            int currentVal = ip.get(i);
            op.add(currentVal);
            ip.subList(0, i + 1).clear();
            fun(ip, op, ans, target - currentVal);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(candidates);
        for (int a : candidates) {
            input.add(a);
        }
        fun(input, output, ans, target);
        return ans;
    }
}