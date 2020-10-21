import java.util.Arrays;
import java.util.Scanner;

/* Создает очередь заданного размера, либо пустую, либо с заданными значениями.
Можно добавлять элементы в очередь, доставать из очереди (с разрушением) и смотреть результат */

class Queue { // очередь
    private final int[] que; //базовый массив
    int index; //индекс вставки = последней пустой позиции
    Queue (int size) { //создаем пустую очередь нужного размера
        que = new int[size];
        index = 0;
    }
    Queue (int size,int[] queDef) { //очередь нужного размера и задать исходные числа
        que = new int[size];
        System.arraycopy(queDef,0,que,0,queDef.length);
        index = 0;
    }
    int out() { //вытащить элемент из очереди
        if (index==0) return -1;
        int tmp = que[0];
        System.arraycopy(que, 1, que, 0, que.length - 1);
        index--;
        return tmp;
    }
    void in(int number) { //добавить в очередь
        if (err(index, que.length)) return;
        que[index]=number;
        index++;
    }
    void print() { //печать результата
        System.out.println(Arrays.toString(que));
    }
    boolean err(int a) { //обработка ошибки "вытащить из пустой очереди"
        if (a==-1) {System.out.println("Empty");
        return false;}
        else return true;
    }
    boolean err(int a,int b) { //обработка ошибки переполненя очереди
        if (a==b) {
            System.out.println("Full!");
            return true;
        }
        else return false;
    }
}
public class QueueDo {
    public static void main(String[] args) {
        System.out.println("in - add element; out - take element; print - see queue; anything else - quit\nInput dimension of queue:");
        Scanner in = new Scanner(System.in);
        int s = in.nextInt(); //ввод длины очереди
        System.out.println("Do you have default numbers? yes/no(anything)");
        String answer = in.next();
        Queue q;
        if (answer.equals("yes")) { //ввод дефолтных чисел
            System.out.println("How many numbers?");
            int n = in.nextInt(); //количество чисел
            int[] arrNum = new int[n]; //массив с дефолтными числами
            System.out.println("Write numbers:1 2 3...");
            for (int i = 0; i < n; i++) {
                arrNum[i]=Integer.parseInt(in.next());
            }
            q = new Queue(s,arrNum); //создали очереди длины s с заданными числами
            q.index = n; //установили индекс пустой позиции
        }
        else q = new Queue(s);
        System.out.print("Your queue is: ");
        q.print();
        System.out.println(" What do you want to do with it? (in/out/print)");
        while (true) {
            String say = in.next();
            switch (say) { //выбор варианта
                case "in": q.in(in.nextInt()); break;
                case "out":
                    int x = q.out();
                    if (q.err(x)) System.out.println(x); break;
                case "print": q.print(); break;
                default: return;
            }
        }
    }
}