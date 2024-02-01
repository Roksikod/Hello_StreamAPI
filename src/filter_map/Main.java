package filter_map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        /*
        Все операторы делятся на промежуточные (map, filter) и терминальные (collect)
         */
        List<String> list = numbers.stream()
                .filter((n) -> n % 2 == 0)
                .map((integer -> "Number: " + integer))
                .filter((string) -> string.endsWith("0"))
                .map((string) -> string + "!")
                .collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);

        }
    }
}
