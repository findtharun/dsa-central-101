import java.util.*;

public class CustomSort {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<Integer>();
        for (int num : arr) {
            closestElements.add(num);
        }
        // Sorting based on the requirement
        Collections.sort(closestElements, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
        List<Integer> kClosestElements = closestElements.subList(0, k);
        Collections.sort(kClosestElements);
        return kClosestElements;
    }
}
