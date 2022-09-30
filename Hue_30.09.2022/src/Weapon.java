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

    @Override
    public String toString()
    {
        return this.name+" typ: "+this.type+" schadensart: "+this.damagetype+" schaden: "+this.damage+" schnelligkeit: "+this.speed+" staerke: "+this.strength+" wert: "+this.value;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DamageType getDamagetype() {
        return damagetype;
    }

    public void setDamagetype(DamageType damagetype) {
        this.damagetype = damagetype;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
