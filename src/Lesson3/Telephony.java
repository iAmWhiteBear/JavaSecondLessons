package Lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class Telephony {
    private final Map<Integer,String> telephony;

    public Telephony() {
        telephony = new HashMap<>();
    }

    public void add(String name, Integer phoneNum){
        telephony.put(phoneNum,name);
    }

    public String get(String name){
        StringBuilder names = new StringBuilder();

        for (Map.Entry<Integer,String> entry: telephony.entrySet()){
            if (entry.getValue().equals(name)){
                names.append(entry.getKey());
                names.append("\n");
            }
        }
        if (names.length()==0){
            names.append(String.format("номеров по фамилии %s нет %n",name));
        }else {
            names.insert(0,String.format("по фамилии %s такие номера: %n", name ));
        }
        return names.toString();
    }






}
