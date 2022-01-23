package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        BirthdayList birthdayList = new BirthdayList();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        IO io = new IO();
        while (true) {
            System.out.println("Выберите необходимое действие:");
            System.out.println("1. Отображение всего списка ДР");
            System.out.println("2. Отображение списка сегодняшних и ближайших ДР");
            System.out.println("3. Добавление записей в список ДР");
            System.out.println("4. Удаление записей из списка ДР");
            System.out.println("5. Редактирование записей в списке ДР");
            System.out.println("6. Загрузить файл");
            System.out.println("7. Сохранить файл");
            System.out.println("8. Закончить работу программы");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    birthdayList.printAllRecords();
                    break;

                case 2:
                    birthdayList.printTodayAndNearRecords();
                    break;

                case 3:
                    birthdayList.addRecord();
                    break;

                case 4:
                    birthdayList.delRecord();
                    break;

                case 5:
                    birthdayList.editRecord();
                    break;

                case 6:
                    System.out.println("Введите путь к файлу, из которого необходимо загрузить записи");
                    birthdayList = io.readObject(input2.nextLine());
                    birthdayList.printAllRecords();
                    break;
                case 7:
                    System.out.println("Введите путь к файлу, в который необходимо сохранить записи");
                    String file = input2.nextLine();
                    io.writeObject(birthdayList, file);
                    break;

                case 8:
                    return;
            }
        }
    }
    }

