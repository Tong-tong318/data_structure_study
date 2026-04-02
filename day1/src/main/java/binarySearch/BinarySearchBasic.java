package binarySearch;

public class BinarySearchBasic {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            if(arr[mid] < target){
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    public static int binarySearchLeft(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
