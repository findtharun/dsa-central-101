package PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word: words)
            map.put(word, map.getOrDefault(word,0)+1);
        PriorityQueue<String> pq = new PriorityQueue<String>((a,b) ->{ 
            if(map.get(b) == map.get(a)) // if Same Freq, Get Smallest
                return a.compareTo(b);
            else
                return map.get(b)-map.get(a); // Else Get High Frequency First
            });
    pq.addAll(map.keySet());
    ArrayList<String> res = new ArrayList<>();
    while(k>0){
        res.add(pq.poll());
        k--;
    }
    return res;
    }
}
