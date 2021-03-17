package Lesson3;

import java.util.*;

public class Execution {
    public static void main(String[] args) {

        // 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать сколько раз встречается каждое слово.
        String[] words = {
                "заходить","должностной","эпоха","электрический","буржуазный",
                "слышать","подняться","заговорить","коллективный","шумный",
                "неверный","максимальный","личный","подняться","плоский","альтернативный",
                "плоский","слышать","запасной","плоский"};
        System.out.println("total Words: "+words.length);
        Map<String,Integer> wordsMap = createMap(words);

        /////////////////display result 1.
        wordsMap.entrySet().forEach(System.out::println);
        System.out.println("total Unique words: "+wordsMap.size());


        ///////////////////display result 2
        Telephony telBook = new Telephony();
        telBook.add("Иванов",1111);
        telBook.add("Иванов",2222);
        telBook.add("Сидоров",3333);
        telBook.add("Петров",5555);
        telBook.add("Чернигов",6666);
        telBook.add("Компотов",4444);
        System.out.println(telBook.get("Иванов"));
        System.out.println(telBook.get("Цаплин"));


    }

    public static Map<String,Integer> createMap(String[] array){
        Map<String,Integer> wordsMap = new HashMap<>();
        int value;
        boolean exists;
        for (String s: array){
            exists = wordsMap.containsKey(s);
            value = exists? (wordsMap.get(s)+1):1;
            wordsMap.put(s,value);
        }
        return wordsMap;
    }
}
