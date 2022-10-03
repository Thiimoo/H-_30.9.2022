import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ReadFileTest {

    @org.junit.Test
    public void readFile() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Varscona",WeaponType.MELEE,DamageType.SLASHING,11,3,5,4250));
        ReadFile.readFile();
        List<Weapon> weaponsList = ReadFile.getWeapons();
        assertEquals(weaponsList.get(0).getName(),weapons.get(0).getName());
    }
    @org.junit.Test
    public void readFile2() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Boomerang Dagger",WeaponType.RANGED,DamageType.PIERCING,10,1,3,3500));
        ReadFile.readFile();
        ReadFile.sortByName();
        List<Weapon> weaponsList = ReadFile.getWeapons();
        assertEquals(weaponsList.get(0).getName(),weapons.get(0).getName());
    }
}