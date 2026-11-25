
import java.util.*;

class Solution {
    public int findPairs(int[] arr, int k) {

        if (k < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int pairs = 0;
        for(int ele : map.keySet()){
            if (k == 0) {
                // Need at least 2 occurrences of the same number
                if (map.get(ele) >= 2) pairs++;
            } else {
                // Check only one direction to avoid double-counting
                if (map.containsKey(ele + k)) pairs++;
            }
        }
        return pairs;
    }
}
