import java.util.Arrays;
/*Born a misinterpretation of this kata, your task here is pretty simple: given an array of values and an amount of beggars, you are supposed to return an array with the sum of what each beggar brings home, assuming they all take regular turns, from the first to the last.

For example: [1,2,3,4,5] for 2 beggars will return a result of [9,6], as the first one takes [1,3,5], the second collects [2,4].

The same array with 3 beggars would have in turn have produced a better out come for the second beggar: [5,7,3], as they will respectively take [1,4], [2,5] and [3].

Also note that not all beggars have to take the same amount of "offers", meaning that the length of the array is not necessarily a multiple of n; length can be even shorter, in which case the last beggars will of course take nothing (0).*/
public class EnglishBeggars {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(beggarsMySolution(new int[]{1,2,3,4,5}, 3)));
        System.out.println(Arrays.toString(beggarsRightSolution(new int[]{1,2,3,4,5}, 3)));
    }
    public static int[] beggarsMySolution(int[] values, int n) { //solution using recursion
        if (n==0) return new int[0];
        int[] values2 = Arrays.copyOf(values,values.length);
        int length = values2.length; //длина входного
        int [] begArray;
        int [] takenIndexes;
        if (n==1) { //последний бомж забирает остатки
            begArray = Arrays.copyOf(values2,values2.length);
            takenIndexes = new int[0];
        } else {
            begArray = new int[(length%n==0) ? length/n : length/n+1]; //массив n-го бомжа
            takenIndexes = new int[begArray.length];
            for (int i = 0; i < begArray.length; i++) { //заполняем нужными элементами
                begArray[i] = values2[n * i];
                values2[n * i] = 0;
                takenIndexes[i] = n*i;
            }
        }
        System.out.println("n="+n+Arrays.toString(begArray));
        int sum = 0;
        for (int i : begArray) {
            sum += i;
        } //посчитали сумму для n-го бомжа
        int[] result = new int [n];
        result[0]=sum; //записали в результирующий массив n-го бомжа
        if (n > 1) {
            int[] newValues;
            newValues = moveToLeft(values2, takenIndexes); //генерация нового массива из остатка
            System.arraycopy(beggarsMySolution(newValues, n - 1), 0, result, 1, n - 1); //копируемрезультаты остальных бомжей в результ. массив
        }
        return result;
    }
    static int [] moveToLeft (int[] array, int[] indexes) {
        int [] result = new int[array.length- indexes.length];
        if (indexes.length==0) return array;
        for (int i = 0, j=0, k=0; i <array.length ; i++) {
            if (indexes[j]==i)
                {if (j<indexes.length-1) j++;}
            else {
                result[k]=array[i];
                if (k< result.length-1) k++;
            }
        }
        return result;
    }
    public static int[] beggarsRightSolution(int[] values, int n) {
        int[] result;

        if (n < 1) {//return empty array
            result = new int[0];
        } else {
            result = new int[n];
            for (int i = 0; i < values.length; i++) {

                // add value to currently queued element
                result[i % n] += values[i];
            }
        }

        return result;
    }

}
