package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Task2 {
    public static void main(String[] args) {
        ArrayList<String>names=new ArrayList<>();
        Collections.addAll(names,"Anton","Antonio","Anthony","Antonius","Antonidas","Antakserks","Anhatep VI");

        int count = (int) names.stream().filter(x->x.equals("Anton")).count();
        System.out.printf("Amount of names in the list: %s\n",count);

        List<String> nameStart = names.stream().filter(x -> x.toLowerCase().startsWith("a")).toList();
        System.out.printf("Names start with letter A:%s\n",nameStart);

        String firstElement = names.stream().sorted().findFirst().orElse("Empty@");
        System.out.println("First element in the list: "+firstElement);





    }
}
