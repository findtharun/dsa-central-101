package Recursion_Backtracking.BackTracking;

import java.util.*;

class KeypadCombinations {
    Set<String> res = new HashSet<>();
    Map<String, String> map = new HashMap<>();

    public KeypadCombinations() {
        map.put("2", "a");
        map.put("22", "b");
        map.put("222", "c");
        map.put("3", "d");
        map.put("33", "e");
        map.put("333", "f");
        map.put("4", "g");
        map.put("44", "h");
        map.put("444", "i");
        map.put("5", "j");
        map.put("55", "k");
        map.put("555", "l");
        map.put("6", "m");
        map.put("66", "n");
        map.put("666", "o");
        map.put("7", "p");
        map.put("77", "q");
        map.put("777", "r");
        map.put("7777", "s");
        map.put("8", "t");
        map.put("88", "u");
        map.put("888", "v");
        map.put("9", "w");
        map.put("99", "x");
        map.put("999", "y");
        map.put("9999", "z");
    }

    public void solve(String digits, int index, StringBuilder ans) {
        if (index > digits.length()) {
            return;
        }

        if (index == digits.length() && ans.length() > 0) {
            res.add(ans.toString());
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            String x = digits.substring(index, i + 1);
            if (map.containsKey(x)) {
                ans.append(map.get(x));
                solve(digits, i + 1, ans);
                ans.deleteCharAt(ans.length() - 1); // Backtrack
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        res.clear();
        solve(digits, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        KeypadCombinations solution = new KeypadCombinations();
        String digits = "2234";
        List<String> combinations = solution.letterCombinations(digits);
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
