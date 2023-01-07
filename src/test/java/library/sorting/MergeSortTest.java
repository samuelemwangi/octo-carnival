package library.sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeSortTest {

    @Test
    public void testSort() {
        int[] arr = new int[]{1, 9, 2, 0, 78, -12};
        int[] expected  = new int[]{-12,0,1,2,9,78};

        MergeSort sorter =  new MergeSort();
        sorter.sort(arr);
        Assert.assertTrue(compareArrays(arr, expected));
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
