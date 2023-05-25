import java.util.HashMap;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

public class Task01 {

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");

        Scanner myInput = new Scanner(System.in);

        HashMap<String, String> myHashMap = new HashMap<>();
        System.out.println("Введите: \n*1 для добавления контакта \n*2 для печати списка \n*3 для добавления номера по фамилии \n*4 для выхода");
        int myChoise = myInput.nextInt();
        myInput.nextLine();

        while (myChoise != 4) {

            if (myChoise == 1) {
                myHashMap.put(PutName(myInput), PutNumber(myInput));
                System.out.println("Введите: \n*1 для добавления контакта \n*2 для печати списка \n*3 для добавления номера по фамилии \n*4 для выхода");
                myChoise = myInput.nextInt();
                myInput.nextLine();
            }
            if (myChoise == 2) {
                System.out.println(myHashMap);
                System.out.println("Введите: \n*1 для добавления контакта \n*2 для печати списка \n*3 для добавления номера по фамилии \n*4 для выхода");
                myChoise = myInput.nextInt();
                myInput.nextLine();
            }
            if (myChoise == 3) {
                AddNumber(myHashMap, myInput);
                System.out.println("Введите: \n*1 для добавления контакта \n*2 для печати списка \n*3 для добавления номера по фамилии \n*4 для выхода");
                myChoise = myInput.nextInt();
                myInput.nextLine();
            }
        }
        myInput.close();

    }

    public static String PutName(Scanner x) {

        System.out.println("Введите фамилию: ");
        String myName = x.nextLine();

        return myName;
    }

    public static String PutNumber(Scanner x) {

        System.out.println("Введите номер: ");
        String myNumber = x.nextLine();

        return myNumber;
    }

    public static void AddNumber(HashMap<String, String> myMap, Scanner x) {
        System.out.println("Введите фамилию: ");
        String mySearch = x.nextLine();
        
        for (var item : myMap.entrySet()) {
            if (item.getKey().equals(mySearch)) {
                System.out.println("Введите номер: ");
                String addedNumbed = x.nextLine();
                myMap.put(item.getKey(), item.getValue() + ", " + addedNumbed);
                System.out.println("Номер добавлен.");
            }
            else{
                System.out.println("Фамилия не найдена.");
            }
        }
    }
}