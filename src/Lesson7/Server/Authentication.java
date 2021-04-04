package Lesson7.Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * не знаю по какой причине, я решил захэшировать пароли в файле.
 * но так как нужно же проверять работоспособность - выложу их тут.
 * p1 p2 p3 p4 p5
 */
public class Authentication {
    private final static File passwd = new File("src\\Lesson7\\Server\\passwd");

    public static Optional<User> findUserByLoginPassword(String login, String password){
        try {
            //запускаю поиск данных по файлу
            Scanner reader = new Scanner(passwd);
            String[] userLine;
            //выполнять поиск, до конца файла
            while (reader.hasNextLine()){
                userLine = reader.nextLine().split("\\s");
                //предикат и возврат искомого
                if (userLine[0].equals(login) && userLine[1].equals(String.valueOf(password.hashCode()))){
                    return Optional.of(new User(userLine));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
