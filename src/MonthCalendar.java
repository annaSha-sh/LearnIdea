import java.time.LocalDate;
import java.util.Date;

public class MonthCalendar {
    public static void main(String[] args) {
        System.out.println(new Date());
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        date = date.minusDays(day-1);
        int week = date.getDayOfWeek().getValue();
        System.out.println("Пн. Вт. Ср. Чт. Пт. Сб. Вс.");
        for (int i = 0; i < week; i++) {
            System.out.print("  ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth()==day) System.out.print("*");
            else System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue()==1) System.out.println();
        }
    }
}
