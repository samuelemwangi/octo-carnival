package library.sorting;

public class MergeSort {
    public void sort(int[] arr) {
        sortRecursive(arr, 0, arr.length - 1);
    }

    /***
     * @param arr array to sort
     * @param start index to start
     * @param end end index
     * @complexity
     * Time complexity -  O(n log n) -> n equals array length -
     * Space complexity - O(n) -> we make stack calls o each number
     */
    public void sortRecursive(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortRecursive(arr, start, mid);
            sortRecursive(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }


    private void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end)
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];


        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= end)
            temp[k++] = arr[j++];

        // copy phase
        for (i = start; i <= end; i++)
            arr[i] = temp[i - start];
    }
}
