package net.htlgrieskirchen.pos3.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Weapon {
    
    private final String name;
    private final CombatType combatType;
    private final DamageType damageType;
    private final int damage;
    private final int speed;
    private final int minStrength;
    private int value;
    private List<Weapon> weapons = new ArrayList<>();

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int minStrength, int value) {
        this.combatType = combatType;
        this.damage = damage;
        this.damageType = damageType;
        this.minStrength = minStrength;
        this.name = name;
        this.speed = speed;
        this.value = value;
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
                CombatType wt = CombatType.valueOf(parts[1]);
                DamageType dt = DamageType.valueOf(parts[2]);
                Weapon w = new Weapon(parts[0],wt,dt,Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
                weapons.add(w);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return weapons;
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage && speed == weapon.speed && minStrength == weapon.minStrength && value == weapon.value && Objects.equals(name, weapon.name) && combatType == weapon.combatType && damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, combatType, damageType, damage, speed, minStrength, value);
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + minStrength + ", value=" + value + '}';
    }

}
