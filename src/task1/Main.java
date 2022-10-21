package task1;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int listSize = random.nextInt(10,20);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(1, 20));
        }
        System.out.println("Заданная коллекция list:\n"+list);

        List<Integer> result = list.stream()
                .distinct()
                .filter(x -> (x % 2 == 0) && x > 7 && x < 17)
                .map(x -> x * 2).sorted((x1, x2) -> Integer.compare(x1, x2))
                .limit(4).collect(Collectors.toList());

        Supplier average = new Supplier() {
            @Override
            public Object get() {
                int sum = 0;
                for (int i = 0; i < result.size(); i++) {
                    sum = sum + result.get(i);
                }
                double res =(double) sum  / result.size();
                return res;
            }
        };

        System.out.println("Оставшееся кол-во значений после проверки на уникальность и фильтраци: " + result.size());
        System.out.println("Оставшиеся после проверок значения в коллекции: "+result);
        System.out.println("Среднее арифметическое: " + average.get());

    }
}