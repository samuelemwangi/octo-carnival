package library.array;

import java.util.HashSet;

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
}
