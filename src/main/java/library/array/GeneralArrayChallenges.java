package library.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GeneralArrayChallenges {

    /***
     * @param arr array to search
     * @return missing number
     * @complexity Time -> O(n), Space -> O(1)
     */
    public int missingNumberInGivenArray(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length + 1; i++)
            sum += i;

        int arrSum = 0;

        for (int j : arr)
            arrSum += j;

        return sum - arrSum;
    }

    /***
     * @param arr array to search
     * @param sum target sum
     * @return the values
     * @complexity Time -> O(n^2), Space -> O(1)
     */
    public int[] twoSumBruteForce(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == sum)
                    return new int[]{arr[i], arr[j]};

        return new int[]{-1, -1};
    }

    /***
     * @param arr array to search
     * @param sum target sum
     * @return the values
     * @complexity Time -> O(n), Space -> O(n)
     */
    public int[] twoSumExtraDS(int[] arr, int sum) {
        HashSet<Integer> tracker = new HashSet<>();

        for (int j : arr)
            if (tracker.contains(sum - j))
                return new int[]{j, sum - j};
            else
                tracker.add(j);

        return new int[]{-1, -1};
    }

    /***
     * @param arr subject array
     * @param windowSize subject window size
     * @return maximum sum
     * @complexity Time -> O(nk), Space -> O(1)
     */
    public int maximumSumBruteForce(int[] arr, int windowSize) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.length - windowSize; i++) {
            int currentSum = 0;
            for (int j = i; j < i + windowSize; j++) {
                currentSum += arr[j];
            }
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    /***
     * @param arr  subject array
     * @param windowSize subject window size
     * @return maximum sum
     * @complexity Time -> O(n), Space -> O(1)
     */
    public int maximumSumSlidingWindow(int[] arr, int windowSize) {
        int maxSum = Integer.MIN_VALUE,
                holdSum = 0,
                j = 0;

        for (int i = 0; i < arr.length; i++) {
            holdSum += arr[i];
            if (i - j == windowSize - 1) {
                maxSum = Math.max(holdSum, maxSum);
                holdSum -= arr[j++];
            }
        }

        return maxSum;
    }

    /***
     *
     * @param arr subject array
     * @param k window size
     * @return list of maximum in windows
     * @complexity Time -> O(n * k), Space -> O(1)
     */
    public List<Integer> maximumInSlidingWindowBruteForce(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - k; i++) {
            int currMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                currMax = Math.max(currMax, arr[j]);
            }
            result.add(currMax);
        }

        return result;
    }

    /***
     * @param arr subject array
     * @param k subject window size
     * @return list of maximums per window
     * @complexity Time -> O(n), Space -> O(1)
     */
    public List<Integer> maximumInSlidingWindowOptimized(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int currMax = Integer.MIN_VALUE,
                left = 0;

        for (int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax, arr[i]);
            if (i - left == k - 1) {
                result.add(currMax);
                currMax = Integer.MIN_VALUE;
                left++;
            }
        }

        return result;
    }


}