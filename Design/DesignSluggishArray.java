package Design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
// Function<Arguments, Return Type>
class SluggishArray {
    private List<Integer> array;
    private List<Function<Integer, Integer>> functions;

    public SluggishArray(List<Integer> array) {
        this.array = new ArrayList<>(array);
        this.functions = new ArrayList<>();
    }

    // Method to add a new function to the chain
    public SluggishArray Map(Function<Integer, Integer> func) {
        functions.add(func);
        return this;
    }

    // Method to get the index of a value after all functions are applied
    public Integer getIndexOf(int value) {
        for (int i = 0; i < array.size(); i++) {
            int transformedValue = array.get(i);
            for (Function<Integer, Integer> func : functions) {
                transformedValue = func.apply(transformedValue);
            }
            if (transformedValue == value) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }

    // Optional: Method to visualize the array after applying all functions
    public List<Integer> getTransformedArray() {
        List<Integer> transformedArray = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int transformedValue = array.get(i);
            for (Function<Integer, Integer> func : functions) {
                transformedValue = func.apply(transformedValue);
            }
            transformedArray.add(transformedValue);
        }
        return transformedArray;
    }
}

public class DesignSluggishArray {

    public static void main(String[] args) {
        List<Integer> initialArray = Arrays.asList(1, 2, 3, 4, 5);

        SluggishArray sluggishArray = new SluggishArray(initialArray);

        sluggishArray.Map(x -> x * 2) // Multiply all elements by 2
                .Map(x -> x + 1) // Add 1 to all elements
                .Map(x -> x * x); // Square all elements

        System.out.println(sluggishArray.getIndexOf(25)); // Should return 1 (since 2*2+1=5, 5*5=25)
        System.out.println(sluggishArray.getTransformedArray()); // Prints transformed array
    }
}
