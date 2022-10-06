package net.htlgrieskirchen.pos3.streams;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicates {

    public final Predicate<Integer> isEven = m -> (m%2 == 0);
    public final Predicate<Integer> isPositive = m -> {
        if (Math.signum((double) m) == 1)
        {
            return true;
        }
        return false;
    };

    public final Predicate<String> isShortWord = m -> m.length()<4;

    public void printPredicates()
    {
        System.out.println("yes");
        if(isShortWord.test("yes"))
        {
            System.out.print(" is a short word");
        }
        else
        {
            System.out.print(" is a long word");
        }

        System.out.println("\n");
        System.out.println("Computer");
        if(isShortWord.test("Computer"))
        {
            System.out.print(" is a short word");
        }
        else
        {
            System.out.print(" is a long word");
        }
        System.out.println("\n");
        System.out.println("2");

        if(isPositive.and(isEven).test(2))
        {
            System.out.print(" is even and positive");
        }
        else if(isPositive.and(isEven.negate()).test(2))
        {
            System.out.print(" is odd and positive");
        }
        else
        {
            System.out.print(" is negative");
        }
        System.out.println("\n");
        System.out.println("33");

        if(isPositive.and(isEven).test(33))
        {
            System.out.print(" is even and positive");
        }
        else if(isPositive.and(isEven.negate()).test(33))
        {
            System.out.print(" is odd and positive");
        }
        else
        {
            System.out.print(" is negative");
        }
        System.out.println("\n");
        System.out.println("-20");

        if(isPositive.and(isEven).test(-20))
        {
            System.out.print(" is even and positive");
        }
        else if(isPositive.and(isEven.negate()).test(-20))
        {
            System.out.print(" is odd and positive");
        }
        else
        {
            System.out.print(" is negative");
        }
    }

}
