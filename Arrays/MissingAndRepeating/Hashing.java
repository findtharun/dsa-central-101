package Arrays.MissingAndRepeating;

import java.util.ArrayList;

import java.util.*;

public class Hashing {
    public static List<Integer> find_missing(List<Integer> arr) {
    // Write your code here
         HashMap<Integer, Boolean> numberMap
            = new HashMap <>();
        ArrayList<Integer> res = new ArrayList<>();
 
        int max = arr.size();
 
        for (Integer i : arr) {
 
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            }
            else {
                res.add(i);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                res.add(i);
            }
        }
        return res;
    }

}
