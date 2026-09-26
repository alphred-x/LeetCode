import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int chainLength = 0;
        int currentEnd = Integer.MIN_VALUE; 
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            if (start > currentEnd) {
                chainLength++;
                currentEnd = end;
            }
        }
        return chainLength;
    }
}