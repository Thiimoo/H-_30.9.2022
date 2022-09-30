public class ReadFile implements Comparable<int>{

    private static List<Weapon> weapons = new ArrayList<>();

    public static void main(String[] args){
        readFile();
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
                Weapon w = new Weapon(parts[0],new WeaponType(parts[1]),new DamageType(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]));
                weapons.add(w);
            }
        }
        catch(FileNotFoundException f)
        {
            System.out.println("File not Found!");
        }

    }
}
