package binarySearch;

import org.junit.Assert;
import org.junit.Test;

import static binarySearch.BinarySearchBasic.binarySearch;
import static binarySearch.BinarySearchBasic.binarySearchLeft;


public class BinarySearchBasicTest {
    @Test
    public void binarySearchTest() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(5, binarySearch(arr, 6));
        Assert.assertEquals(-1, binarySearch(arr, 11));
        Assert.assertEquals(0, binarySearch(arr, 1));
        Assert.assertEquals(8, binarySearch(arr, 9));
    }

    @Test
    public void binarySearchLeftTest() {
        int[] arr = {1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(0, binarySearchLeft(arr, 1));
        Assert.assertEquals(1, binarySearchLeft(arr, 2));
        Assert.assertEquals(2, binarySearchLeft(arr, 3));
        Assert.assertEquals(30, binarySearchLeft(arr, 4));
        Assert.assertEquals(32, binarySearchLeft(arr, 5));
        Assert.assertEquals(33, binarySearchLeft(arr, 6));
        Assert.assertEquals(34, binarySearchLeft(arr, 7));
    }


}
