package apps;

public class LinearSearch {
	
	public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Target found, return its index
            }
        }
        return -1; // Target not found
    }

}
