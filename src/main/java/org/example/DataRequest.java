package org.example;

import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    // Методы для присваивания значения полям
    private void EnterFirstName() {
        System.out.println("Enter first name/Введите Имя: ");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым, \n повторите ввод");
        }
    }

    private void EnterLastName() {
        System.out.println("Enter last name/Введите Фамилию: ");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым, \n повторите ввод");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Enter middle name/Введите отчество: ");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым, \n повторите ввод");
        }
    }

    private void EnterYearOfBirth() {
        System.out.println("Enter year of birth dd.mm.yyyy/Введите дату рождения в формате дд.мм.гггг: ");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым, \n повторите ввод");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Enter number phone/Введите номер телефона: ");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое поле не может быть пустым, \n повторите ввод");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат ввода, повторите ввод");
        }
    }

    private void EnterGender() {
        System.out.println("Enter gender (f, m)/Введите пол f-женский, m - мужской:");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели много символов, \n попробуй снова");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Введен не верный символ");
        }
    }

    // Метод для вывода в консоль получившихся значений
    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n" + "Middle name \t- \t" + middleName + "\n" + "Year of birth \t- \t" + yearOfBirth + "\n" + "Number phone \t- \t" + numberPhone + "\n" + "Gender \t- \t" + gender );
    }

    // Метод для соединения всех методов в один
    private void DataEnter(){
        EnterLastName();
        EnterFirstName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    //Метод для сохранения данных в файл
    public void SaveDataEnter() {

        DataEnter();
        String file ="data/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file,true)) {
            fw.write("<" + lastName + ">" + "<" + firstName + ">" + "<" + middleName + ">" + "<" + yearOfBirth + ">" + "<" + numberPhone + ">" + "<" + gender + ">\n" );
        } catch (Exception e) {
            System.out.println("Есть проблемы в записи");
        }
    }
    // геттеры для полей
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }

}
