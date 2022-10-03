import java.util.List;

public class Main {
    public static void main(String[] args){

        Printable pt = (n) -> {n.forEach(System.out::println);};
        ReadFile rf = new ReadFile(pt);
        List<Weapon> weapons = rf.readFile();
        rf.print(weapons);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");


        pt = (n) -> {
            Weapon current = n.get(0);
            for (int i = 0; i < n.size(); i++) {
                current = n.get(i);
                System.out.println("-------------------------------------------------------------------------");
                System.out.println(current.getName()+" | "+current.getType()+" | "+current.getDamagetype()+" | "+current.getDamage()+" | "+current.getStrength()+" | "+current.getValue()+" | "+current.getSpeed());
            }
            System.out.println("-------------------------------------------------------------------------");
        };
        ReadFile rf2 = new ReadFile(pt);
        List<Weapon> weapons2 = rf.readFile();
        rf2.print(weapons2);
    }


}
