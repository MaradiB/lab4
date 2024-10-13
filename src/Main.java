import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main { 
//asd
    static ArrayList<Beer> beers = new ArrayList<>();

    protected static void add(String[] cmd){
        beers.add(new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3])));
    }
    protected static void list(String[] cmd){
        try{
        if(cmd.length == 2){
            Comparator comparator;
            if(cmd[1].equals("name")) {
                comparator = new NameComparator();
            }else if(cmd[1].equals("style")) {
                comparator = new StyleComparator();
            }else if (cmd[1].equals("strength")) {
                comparator = new StrengthComparator();
            }else{
                throw new Exception("Baj van");
            }
            beers.sort(comparator);
        }
        for (Beer b : beers){
            System.out.println(b);
        }} catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    protected static void save(String[] cmd){
        try {
            FileOutputStream fos =  new FileOutputStream("beers.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(beers);
            oos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    protected static void load(String[] cmd){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("beers.txt"));
            beers = (ArrayList<Beer>) ois.readObject();
            ois.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
//        Beer kobi = new Beer("Kobanyai", "Vilagos", 4.6);
//        Beer pilner = new Beer("Pilner", "Vilagos", 4.2);
//        System.out.println(kobi.toString());
//        System.out.println(pilner.toString());

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while(true) {
            try {
                String line = br.readLine();
                if (line == null) break;
                if(line.equals("exit")) break;
                String[] cmd = line.split(" ");
                if(cmd[0].equals("add")) {
                    add(cmd);
                }else if(cmd[0].equals("list")) {
                    list(cmd);
                }else if(cmd[0].equals("load")) {
                    load(cmd);
                }else if(cmd[0].equals("save")) {
                    save(cmd);
                }
            } catch (IOException e) {
               System.out.println(e.getMessage());
            }
        }
    }
}