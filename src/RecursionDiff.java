import java.util.Scanner;

public class RecursionDiff {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int choose;
        do {
            System.out.println("\nInput operation: " +
                    "\n1 Print n first numbers. " +
                    "\n2 Print numbers from A to B. " +
                    "\n3 Is number pow of 2? " +
                    "\n4 Sum of digits. " +
                    "\n5 Reverse number." +
                    "\n6 Number is simple? " +
                    "\n7 Simple dividers. " +
                    "\n8 Is palindrome? " +
                    "\n9 How many 1 " +
                    "\n10 How many = max? " +
                    "\n11 Triangle sequence. " +
                    "\n12 How many k-digit numbers with sum of digits = s? " +
                    "\n13 Reverse number ver2" +
                    "\nPrint 0 to quit.");
            choose = in.nextInt();
            switch (choose) {
                case 0 -> System.out.println("Goodbye!");
                case 1 -> {
                    System.out.println("1 -> n. Input number:");
                    int n = in.nextInt();
                    printFirstN(n);
                }
                case 2 -> {
                    System.out.println("A -> B. Input number A:");
                    int a = in.nextInt();
                    System.out.println("A -> B. Input number B:");
                    int b = in.nextInt();
                    printFromAToB(a,b);
                }
                case 3 -> {
                    System.out.println("Pow(2). Input number:");
                    int num = in.nextInt();
                    if (isPowTwo(num,1)) System.out.println("yes");
                    else System.out.println("no");
                }
                case 4 -> {
                    System.out.println("Digit sum. Input number:");
                    int num = in.nextInt();
                    System.out.println(digitSum(num));
                }
                case 5 -> {
                    System.out.println("Rev num. Input number:");
                    int num = in.nextInt();
                    reverseNumber(num);
                }
                case 6 -> {
                    int num;
                    do {
                        System.out.println("Simple. Input number (n>1):");
                        num = in.nextInt();
                    } while (num<=1);
                    System.out.println(isSimple(num,2) ? "yes":"no");
                }
                case 7 -> {
                    System.out.println("Simp div. Input number:");
                    int num = in.nextInt();
                    simpleDividers(num);
                }
                case 8 -> {
                    System.out.println("Palindrome. Input word:");
                    String word = in.next();
                    String [] letters = word.split("");
                    System.out.println(isPalindrome(letters,0, letters.length-1)?"yes":"no");
                }
                case 9 -> {
                    System.out.println("Input 0 or 1 then enter. After 0 0 counting is over or input another number to stop.");
                    System.out.println(howMany1());
                }
                case 10 -> {
                    System.out.println("Input every number in the next line. Finish with 0.");
                    howManyMax (0,0);
                }
                case 11 -> {
                    System.out.println("Triangle sequence: 1,2,2,3,3,3,4,4,4,4... Input n (first n terms):");
                    int n = in.nextInt();
                    triangleSequence (n,1,0);
                }
                case 12 -> {
                    System.out.println("Input digit number:");
                    int s,k=in.nextInt();
                    System.out.println("Input sum:");
                    s = in.nextInt();
                    System.out.println(howManyKNumSum(k,s,0,0));
                }
                case 13 -> {
                    System.out.println("Input number:");
                    int n = in.nextInt();
                    System.out.println(revNumToNum(n));
                }

                default -> System.out.println("Wrong number");
            }
        } while (choose!=0);
    }
    static void printFirstN(int n) { //1 обратная печать массива
        if (n>1) printFirstN(n-1);
        System.out.print(n+" ");
    }
    static void printFromAToB (int a,int b) {//2 печать цифр от А до В
        if (b>a) printFromAToB(a, b-1);
        System.out.print(b+" ");
    }
    static boolean isPowTwo (int n,int t) {//3 вычисляет, степень ли двойки число. t=1
        if (n==1) return true;
        t = t*2;
        if (n>t) return isPowTwo(n,t);
        else return n == t;
    }
    static int digitSum (int n) { //4 сумма цифр числа
        if (n==0) return 0;
        else return n%10+digitSum(n/10);
    }
    static void reverseNumber (int n) { //5 инвертирует число
        if (n!=0) {
            System.out.print(n%10);
            reverseNumber(n/10);
        }
    }
    static boolean isSimple (int n, int div) { //6 проверяет, простое ли число.В div передаем 2
        if (div==n) return true;
        if (n%div==0) return false;
        else return isSimple(n,++div);
    }
    static void simpleDividers (int n) { //7 найти простые делители числа в порядке неубывания с учетом кратности
        if (n>1)
            for (int i = 2; i <= n; i++) {
            if ((n%i==0)&&(isSimple(i,2))){
                System.out.print(i+" ");
                simpleDividers(n/i);
                break;
            }
        }
    }
    static boolean isPalindrome (String[] letters, int left, int right) { //8 является ли число палиндромом
        if (left<right) {
            if (!letters[left].equals(letters[right])) return false;
            else return isPalindrome(letters,++left,--right);
        }
        return true;
    }
    static int howMany1 () { //считает количество 1, пока не будет 0 0
        int sum,n,flag=0;
        n = in.nextInt();
        switch (n) {
            case 1 -> sum=1;
            case 0 -> {
                sum=0;
                flag=1;
            }
            default -> {
                return 0;
            }
        }
        n = in.nextInt();
        switch (n) {
            case 1 -> sum+=1;
            case 0 -> flag+=1;
            default -> {
                return 0;
            }
        }
        if (flag<2) {
            sum += howMany1();
            return sum;
        }
        else return 0;
    }
    static void howManyMax (int max, int count) { //количество чисел == максимуму
        int n = in.nextInt();
        if (n!=0) {
            if (n>max) howManyMax(n,1);
            else if (n==max) howManyMax(max,++count);
            else howManyMax(max,count);
        }
        else System.out.println(count);
    }
    static void triangleSequence (int n,int number, int count) { //первые n членов треугольной последовательности
        for (int i = 0; i < number; i++) {
            if (count<n) {
                count++;
                System.out.print(number+" ");
            }
            else break;
        }
        if (count<n) {
            triangleSequence(n,++number,count);
        }
    }
    static int howManyKNumSum(int digitsNumber, int digitSum, int realSum, int countDigit) {
        int n = 0; //number true sums
        countDigit++;
        for (int i = (countDigit==1)?1:0; i <= 9; i++) {
            if (countDigit==digitsNumber&&realSum+i==digitSum) n++;
            if (countDigit<digitsNumber) n += howManyKNumSum(digitsNumber,digitSum,realSum+i,countDigit);
        }
        return n;
    }
    static int revNumToNum (int n) {
        int k = 1; //number of digits
        int m = n;
        while (m/10!=0) {
            k*=10;
            m/=10;
        }
        if (k==1) return n;
        else return (n%10)*k+revNumToNum(n/10);
    }
}
