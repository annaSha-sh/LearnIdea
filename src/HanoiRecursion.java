import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HanoiRecursion {
    public static void main(String[] args) {
        System.out.println("Input number of elements:");
        int n = new Scanner(System.in).nextInt();
        var Hanoi3 = new Hanoi(n);
        Hanoi3.print();
        Hanoi3.move();
    }
}
class Hanoi {
    List<Integer> s1, s2, s3;   //number of stick
    int n;  //elements number
    Hanoi (int numberOfElements) {  //create 3 arrays with elements in first s1 like [3,2,1] [0,0,0] [0,0,0]
        n = numberOfElements;
        s1 = new ArrayList<>();
        for (int i = 0, m = n; i < n; i++, m--) {
            s1.add(m);
        }
        s2 = new ArrayList<>();
        s3 = new ArrayList<>();
    }
    void print () { //print arrays like tower
        for (int i = n-1; i>=0; i--) {
            if (i>s1.size()-1) System.out.print("|\t");
            else System.out.print((s1.get(i)==0)?"|\t":s1.get(i)+"\t");
            if (i>s2.size()-1) System.out.print("|\t");
            else System.out.print((s2.get(i)==0)?"|\t":s2.get(i)+"\t");
            if (i>s3.size()-1) System.out.print("|\t");
            else System.out.print((s3.get(i)==0)?"|\t":s3.get(i)+"\t");
            System.out.println();
        }
        System.out.println();

    }
    void move () {
        recursionMove(n, s1, s2, s3);
    }
    private void recursionMove (int num, List<Integer> stickFrom, List<Integer> stickBuf, List<Integer> stickTo) {
        if (num==1) {
            stickTo.add(stickFrom.get(stickFrom.size()-1));
            stickFrom.remove(stickFrom.size()-1);
            print();
        }
        else {
            recursionMove(num-1,stickFrom,stickTo,stickBuf);
            stickTo.add(stickFrom.get(stickFrom.size()-1));
            stickFrom.remove(stickFrom.size()-1);
            print();
            recursionMove(num-1,stickBuf,stickFrom,stickTo);
        }
    }
}
