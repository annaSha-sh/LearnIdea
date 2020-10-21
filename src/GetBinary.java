import java.util.ArrayList;
import java.util.Scanner;

public class GetBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            System.out.println("Number:");
            int num = in.nextInt();
            Binary b = new Binary();
            b.make(num);

    }
}
class Binary {
    int num;
    void make (int n) {
        num = n;
        ArrayList<String> bin = new ArrayList<>();
        while (n>1) {
            bin.add(Integer.toString(n%2));
            n/=2;
        }
        bin.add(Integer.toString(n));
        for (int i = bin.size()-1; i>=0 ; i--) {
            System.out.print(bin.get(i));
        }
        System.out.println();
    }
}