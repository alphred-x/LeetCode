import java.util.*;

class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n); 
        Stack<Integer> stack = new Stack<>();
        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
            indicesMap.putIfAbsent(nums[i], new ArrayList<>());
            indicesMap.get(nums[i]).add(i);
        }
        
        long totalPairs = 0;
        for (int i = 0; i < n; i++) {
            int R = nextSmaller[i];
            int rangeLength = R - i - 1;
            
            if (rangeLength > 0) {
                List<Integer> list = indicesMap.get(nums[i]);
                int startBoundary = i + 1;
                int endBoundary = R - 1;
                int countEquals = upperBound(list, endBoundary) - lowerBound(list, startBoundary);
                totalPairs += (rangeLength - countEquals);
            }
        }    
        return totalPairs;
    }
    int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}