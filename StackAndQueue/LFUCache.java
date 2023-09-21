package StackAndQueue;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    /* . */
    /*
     * @param capacity: total capacity of LFU Cache
     * 
     * @param curSize: current size of LFU cache
     * 
     * @param minFrequency: frequency of the last linked list (the minimum frequency
     * of entire LFU cache)
     * 
     * @param cache: a hash map that has key to Node mapping, which used for storing
     * all nodes by their keys
     * 
     * @param frequencyMap: a hash map that has key to linked list mapping, which
     * used for storing all
     * double linked list by their frequencies
     */
    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, DLLNode> cache; // Storing Node values
    Map<Integer, DoubleLinkedList> frequencyMap; // Each Key Contains an LRU

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            curSize++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well
            // as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node
        // is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        // if frequency having 1 are epty, Then Min Frequency would be 2.
        // If new Node is added and we have size the Min Frequency would be 1
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
}

class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(-1, -1);
        this.tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode newnode) {
        DLLNode temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
        listSize++;
    }

    public void removeNode(DLLNode delNode) {
        DLLNode prevNode = delNode.prev;
        DLLNode nextNode = delNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}
