//сумма n первых элементов массива
import java.util.Scanner;

public class RecursionArraySum {
    public static void main(String[] args) {
        System.out.println("Input array: 1 2 3...");
        int[] array = createArray();
        System.out.println("Input number of elements:");
        int n = new Scanner(System.in).nextInt();
        System.out.println(sum(array,n));
    }
    public static int[] createArray () {
        String[] arr = new Scanner(System.in).nextLine().split(" ");
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i]=Integer.parseInt(arr[i]);
        }
        return intArr;
    }
    public static int sum (int[] arr, int n) {
        if (n==0) return 0;
        return arr[n-1] + sum(arr, n-1);
    }
}
