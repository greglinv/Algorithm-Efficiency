package apps;

import java.util.Random;

public class LargeArrayGenerator {

    public static int[] generateSortedArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        array[0] = random.nextInt(10);  // Start with a small number

        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] + random.nextInt(10) + 1; // Ensure the array is strictly increasing
        }

        return array;
    }
    
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound); // Generates a random number up to the specified bound
        }

        return array;
    } 
}
