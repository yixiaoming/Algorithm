package practice.array;

import practice.utils.Utils;

import java.util.Arrays;

/**
 * Created by Administrator on 19.10.7.
 * 给定一个数组，小和表示从一个数开始，其左边所有比它小的数之和。
 * 求要给数组的小和
 * <p>
 * 例子：practice.arr=[4, 5, 1, 2, 6]
 * 4的小和：0
 * 5的小和：4
 * 1的小和：0
 * 2的小和：1
 * 6的小和：12
 * 数组的小和：17
 */
public class ArrSmallSum {

    public static void main(String[] args) {
        int[] arr = Utils.createIntArr(10, 10);
        System.out.println(Arrays.toString(arr));
        System.out.println(smallSum(arr));
        check(arr);
    }

    private static void check(int[] arr) {
        int[] arr1 = Utils.copyIntArr(arr);
        int[] arr2 = Utils.copyIntArr(arr);
        System.out.println(rightMethod(arr1) == smallSum(arr2));
    }

    private static int rightMethod(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                result += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return result;
    }

    private static int smallSum(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }
        return processSmallSum(arr, 0, arr.length - 1);
    }

    private static int processSmallSum(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = (L + R) / 2;
        int leftSmallSum = processSmallSum(arr, L, mid);
        int rightSmallSum = processSmallSum(arr, mid + 1, R);
        int mergeSmallSum = mergeSmallSum(arr, L, mid, R);

        return leftSmallSum + rightSmallSum + mergeSmallSum;
    }

    private static int mergeSmallSum(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = L;
        int j = mid + 1;
        int k = 0;
        int result = 0;

        while (i <= mid && j <= R) {
            result += arr[i] < arr[j] ? arr[i] * (R - j + 1) : 0;
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= R) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, L, R - L + 1);
        return result;
    }
}
