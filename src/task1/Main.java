package task1;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 20));
        }
        System.out.println("Заданная коллекция list:\n"+list);

        List<Integer> result = list.stream()
                .distinct()
                .filter(x -> (x % 2 == 0) && x > 7 && x < 17)
                .map(x -> x * 2).sorted((x1, x2) -> Integer.compare(x1, x2))
                .limit(4).collect(Collectors.toList());

        Average<Integer> average = new Average<Integer>() {
            @Override
            public Integer operation() {
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum = sum + list.get(i);
                }
                int result = sum / list.size();
                return result;
            }
        };

        System.out.println("Оставшееся кол-во значений после проверки на уникальность и фильтраци: " + result.size());
        System.out.println("Оставшиеся после проверок значения в коллекции: "+result);
        System.out.println("Среднее арифметическое: " + average.operation());

    }
}