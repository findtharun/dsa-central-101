package Strings;

import java.util.HashMap;
import java.util.PriorityQueue;
//https://leetcode.com/problems/integer-to-roman/description/
//https://leetcode.com/problems/roman-to-integer/

public class IntegerRomanConversions {

    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) { // in Roman Representation it is
                                                                                    // always decreasing and if
                                                                                    // inreasing order found we need to
                                                                                    // handle
                sum = sum - roman.get(s.charAt(i));
            } else {
                sum = sum + roman.get(s.charAt(i));
            }
        }
        return sum;
    }

    public String intToRoman(int num) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        StringBuilder ans = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet()); // Sorting Based on Values
        while (!pq.isEmpty()) {
            String symbol = pq.peek();
            int val = map.get(symbol);
            while (num >= val) {
                ans.append(symbol);
                num = num - val;
            }
            pq.poll();
        }
        return ans.toString();
    }
}
