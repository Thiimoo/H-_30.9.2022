public class Weapon {

    private WeaponType type;
    private String name;
    private DamageType damagetype;
    private int speed;
    private int damage;
    private int strength;
    private int value;

    public Weapon(String name, WeaponType type, DamageType damagetype,int damage,int speed,int strength,int value)
    {
        this.name = name;
        this.type = type;
        this.damagetype = damagetype;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }


}
