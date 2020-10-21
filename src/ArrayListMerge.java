import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Даны два списка. Необходимо слить два списка в один, отсортировать по убыванию и вывести.

Вводится целое число N и N чисел со следующей строки, потом целое число M и М чисел со следующей строки.*/
public class ArrayListMerge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0;i<n;i++) list.add(in.nextInt());
        int m = in.nextInt();
        for (int i = 0;i<m;i++) list.add(in.nextInt());
        Collections.sort(list);
        Collections.reverse(list);
        for (int i:list) {
            System.out.print(i+" ");
        }
    }
}
