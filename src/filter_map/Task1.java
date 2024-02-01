package filter_map;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add((int) (Math.random() * 100 + 100));
        }
        List<String> list = numbers.stream()
                .filter(integer -> integer % 2 == 0 && integer % 5 == 0)
                .map((Math::sqrt))//.map((integer -> Math.sqrt(integer)))
                .map((sqrt) -> "Корень: " + sqrt)
                .collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }

}
