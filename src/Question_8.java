import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question_8 {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it cannot be a doubled array
        }

        int[] original = new int[changed.length / 2];
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(changed);

        int index = 0;
        for (int num : changed) {
            if (countMap.containsKey(num) && countMap.containsKey(num * 2)) {
                original[index++] = num;
                int newCount = countMap.get(num * 2) - 1;
                if (newCount == 0) {
                    countMap.remove(num * 2);
                } else {
                    countMap.put(num * 2, newCount);
                }
                int count = countMap.get(num) - 1;
                if (count == 0) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, count);
                }
            }
        }

        if (!countMap.isEmpty()) {
            return new int[0]; // If there are unmatched elements, it is not a doubled array
        }

        return original;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        if (original.length == 0) {
            System.out.println("Empty Array");
        } else {
            System.out.print("Original Array: ");
            for (int num : original) {
                System.out.print(num + " ");
            }
        }
    }
}
