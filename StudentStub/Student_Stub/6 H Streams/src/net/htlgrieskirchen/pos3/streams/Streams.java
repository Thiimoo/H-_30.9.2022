package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    Integer[] randomInts = new Integer[10000];
    String[] randomStrings = new String[10];
    public Integer[] fillIntArray()
    {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() *100);
            }
        };
        randomInts = Stream.generate(supplier).limit(10000).toArray(Integer[]::new);
        return randomInts;
    }

    public String[] fillStringArray()
    {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                Random random = new Random();
                return random.ints(97, 122 + 1)
                        .limit(13)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
            }
        };
        randomStrings = Stream.generate(supplier).limit(100).toArray(String[]::new);
        return randomStrings;
    }

    public double average(int[] numbers) {
        IntStream stream = Arrays.stream(numbers);
        return stream.average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }

    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }

    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //implement this
    }

}
