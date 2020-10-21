import java.util.Arrays;
import java.util.Scanner;
//инвертирует массив
public class RecursionChangeArray {
    public static void main(String[] args) {
        System.out.println("Input array: 1 2 3...");
        int[] array = createArray();
        System.out.println(Arrays.toString(reverse(array, array.length)));
    }
    static int[] createArray () {
        String[] stringArr = new Scanner(System.in).nextLine().split(" ");
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            intArr[i]=Integer.parseInt(stringArr[i]);
        }
        return intArr;
    }
    static int[] reverse (int[] arr,int n) {
        int t;
        for (int i = 0; i < n-1; i++) {
            t=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=t;
        }
        n--;
        if (n>1) reverse(arr, n);
        return arr;
    }
}
