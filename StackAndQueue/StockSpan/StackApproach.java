package StackAndQueue.StockSpan;

import java.util.Stack;

public class StackApproach {
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] span = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.empty() && price[i] >= price[s.peek()]) { // Pushing Only Greater Elements to Stack
                s.pop();
            }
            span[i] = s.empty() ? (i + 1) : (i - s.peek());
            s.push(i);
        }
        return span;
    }

    // Online Stack Spanner
    class Pair {
        int price;
        int index;

        Pair(Integer price, Integer index) {
            this.price = price;
            this.index = index;
        }
    }

    Stack<Pair> st = new Stack<>();;
    int index = -1;

    public int next(int price) {
        index++;
        Pair pair = new Pair(price, index);
        while (!st.isEmpty() && price >= st.peek().price) {
            st.pop();
        }
        if (st.isEmpty()) {
            st.push(pair);
            return index + 1;
        } else {
            int prevHigh = st.peek().index;
            st.push(pair);
            return index - prevHigh;
        }
    }

}
