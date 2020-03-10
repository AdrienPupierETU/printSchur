import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SatDecoder {
    Scanner scanner;
    int k;
    List<StringBuilder> boxs = new ArrayList<>();
    public SatDecoder(String path, int k) {
        try {
            this.scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.k = k;
        for(int i=0;i<k;i++){
            if(i==0){
                boxs.add(new StringBuilder().append(" Boite ").append(k).append(": "));
            }else{
                boxs.add(new StringBuilder().append(" Boite ").append(i).append(": "));
            }
        }
    }

    public String decode(){
        StringBuilder decoded= new StringBuilder();
        int count=0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(count==0){
                if(line.equals("UNSAT")){
                    return "Unsat problem, no affectation";
                }

            }else{
                String[] affectation = line.split(" ");
                for(String entier : affectation){
                    int value= Integer.parseInt(entier);
                    if(value>0){
                        int boule=(int)Math.ceil((double)value/k);
                        int box=value%k;
                        boxs.get(box).append(boule).append(" ");
                    }
                }
            }
            count++;
        }
        for(int i=1;i<k;i++){
            decoded.append(boxs.get(i).toString()).append("\n");
        }
        decoded.append(boxs.get(0).toString());
        return decoded.toString();
    }
}
