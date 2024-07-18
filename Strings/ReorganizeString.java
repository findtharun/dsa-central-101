package Strings;

import java.util.*;

class Pair {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
// https://leetcode.com/problems/reorganize-string
public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        Pair prev = new Pair('#', -1);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(curr.ch);
            curr.freq--;
            if (prev.freq > 0) {
                pq.add(prev);
            }
            prev = curr;
        }
        if (sb.length() != s.length())
            return "";
        return sb.toString();
    }
}
