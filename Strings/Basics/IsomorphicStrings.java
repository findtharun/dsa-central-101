package Strings.Basics;

import java.util.HashMap;
//https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sT = new HashMap<>();
        HashMap<Character, Character> tS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if ((sT.containsKey(c1) && sT.get(c1) != c2) ||
                    (tS.containsKey(c2) && tS.get(c2) != c1)) {
                return false;
            }
            sT.put(c1, c2);
            tS.put(c2, c1);
        }
        return true;
    }
}
