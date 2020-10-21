import java.util.Scanner;
//какая цифра будет последней у результата, вводим n
// (1)1 (2)1 (3)2 (4)3 (5)5 (6)8 (7)13 (8)21 (9)34
// 1    1   2   3   7
public class Fibona4iSmall {
    public static void main(String[] args) {
        while (!(new Scanner(System.in).nextLine().equals("q"))) {
            int n = new Scanner(System.in).nextInt();
            int x=0, y=1;
            boolean flag = false;
            for (int i = 2; i <= n; i++) {
                if (i%2==0) {x=(x+y)%10; flag=false;}
                else {y=(y+x)%10; flag=true;}
            }
            System.out.print(flag?y:x);
        }
    }
}
