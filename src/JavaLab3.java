import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class JavaLab3 {
    public static void main(String[] args){
        main_cycle:while (true) {
            System.out.println("Введите ФИО или STOP:");
            Scanner in = new Scanner(System.in);
            String firstName = in.next();
            if (firstName.equals("STOP")) break main_cycle;
            String secondName = in.next();
            if (secondName.equals("STOP")) break main_cycle;
            String patronymic = in.next();
            if (patronymic.equals("STOP")) break main_cycle;
            System.out.println("Введите дату рождения в формате гггг-мм-дд или STOP:");
            LocalDate birthDate = null;
            while (birthDate == null) {
                try {
                    String d = in.next();
                    if (d.equals("STOP")) break main_cycle;
                    birthDate = LocalDate.parse(d);
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверный формат ввода даты рождения. Попробуйте снова в формате гггг-мм-дд или STOP:");
                }
            }

            System.out.printf("%s %c.%c.\n", firstName, secondName.charAt(0), patronymic.charAt(0));

            System.out.print("Пол: ");
            if (patronymic.endsWith("а")) {
                System.out.println("Ж");
            } else if (patronymic.endsWith("ч")) {
                System.out.println("М");
            } else {
                System.out.println("Неизвестен");
            }

            System.out.print("Возраст: ");
            Period age = Period.between(birthDate, LocalDate.now());
            System.out.printf("%d лет, %d месяцев, %d дней\n", age.getYears(), age.getMonths() % 12, age.getDays() % 31 + 1);
        }
    }
}
