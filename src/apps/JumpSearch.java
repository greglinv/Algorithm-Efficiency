package apps;

public class JumpSearch {

	public static int jumpSearch(int[] arr, int x) {
		int n = arr.length;

		// Finding the block size to be jumped
		int step = (int) Math.sqrt(n);

		// Finding the block where the element is present (if it is present)
		int prev = 0;
		while (arr[Math.min(step, n) - 1] < x) {
			prev = step;
			step += (int) Math.sqrt(n);
			if (prev >= n)
				return -1; // Element is not present
		}

		// Doing a linear search for x in the block beginning with prev
		while (arr[prev] < x) {
			prev++;

			// If we reached the next block or end of the array
			if (prev == Math.min(step, n))
				return -1; // Element is not present
		}

		// If element is found
		if (arr[prev] == x)
			return prev;

		return -1;
	}

}
