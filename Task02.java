// Пусть дан список сотрудников:

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class Task02 {

    public static void main(String[] args) {
        HashMap<String, String> myMap = new HashMap<>();

        myMap.put("Иванов", "Иван");
        myMap.put("Петрова", "Светлана");
        myMap.put("Белова", "Кристина");
        myMap.put("Мусина", "Анна");
        myMap.put("Крутова", "Анна");
        myMap.put("Юрин", "Иван");
        myMap.put("Лыков", "Петр");
        myMap.put("Чернов", "Павел");
        myMap.put("Чернышов", "Петр");
        myMap.put("Федорова", "Мария");
        myMap.put("Светлова", "Марина");
        myMap.put("Савина", "Мария");
        myMap.put("Рыкова", "Мария");
        myMap.put("Лугова", "Марина");
        myMap.put("Владимирова", "Анна");
        myMap.put("Мечников", "Иван");
        myMap.put("Петин", "Петр");
        myMap.put("Ежов", "Иван");

        ListIterator<Map.Entry<String, String>> myIterator = new LinkedList<>(myMap.entrySet()).listIterator();
        HashMap<String, Integer> myList = new HashMap<>();
        while (myIterator.hasNext()) {
            String myString = myIterator.next().getValue();
            int counter = Collections.frequency(myMap.values(), myString);
            myList.put(myString, counter);
        }
        myList.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}
