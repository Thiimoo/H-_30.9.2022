package net.htlgrieskirchen.pos3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    Integer[] randomInts = new Integer[10000];
    String[] randomStrings = new String[10];

    public Integer[] fillIntArray() {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        randomInts = Stream.generate(supplier).limit(10000).toArray(Integer[]::new);
        return randomInts;
    }

    public String[] fillStringArray() {
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
        Stream<String> stream = Arrays.stream(strings);
        return stream.map(String::toUpperCase).toList();
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        Weapon weaponStream = weapons.stream().sorted((w1, w2) -> Integer.compare(w1.getMinStrength(), w2.getMinStrength())).findFirst().orElse(null);
        return weaponStream;
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        Weapon weaponStream = weapons.stream().sorted((w1, w2) -> Integer.compare(w2.getMinStrength(), w1.getMinStrength())).findFirst().orElse(null);
        return weaponStream;
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        List<Weapon> weaponStream = weapons.stream().filter(weapon -> {
            if (weapon.getDamageType().equals(DamageType.MISSILE)) {
                return true;
            } else {
                return false;
            }
        }).toList();
        return weaponStream;
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        Weapon weaponStream = weapons.stream().sorted((w1, w2) -> Integer.compare(w2.getName().length(), w1.getName().length())).findFirst().orElse(null);
        return weaponStream;
    }

    public List<String> toNameList(List<Weapon> weapons) {
        List<String> weaponStream = weapons.stream().map(Weapon::getName).toList();
        return weaponStream;
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        List<Integer> weaponStream = weapons.stream().map(Weapon::getSpeed).toList();
        int[] returnArray = new int[weaponStream.size()];
        for (int i = 0; i < weaponStream.size(); i++) {
            returnArray[i] = weaponStream.get(i);
        }
        return returnArray;
    }

    public int sumUpValues(List<Weapon> weapons) {
        int value = weapons.stream().mapToInt(Weapon::getValue).sum();
        return value;
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        int value = weapons.stream().mapToInt(Weapon::hashCode).sum();
        return value;
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        List<Weapon> weaponStream = weapons.stream().distinct().collect(Collectors.toList());
        return weaponStream;
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //implement this
    }

}
