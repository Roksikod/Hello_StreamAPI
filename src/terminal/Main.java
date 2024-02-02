package terminal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static javax.security.auth.callback.ConfirmationCallback.NO;

/*
В методах СТРИМ АПИ если метод возвращает поток, он НЕ является терминальным (завершающим)
 */
public class Main {
    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.add(new User("John", 15));
        users.add(new User("Rita", 32));
        users.add(new User("Robert", 25));
        users.add(new User("Inga", 49));
        users.add(new User("Karana", 51));
        /*
        Нигде не приходится собирать поток назад в колекцию,
        потому что все возвращаемые методы СТРИМ АПИ являются терминальными
         */
        long count = users.stream()
                .filter(user -> user.getAge() > 35)
                .count();
        System.out.println(count);

        boolean isPossible1 = users.stream()
                .allMatch(user -> user.getAge() > 18); //для всех true
        System.out.println(isPossible1 == true ? "YES" : "NO");

        boolean isPossible2 = users.stream()
                .anyMatch((user -> user.getAge() > 18)); //хотя бы для одного true
        System.out.println(isPossible2 == true ? "YES" : "NO");

        boolean isPossible3 = users.stream()
                .noneMatch((user -> user.getAge() <= 18)); //хотя бы для одного false
        System.out.println(isPossible3 == true ? "YES" : "NO");

        List<User> threeOldMen = users.stream()
                .sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))
                .limit(3)
                .collect(Collectors.toList());
        for (User user: threeOldMen) {
            System.out.println(user.getName());
        }

        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);

    }
}
