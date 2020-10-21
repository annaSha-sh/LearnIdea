import java.util.Scanner;

/* Дана строка. Из данной строки необходимо сделать палиндром следующим образом:

Необходимо сделать из данной строки палиндром минимально возможной длины.

Например: abcb -> abcba, aaa -> aaa, a -> a, abcded -> abcdedcba*/
public class Palindrom {
    public static void main(String[] args) {
        String forward = new Scanner(System.in).nextLine();
        String backward = new StringBuilder(forward).reverse().toString();
        int n = forward.length();
        if (n==1) System.out.println(forward);
        else {
            for (int i = 0; i < n ; i++) {
                if (forward.regionMatches(i,backward,0,n-i)) {
                    System.out.println(forward+backward.substring(n-i));
                    break;
                }
            }
        }
    }
}
