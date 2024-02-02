package terminal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("John", 15));
        users.add(new User("Rita", 32));
        users.add(new User("Robert", 25));
        users.add(new User("Inga", 49));
        users.add(new User("Karana", 51));

        users.stream()
                .sorted(Comparator.comparing(User::getName))  //(o1,o2)-> o1.getName().compareTo(o2.getName())
                .filter((user) -> user.getAge() < 40)
                .limit(3)
                .map(user -> user.getName())
                .forEach(System.out::println);

    }
}
