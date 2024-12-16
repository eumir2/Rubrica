package repository;

import business.Rubrica;
import dto.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class RWOperations {
    private File file;

    public RWOperations(){
        this.file = new File(String.valueOf(Paths.get("informazioni.txt")));
    }

    //lettura da file
    public List<String> getData(){
        //lettura da file
        try {
            Scanner sc = new Scanner(this.file);
            String s = "";
            while(sc.hasNextLine()){
                s += sc.nextLine();
                s+="\n";
            }
            sc.close();

            String[] lines  = s.split("\n");
            return Arrays.asList(lines);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //eliminazione del file
    private void delFile(){
        try {
            FileWriter f = new FileWriter(file.getPath(),false);
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //scrittura su file
    public void writeFile(Vector<Persona> r){
        delFile();

        //Creazione della stringa
        String s = "";
        for(Persona p : r){
            s += p.toString();
        }

        //scrittua su file
        try {
            PrintStream ps = new PrintStream(this.file);
            ps.print(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
