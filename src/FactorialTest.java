import java.util.Scanner;

class Factorial {
    boolean isFactorial (int x) {
        int y=1;
        int i=1;
        while (y<x){
            y*=++i;
        }
        return y == x;
    }

    int whatFactorial (int x) {
        int counter=1;
        int y=1;
        while (y<x){
            y*=++counter;
        }
        if (y == x) return counter;
        else return 0;
    }
}

public class FactorialTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Factorial test = new Factorial();
        if (num==1) System.out.println(num+" is factorial 1 or 0");
        else if (test.isFactorial(num)) System.out.println(num+" is factorial "+test.whatFactorial(num));
        else System.out.println("It's not factorial :(");
}
    }