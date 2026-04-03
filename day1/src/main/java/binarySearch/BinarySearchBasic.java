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

    public static int binarySearch2(int[] arr, int target){
        return binarySearch2Private(arr, target, 0, arr.length-1);
    }
    private static int binarySearch2Private(int[] arr, int target, int low, int high){
        int mid;
        int index;
        if (low <= high){
            mid = (low + high) >> 1;
        }else {
            return -1;
        }

        if (target < arr[mid]){
            index = binarySearch2Private(arr, target, low, mid-1);
        } else if (target > arr[mid]) {
            index = binarySearch2Private(arr, target, mid+1, high);
        } else {
            index = mid;
        }
        return index;
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
