package dz3;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        makeRecord();
    }

    public static void makeRecord() {
        System.out.println(
                "Введите фамилию, имя, отчество, дату рождения(в формате dd.mm.yyyy), номер телефона(число без разделителей) и пол(f или m), разделенные пробелом");

        Scanner console = new Scanner(System.in);
        String user = console.nextLine();
        String[] array = user.split(" ");
        lengthArray(array);

        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];
        String birthdate = array[3];
        String phoneStr = array[4];
        String sex = array[5];

        CheckDate(birthdate);
        CheckPhone(phoneStr);
        CheckSex(sex);

        try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
            writer.write(
                    surname + " " +
                            name + " " +
                            patronymic + " " +
                            birthdate + " " +
                            phoneStr + " " +
                            sex);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void lengthArray(String[] arr) {
        try {
            if (arr.length != 6)
                throw new Exception("Введено неверное количество параметров");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CheckDate(String birthdate) {
        String[] date = birthdate.split("\\.");

        try {
            if ((date.length != 3 || date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4)
                    && (isInteger(date[0]) && isInteger(date[1]) && isInteger(date[2])))
                throw new RuntimeException("Некорретная дата");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void CheckPhone(String phoneStr) {
        int phone = 0;
        try {
            phone = Integer.parseInt(phoneStr);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат телефона");
        }
    }

    public static void CheckSex(String sex) {
        try {
            if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")) {
                throw new RuntimeException("Неверно введен пол");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

}