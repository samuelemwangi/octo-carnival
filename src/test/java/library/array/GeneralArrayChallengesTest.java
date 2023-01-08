package library.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GeneralArrayChallengesTest {

    @Test
    public void testMissingNumberInGivenArray() {
        int[] arr = {3, 7, 1, 2, 8, 4, 5};
        GeneralArrayChallenges challenges = new GeneralArrayChallenges();

        Assert.assertEquals(challenges.missingNumberInGivenArray(arr), 6);
    }

    @Test
    public void testTwoSum() {
        int[] arr = {5, 7, 1, 2, 8, 4, 3};
        GeneralArrayChallenges challenges = new GeneralArrayChallenges();

        int[] bruteForceResult1 = challenges.twoSumBruteForce(arr, 10);
        int[] bruteForceResult2 = challenges.twoSumBruteForce(arr, 19);

        Assert.assertEquals(bruteForceResult1[0] + bruteForceResult1[1], 10);
        Assert.assertTrue(bruteForceResult2[0] == -1 && bruteForceResult2[1] == -1);

        int[] twoSumExtraDSResult1 = challenges.twoSumExtraDS(arr, 10);
        int[] twoSumExtraDSResult2 = challenges.twoSumExtraDS(arr, 19);

        Assert.assertEquals(twoSumExtraDSResult1[0] + twoSumExtraDSResult1[1], 10);
        Assert.assertTrue(twoSumExtraDSResult2[0] == -1 && twoSumExtraDSResult2[1] == -1);
    }

    @Test
    public void testMaximumSum() {
        int[] arr = {2, 1, 5, 1, 3, 2, 0, 6};
        GeneralArrayChallenges challenges = new GeneralArrayChallenges();

        Assert.assertEquals(challenges.maximumSumBruteForce(arr, 3), 9);
        Assert.assertEquals(challenges.maximumSumBruteForce(arr, 1), 6);
        Assert.assertEquals(challenges.maximumSumBruteForce(arr, 4), 11);

        Assert.assertEquals(challenges.maximumSumSlidingWindow(arr, 3), 9);
        Assert.assertEquals(challenges.maximumSumSlidingWindow(arr, 1), 6);
        Assert.assertEquals(challenges.maximumSumSlidingWindow(arr, 4), 11);
    }

    @Test
    public void testMaximumInSlidingWindow() {
        int[] arr1 = {-4, 2, -5, 3, 6};
        int k1 = 3;
        int[] expectedRes1 = {2, 3, 6};

        GeneralArrayChallenges challenges = new GeneralArrayChallenges();

        List<Integer> actualRes1 = challenges.maximumInSlidingWindowBruteForce(arr1, k1);
        List<Integer> actualRes2 = challenges.maximumInSlidingWindowOptimized(arr1, k1);

        Assert.assertEquals(toIntArray(actualRes1), expectedRes1);
        Assert.assertEquals(toIntArray(actualRes2), expectedRes1);
    }


    @Test
    public void testMaximumToBuyAndSellStock() {
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        int[] arr2 = {7, 6, 4, 3, 1};

        GeneralArrayChallenges challenges = new GeneralArrayChallenges();

        Assert.assertEquals(challenges.maximumToBuyAndSellStockBruteForce(arr1), 5);
        Assert.assertEquals(challenges.maximumToBuyAndSellStockBruteForce(arr2), 0);

        Assert.assertEquals(challenges.maximumToBuyAndSellStockOptimized(arr1), 5);
        Assert.assertEquals(challenges.maximumToBuyAndSellStockOptimized(arr2), 0);
    }




    private int[] toIntArray(List<Integer> list) {
        int[] res = new int[list.size()];

        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }

    private boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
