package Greedy.FractionalKnapsack;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSort {
    double fractionalKnapsack(int W, Item arr[], int n) {
        // sorting items on basis of value/weight ratio.
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) { // Sorting in Descending Order
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                if (r1 > r2) {
                    return -1;
                } else if (r1 < r2) {
                    return 1;
                }
                return 0;
            }
        });

        // taking variable for current weight in knapsack.
        int curWeight = 0;
        double finalvalue = 0.0;

        // iterating over all the items.
        for (int i = 0; i < n; i++) {
            // if currweight + item's weight is less than or equal to W,
            // then we add the item's value to final value.
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
            // else we take the fraction of the that item's value
            // based on the remaining weight in knapsack.
            else {
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double) remain / arr[i].weight);
                break;
            }
        }
        // returning final value.
        return finalvalue;
    }
}
