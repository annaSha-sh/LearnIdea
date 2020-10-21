import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Дано два списка строками с целыми числами через пробел. Необходимо вывести уникальные элементы(1 раз - 1 элемент),
которые присутствуют и в первом и во втором списке. Элементы необходимо вывести в порядке возрастания.
 Гарантируется что хотя бы 1 одинаковый элемент в списках есть.

 Sample Input 1:
1 2 3 4 5 6 7 8 9 10
7 8 1 1 1 11 1 1 1 11 1 1 11 1 1 1

Sample Output 1:
1 7 8 */
public class ArrayListFindNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (String r:in.nextLine().split(" ")) list1.add(Integer.parseInt(r)); //заполнили списки числами из строк
        for (String r:in.nextLine().split(" ")) list2.add(Integer.parseInt(r));
        compare:
        for (int i:list1) {
            for (int j:result) if (i==j) continue compare;
            for (int k:list2) {
                if (i==k) {
                    result.add(i);
                    continue compare;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.toString().replaceAll("[\\[]|[,]|[]]",""));
    }
}
