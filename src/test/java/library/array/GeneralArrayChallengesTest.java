package library.array;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
