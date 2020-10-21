import java.util.Arrays;
import java.util.Scanner;

/*Дано слово состоящее из букв в любом регистре. Необходимо вывести на экран таблицу в соответствии с примером:
Пусть слово = "abcde", тогда таблица должна быть вот такой -
a b c d e
b 0 0 0 d
c 0 0 0 c
d 0 0 0 b
e d c b a
Где пустое пространство заполняется нулями!
Расстояние между буквами на выводе - 1 пробел
 Sample Input 1:
abcde
Sample Output 1:
a b c d e
b 0 0 0 d
c 0 0 0 c
d 0 0 0 b
e d c b a*/
public class WordAroundTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] word = in.nextLine().split(""); //получили массив символов из слова
        for (int i = 0; i < word.length; i++) { //цикл по строкам
            for (int j = 0; j < word.length ; j++) { //цикл по буквам в строке
                if (i==0) System.out.print(word[j]+" "); //первая строка
                else if (i== word.length-1) System.out.print(word[word.length-1-j]+" "); //последняя строка
                else {  //остальные строки
                    System.out.print(word[i]+" "); //первая буква
                    for (int k = 0; k < word.length-2; k++) System.out.print("0 "); //заполнение нулями
                    System.out.print(word[word.length-1-i]+" "); //последняя буква
                    break; //переход к следующей строке
                }
            }
            System.out.println();
        }
    }
}
