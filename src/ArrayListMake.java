/*Существует ряд методов для класса ArrayList: add(n) - вставка в конец, add(i, n) - вставка по индексу, remove(i) - удаление по индексу, set(i, n) - изменение значения по индексу.

На вход программе подаются строки, первая из которых create N - создает исходный список с числами от 1 до N включительно. Сигнатуры остальных команд:

add 5 - вставляет 5 в конец списка

add 5 6 - вставляет 6 по индексу 5

remove 7 - удаляет 7 элемент списка

set 7 3 - заменяет значение седьмого элемента списка на 3

Команда printList - сигнализирует о конце ввода данных и должна вывести на экран список, полученный после всех манипуляций */

import java.util.*;

public class  ArrayListMake {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String create;
		compare:
		while (true) { //ввод длины массива с проверкой
			System.out.println("Print \"Create N\" to make array:");
			create = in.nextLine(); //ввод данных
			if (create.length() <= 7) { //проверка длины первого слова
				System.out.println("Try again");
				continue;
			}
			if (create.substring(0, 7).equalsIgnoreCase("create ")) //проверка слова на валидность
				for (int i = 7; i < create.length(); i++) //проверка, число ли стоит после create
					if (!Character.isDigit(create.charAt(i)))
						continue compare;
			break;
		}
		int n = new Scanner(create.substring(7)).nextInt(); //забираем из строки Create N число
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) list.add(i); //создаем массив
		System.out.println(list.toString()); //УБРАТЬ вывод массива
		choose:
		while (true) {
			String command = in.nextLine(); //получили команду command
			Scanner comm = new Scanner(command);
			String word = comm.next(); //взяли первое слово word из команды
			switch (word) {
				case "printList": break choose; //выход
				case "add": //добавить элемент
					int ind = comm.nextInt();
					if (comm.hasNextInt()) list.add(ind,comm.nextInt());
					else list.add(ind);
					break;
				case "remove": //удалить
					list.remove(comm.nextInt());
					break ;
				case "set": //заменить
					list.set(comm.nextInt(),comm.nextInt());
					break;
				default: //неверный ввод
					System.out.println("Try again");
			}
			System.out.println(list.toString());
		}
		System.out.println(list.toString().replaceAll("[\\[]|[,]|[]]",""));
	}
}