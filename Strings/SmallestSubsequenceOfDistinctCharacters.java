package Strings;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (visited[curr - 'a'] == true) {
                freq[curr - 'a']--;
                continue;
            }
            // We push to Stack with Increasing order and If it is not going to occur again,
            // else we pop to maintain lexography ((lowest char first))
            while (!stack.isEmpty() && stack.peek() > curr && freq[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(curr);
            visited[curr - 'a'] = true;
            freq[curr - 'a']--;
        }
        String res = "";
        while (!stack.isEmpty())
            res += stack.pop();
        StringBuilder ans = new StringBuilder();
        ans.append(res);
        return ans.reverse().toString();
    }
}
