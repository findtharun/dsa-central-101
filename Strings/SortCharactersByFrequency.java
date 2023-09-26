package Strings;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int freq = map.getOrDefault(ch, 0);
                map.put(ch, freq + 1);
            } else {
                map.put(ch, 1);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        // Sorting Characters by Frequncy in Descending Order

        pq.addAll(map.keySet());
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char curr = pq.poll();
            int freq = map.get(curr);
            while (freq-- > 0) {
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}
