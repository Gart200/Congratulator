package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BirthdayList {
    private List<Birthday> birthdays = new LinkedList<>();
    private Scanner scan1 = new Scanner(System.in);
    private Scanner scan2 = new Scanner(System.in);
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<Birthday> getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(List<Birthday> birthdays) {
        this.birthdays = birthdays;
    }

    void printAllRecords() {
        System.out.printf("%s%8s%15s%20s", "ID", "Имя", "Фамилия", "Дата рождения\n");
        for (Birthday bd : birthdays) {
            printRecord(bd);
        }
        System.out.println();
    }

    //Близкими считаются дни рождения, до которых осталось меньше 14 дней
    void printTodayAndNearRecords() {
        LocalDate currentDate = LocalDate.now();

        System.out.printf("%s%8s%15s%20s", "ID", "Имя", "Фамилия", "Дата рождения\n");
        for (Birthday bd : birthdays) {

            LocalDate ld = LocalDate.of(LocalDate.now().getYear(), bd.getDateOfBirth().getMonthValue(), bd.getDateOfBirth().getDayOfMonth());

            //День рождения в этом году уже прошёл, расчёт для следующего года
            if (ld.isBefore(currentDate)) {
                if (Period.between(ld.plusYears(1), currentDate).getDays() <= 14 )
                    printRecord(bd);
            }
            //День рождения сегодня
            else if (ld.isEqual(currentDate))
                printRecord(bd);

        }
        System.out.println();
    }

    boolean addRecord() {

        System.out.println("Введите id");
        int id = scan1.nextInt();

        if (getRecordById(id) != null) {
            System.out.println("Запись с таким id уже присутствует");
            return false;
        }

        System.out.println("Введите имя");
        String name = scan2.nextLine();
        System.out.println("Введите фамилию");
        String surname = scan2.nextLine();
        System.out.println("Введите дату рождения в формате дд-мм-гггг");
        LocalDate localDate = LocalDate.parse(scan2.nextLine(), dateFormat);

        if (birthdays.add(new Birthday(id, name, surname, localDate))) {
            System.out.println("Запись успешно добавлена");
            return true;
        }
        System.out.println("Запись не добавлена");
        return false;
    }

    boolean addRecord(Birthday birthday) {

        if (getRecordById(birthday.getId()) != null) {
            System.out.println("Запись с таким id уже присутствует");
            return false;
        }
        if (birthdays.add(birthday))
            return true;

        return false;
    }

    Birthday getRecordById(int id) {
        for (Birthday bd : birthdays) {
            if (bd.getId() == id) {
                return bd;
            }
        }
        return null;
    }

    boolean delRecord() {
        System.out.println("Введите id записи, которую необходимо удалить");
        int id = scan1.nextInt();
        Birthday bd;
        if ((bd = getRecordById(id)) != null) {
            birthdays.remove(bd);
            System.out.println("Запись успешно удалена");
            return true;
        }

        System.out.println("Запись не удалена");
        return false;
    }

    boolean editRecord() {
        System.out.println("Введите id записи, которую необходимо обновить");
        int id = scan1.nextInt();
        if (getRecordById(id) == null) {
            System.out.println("Запись с таким id не найдена");
            return false;
        }
        System.out.println("Введите новое имя");
        String name = scan2.nextLine();
        System.out.println("Введите новую фамилию");
        String surname = scan2.nextLine();
        System.out.println("Введите новую дату рождения в формате дд-мм-гггг");
        LocalDate localDate = LocalDate.parse(scan2.nextLine(), dateFormat);

        birthdays.set(birthdays.indexOf(getRecordById(id)), new Birthday(id, name, surname, localDate));
        System.out.println("Запись успешно обновлена");
        return true;
    }

    void printRecord(Birthday bd) {
        System.out.printf("%s%10s%14s%18s\n", bd.getId(), bd.getName(), bd.getSurname(), dateFormat.format(bd.getDateOfBirth()));
    }
}
