import java.util.List;

public class Main {
    public static void main(String[] args){
        ReadFile rf = new ReadFile(new Printable() {
            @Override
            public void print(List<Weapon> weapons) {
                weapons.forEach(System.out::println);
            }
        });
        List<Weapon> weapons = rf.readFile();
        rf.print(weapons);
    }


}
