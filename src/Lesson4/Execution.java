package Lesson4;



import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Execution {
    public static void main(String[] args) {
        //Создать коллекцию типа List. Наполнить ее значениями
        // и вывести значения в консолько при помощи ее метода forEach.
        List<String> list = Arrays.asList("dado", "lolo", "pepe","kiki");
        list.forEach(System.out::println);

        //2
        // я знаю, о том, что идея предлагает преобразовать консьюмер в другое.
        //просто так нагляднее что именно делается.
        System.out.println("2---------------");
        Set<String> set = new HashSet<>(list);
        forItem(set,(s -> System.out.println(s)));

        //3
        System.out.println("3--------------------------");
        Supplier<Integer> sup = () -> 2;
        int x = doubleUp(15,sup);
        System.out.println(x);

        //4
        System.out.println("4--------------------------");
        Optional<String> test1 = findAllChars("asdfasdf",'f');
        Optional<String> test2 = findAllChars("asdasd",'f');
        Optional<String> opt = findAllChars("ccch", 'c');
        System.out.println(opt.get());
        System.out.println(test1.orElse("empty optional"));
        System.out.println(test2.orElse("empty optional"));


    }

    //Создать утилитарный метод forItem. Метод принимает два параметра:
    // Коллекция Set<String> и консьюмер типа Consumer<String>.
    // Внутри метода проитерироваться по коллекции и для каждого элемента выполнить метод консьюмера accept,
    // который выводит значение элемента в консоль.
    public static void forItem(Set<String> set, Consumer<String> consumer){
        for(String s: set){
            consumer.accept(s);
        }
    }

    //Создать утилитарный метод doubleUp.
    // Метод принимает два параметра: значение типа int и консьюмер типа Supplier<Integer>.
    // Внутри метода выполнить метод саплаера get,
    // который умножает переданное значение на два и возращает результат произведения.
    public static Integer doubleUp(int num, Supplier<Integer> sup){
        return sup.get()*num;
    }

    //Создать метод findAllChars. Метод принимает два параметра:
    // String target и char toFind.
    // Первый параметр является входной строкой, а второй - символ,
    // который необходимо найти в входящей строке.
    // Учесть что искомый символ может повторяется (напр.: 'ccch').
    // Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional.
    // Если ни одного совпадения не найдено, тогда необходимо вернуть пустой Optional.
    // Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".

    public static Optional<String> findAllChars(String target, char toFind){
        List<Character> charList = new ArrayList<>(); // создаю лист
        for (Character c: target.toCharArray())
            if (c == toFind) charList.add(c);    //добавляю все те, что подходят

        Optional<List<Character>> optList = Optional.of(charList);
        Optional<String> result = optList                                   //если в списке что-то есть -
                .filter(l -> l.size()>0)                                    //map конвертирует в строку
                .map(list -> {                                              //если нет - filter вернёт пустой Optional
                    StringBuilder sb = new StringBuilder();
                    for(Character c: list) sb.append(c);
                    return sb.toString();
                });

       return result;
    }
}
