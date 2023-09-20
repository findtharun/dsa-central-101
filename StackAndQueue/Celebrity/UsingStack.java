package StackAndQueue.Celebrity;

import java.util.Stack;

public class UsingStack {
    int celebrity(int M[][], int n) {
        // code here

        Stack<Integer> celebStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            celebStack.push(i);
        }
        while (celebStack.size() >= 2) {
            int first = celebStack.pop();
            int second = celebStack.pop();
            // We Only Push Possible Celebrities to Stack
            if (M[first][second] == 1)
                celebStack.push(second);
            else if (M[second][first] == 1)
                celebStack.push(first);
        }
        if (!celebStack.isEmpty()) {
            int celeb = celebStack.pop();
            for (int col = 0; col < n; col++) {
                if (M[celeb][col] == 1)
                    return -1; // Value should be zero , As Celebrity Should not Know Anyone
            }
            for (int row = 0; row < n; row++) {
                if (row != celeb && M[row][celeb] == 0) // Value should be 1 , As Celebrity Should be known by All
                    return -1;
            }
            return celeb;
        }
        return -1;
    }
}
