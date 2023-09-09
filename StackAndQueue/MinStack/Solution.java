import java.util.Stack;
public class Solution {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        st.push(val);
        // We Need to Maintain the Order of Elements Inserted, So We Will Consider the
        // Min Element at each Position
        int minValAtThePosition;
        // if Stack is Not , We should get Min of Existing Ele and New Ele
        if (!(minStack.isEmpty())) {
            minValAtThePosition = Math.min(val, minStack.peek());
        } else {
            minValAtThePosition = val;
        }
        minStack.push(minValAtThePosition);
    }

    public void pop() {
        st.pop();
        minStack.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
