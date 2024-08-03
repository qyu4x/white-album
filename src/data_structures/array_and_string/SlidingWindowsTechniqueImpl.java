package data_structures.array_and_string;


class SlidingWindows {

    private int[] data;

    private int k;

    public SlidingWindows(int[] data, int k) {
        this.data = data;
        this.k = k;
    }

    /* SAMPLE PROBLEM:
    Assume you're practicing for competitive programming and you encounter the following problem:
    "Find the maximum sum of sub-array of size k with the time complexity of O(N).
    Array = [1, 2, 6, 2, 4, 1], k = 3"
     */

    // using brute force, time complexity O(N * M)
    public void maxSUmOfSubArrayBruteForce() {
        int max = 0;
        for (int i = 0; i <= data.length - k - 1; i++) {
            int count = 0;
            for (int j = i; j <= i + k - 1; j++) {
                count += data[j];
            }

            if (count >= max) {
                max = count;
            }
        }

        System.out.println("maximal data is : " + max);
    }

    // using sliding windows time complexity O(n)
    public void maxSumOfSubArraySlidingWindows() {
        int start = 0;
        int end = 0;

        int max = 0;
        while (end < k) {
            max += this.data[end];
            end++;
        }

        int count = max;
        while (end < this.data.length) {
            count = Math.max((count - this.data[start]) + this.data[end], count);
            end++;
            start++;
        }

        System.out.println("maximal data is : " + count);
    }
}

public class SlidingWindowsTechniqueImpl {

    public static void main(String[] args) {

        int[] data = new int[]{1, 2, 6, 2, 4, 1};
        SlidingWindows slidingWindows = new SlidingWindows(data, 3);
        slidingWindows.maxSUmOfSubArrayBruteForce();
        slidingWindows.maxSumOfSubArraySlidingWindows();

    }


}
