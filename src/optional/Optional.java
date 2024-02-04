package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Optional {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 35));
        users.add(new User("Liks", 24));
        users.add(new User("Olga", 56));
        users.add(new User("Kreol", 84));
        users.add(new User("Lion", 54));
        users.add(new User("Opra", 67));
        users.add(new User("Rita", 16));

        users.stream()
                .filter(user -> user.getName().contains("l"))
                .findFirst() //вернет первый элемент в потоке, а findAny - первый любой (необязательно первый)
                .ifPresentOrElse(System.out::println, () -> System.out.println("User not found"));


    /*
    Создание стримов Параллел или Стрим
     */

        List<Float> numbers = new ArrayList<>();
        for (int i = 0; i < 30_000_000; i++) {
            numbers.add((float) i);
        }
        long before = System.currentTimeMillis();
        numbers.parallelStream()
                .map((number) -> Math.sin(0.2f + number / 5) * Math.cos(0.2f + number / 5) * Math.cos(0.4f + number / 2))
                .collect(Collectors.toList());
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
