import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long currentVal = 1; 
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) currentVal);
            currentVal = currentVal * (rowIndex - i) / (i + 1);
        }
        return row;
    }
}