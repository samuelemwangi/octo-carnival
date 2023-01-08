package library.array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneralArrayChallengesTest {

    @Test
    public void testMissingNumberInGivenArray(){
        int[] arr =  {3,7,1,2,8,4,5};
        GeneralArrayChallenges challenges =  new GeneralArrayChallenges();

        Assert.assertEquals(challenges.missingNumberInGivenArray(arr), 6);
    }
}
