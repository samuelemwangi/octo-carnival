package library.array;

public class GeneralArrayChallenges {
    public int missingNumberInGivenArray(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length + 1; i++)
            sum += i;

        int arrSum = 0;

        for (int j : arr)
            arrSum += j;

        return sum - arrSum;
    }
}
