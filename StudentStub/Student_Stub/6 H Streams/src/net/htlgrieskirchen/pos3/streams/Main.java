package net.htlgrieskirchen.pos3.streams;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Integer[] randoms = new Integer[10000];
        Streams s = new Streams();
        randoms = s.fillIntArray();
        int[] values = new int[10000];
        for (int i = 0; i < randoms.length; i++) {
            values[i] = randoms[i];
        }
        System.out.println(s.average(values));

        String[] randomStrings = s.fillStringArray();
        List<String> stringList = s.upperCase(randomStrings);
        stringList.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Predicates");
        Predicates ps = new Predicates();
        ps.printPredicates();


        System.out.println("\n");

        System.out.println("Quadrieren");
        Quad q = new Quad();
        System.out.println(q.getResult());
    }
}
