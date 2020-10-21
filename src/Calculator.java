import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("This is calculator!\n" +
                "input first number, " +
                "input + - / or *, " +
                "input another number. \n" +
                "Example:\"4 + 2\"\n" +
                "Input 'c' to clear result.\n" +
                "Input 'exit' to exit :)");
        Scanner in = new Scanner(System.in);
        bigLoop:
        while (true) {
            String str = in.nextLine();
            Scanner calc = new Scanner(str);
            double rez = calc.nextDouble(); //result
            while (true) {
                String oper = calc.next();
                if (oper.equals("exit")) break bigLoop;
                if (oper.equals("c")) break;
                double y = calc.nextDouble();
                switch (oper) {
                    case "+" -> rez += y;
                    case "-" -> rez -= y;
                    case "/" -> rez /= y;
                    case "*" -> rez *= y;
                }
                System.out.println(rez);
                str = in.nextLine();
                calc = new Scanner(str);
            }
        }
    }
}
