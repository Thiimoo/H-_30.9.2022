
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile implements Comparable<Integer>{

    private static List<Weapon> weapons = new ArrayList<>();

    public static void main(String[] args){
        readFile();
        printWeapons();
    }

    public static void readFile()
    {
        try{
            File f = new File("src/weapons.csv");
            Scanner s = new Scanner(f);
            String[] parts = s.nextLine().split(";");
            while(s.hasNextLine())
            {
                parts = s.nextLine().split(";");
                if (parts[1].equals("NONE"))
                {
                    continue;
                }
                WeaponType wt = WeaponType.valueOf(parts[1]);
                DamageType dt = DamageType.valueOf(parts[2]);
                Weapon w = new Weapon(parts[0],wt,dt,Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
                weapons.add(w);
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void printWeapons()
    {
        weapons.forEach(System.out::println);
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
