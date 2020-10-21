import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*Даны три списка целых чисел строками через пробел.

Первая строка - первый список, вторая - второй, третья - третий.

Из первого списка нужно выбрать положительные элементы, из второго - четные, из третьего - кратные 7. Все выбранные элементы необходимо объединить в единый список и вывести его в порядке не убывания. */
public class ArrayList2 {
    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>(); //result набираем сюда
        ArrayList<Integer> input = new ArrayList<>(); //input введенная строка
        Scanner in = new Scanner(System.in);
        int count = 0; //счетчик рядов
        while (count < 3) { //проверить счетчик
            count++;
            input.clear();
            String row = in.nextLine();
            String[] inpArr = row.split(" ");
            for (String f : inpArr) {
                input.add(Integer.parseInt(f));
            }
            switch (count) {
                case 1:
                    for (int i : input) { //только положительные
                        if (i > 0) result.add(i);
                    }
                    break;
                case 2:
                    for (int i : input) { //только четные
                        if (i % 2 == 0) result.add(i);
                    }
                    break;
                case 3:
                    for (int i : input) { //кратные 7
                        if (i % 7 == 0) result.add(i);
                    }
                    break;
            }
        }
        Collections.sort(result);
        for (int i : result) System.out.print(i + " ");
    }
}
