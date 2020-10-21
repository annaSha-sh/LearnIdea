import java.util.Arrays;
import java.util.Scanner;
// 1 2 3 4 5 6
// 0 0 0 0 0 0
public class RecursionSortGo {
    public static void main(String[] args) {
        System.out.println("Input array:1 2 3 4...");
        int[] arrayNew = Array.create();
        System.out.println("Your array: "+Arrays.toString(arrayNew));
        Array.sort(arrayNew);
        System.out.println("Sorted: "+Arrays.toString(arrayNew));
    }
}
class Array {
    static int[] create () { //создает массив
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i]=Integer.parseInt(strArr[i]);
        }
        return arr; //возвращает массив целых чисел
    }
    private static boolean sortTest (int[] arr) {
        boolean flag = true; //проверка на отсортированность
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {flag=false; break;}
        }
        return flag;
    }
    static void sort (int[] arr) { //сортировка, на входе массив для сортировки
        //System.out.println("input arr:"+Arrays.toString(arr));
        int arrLength = arr.length; //длина массивов
        if (sortTest(arr)) {
            //System.out.println("enough");
            return;} //если массив уже сортирован, выход
        int[] sortedArr = new int[arrLength]; //пустой массив для сортировки
        int midInd = arrLength/2; //индекс опорного элемента
        int middle = arr[midInd]; //опорный элемент
        //System.out.println("middle:"+middle);
        //System.out.println("mid index:"+midInd);
        int a2i = 0, a2j = arrLength-1; //индекс первый и последний
        for (int i = 0; i < arrLength; i++) { //перемещаем влево меньшие элементы, вправо бОльшие
            if (i!=midInd) {
                if (arr[i]<middle) {
                    sortedArr[a2i]=arr[i];
                    a2i++;
                }
                else {
                    sortedArr[a2j]=arr[i];
                    a2j--;
                }
            }
        }
        sortedArr[a2i]=middle; //записываем опорный элемент на пустую позицию. sortedArr - левая часть меньше ОЭ правая - больше.
        //System.out.println("sort:"+Arrays.toString(sortedArr));
        //System.out.println("new midInd:"+a2i);

        if ((a2i>1)) { //если первая часть от двух элементов, знаит надо сортировать
            int[] firstPart = new int[a2i]; //доп массив, длиной до центрального элемента
            System.arraycopy(sortedArr,0,firstPart,0,a2i); //копируем первую половину в новый массив
           // System.out.println("firstPart:"+Arrays.toString(firstPart));
            Array.sort(firstPart); //сортировка первой половины
            System.arraycopy(firstPart ,0,sortedArr,0,a2i); //копируем сортированный массив обратно
        }
        if ((arrLength-a2i>2)) { //если вторая часть от двух элементов, знаит надо сортировать
            int[] secondPart = new int[arrLength-1-a2i]; //доп массив, длиной от центрального до конца
            System.arraycopy(sortedArr,a2i+1,secondPart,0,arrLength-a2i-1); //копируем вторую половину ПОСЛЕ центрального элемента
            //System.out.println("secondPart:"+Arrays.toString(secondPart));
            Array.sort(secondPart);
            System.arraycopy(secondPart,0,sortedArr,a2i+1,arrLength-1-a2i);
        }
        System.arraycopy(sortedArr, 0, arr, 0, arrLength); //копируем сортировку в основной
    }

}

