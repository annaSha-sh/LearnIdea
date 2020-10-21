import java.util.Scanner;
// 1 2 3 4 5 6 7  n
// 0 1 1 2 3 5 8  f
//0 1 2 4 7 13 21 sum
public class TestGo {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println();
        System.out.println("rez="+TestGo.fuckRecursion(n));
        }

    static int fuckRecursion(int x) {
        System.out.print("inp:["+x+"] ");
        if (x==0) {
            System.out.println("(x=0)");
            return 0;}
        else if (x==1) {
            System.out.println("(x=1)");
            return 1;
        }
        else {
            System.out.println("x-1="+(x-1));
            int a = fuckRecursion(x - 1);
            //System.out.print("(x-1="+a+")");
            System.out.println("x-2="+(x-2));
            int b = fuckRecursion(x - 2);
            //System.out.print("(x-2="+b+")");
            int sum = a + b;
            //System.out.println("("+a+"+"+b+")");
            System.out.println("(sum="+sum+")");
            return sum;
        }

        }
}