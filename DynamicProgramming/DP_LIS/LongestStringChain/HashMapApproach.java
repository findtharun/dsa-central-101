package DynamicProgramming.DP_LIS.LongestStringChain;

import java.util.*;

public class HashMapApproach {
    public int longestStrChain(String[] words) {
        int n = words.length;
        if (n == 1)
            return 1;
        int res = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length(); // Sort in Ascending order of word lengths
            }
        };
        Arrays.sort(words, comp);
        for (int i = 0; i < n; i++) {
            String word = words[i];
            memo.put(word, 1);
            for (int j = 0; j < word.length(); j++) {
                StringBuilder curr = new StringBuilder(word);
                String next = curr.deleteCharAt(j).toString();
                if (memo.containsKey(next))
                    memo.put(word, Math.max(memo.get(word), 1 + memo.get(next)));

            }
            res = Math.max(res, memo.get(word));
        }
        return res;
    }
}
