
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class ReadFile implements Printable{

    private List<Weapon> weapons = new ArrayList<>();

    private Printable pt;

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public ReadFile(Printable printable) {
        pt = printable;
    }

    public List<Weapon> readFile()
    {
        List<String> linesList = null;
        String[] parts;
        try {
            linesList = Files.readAllLines(Path.of("src/weapons.csv"));
            Stream<String> lines = linesList.stream();
            for (int i = 1; i < linesList.size(); i++) {
                parts = linesList.get(i).split(";");
                if (parts[1].equals("NONE"))
                {
                    continue;
                }
                WeaponType wt = WeaponType.valueOf(parts[1]);
                DamageType dt = DamageType.valueOf(parts[2]);
                Weapon w = new Weapon(parts[0],wt,dt,Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
                weapons.add(w);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return weapons;
    }



    public void printWeapons(List<Weapon> weapons)
    {
        weapons.forEach(System.out::println);

        System.out.println("Damage:");
        sortByDamage();
        weapons.forEach(System.out::println);

        System.out.println("Name:");
        sortByName();
        weapons.forEach(System.out::println);

        System.out.println("Value:");
        sortByValue();
        weapons.forEach(System.out::println);

        System.out.println("Strength:");
        sortByStrength();
        weapons.forEach(System.out::println);

        System.out.println("Damage type:");
        sortByDamageType();
        weapons.forEach(System.out::println);

        System.out.println("Weapon type:");
        sortByWeaponType();
        weapons.forEach(System.out::println);
    }

    public void sortByDamage()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getDamage()));
    }

    public void sortByName()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getName()));
    }

    public void sortByValue()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getValue()));
    }

    public void sortByStrength()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getStrength()));
    }

    public void sortByDamageType()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getDamagetype()));
    }

    public void sortByWeaponType()
    {
        Collections.sort(weapons,Comparator.comparing(p -> p.getType()));
    }


    @Override
    public void print(List<Weapon> weapons) {
        pt.print(weapons);
    }
}
