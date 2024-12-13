package repository;

import business.Rubrica;
import dto.Persona;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RWOperations {
    private String file;

    public RWOperations(){
        this.file = "informazioni.txt";
    }

    //lettura da file
    public List<String> getData(){
        //lettura da file
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.file));
            return lines;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //eliminazione del file
    private void delFile(){
        try {
            FileWriter f = new FileWriter(String.valueOf(Paths.get(this.file)),false);
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
            Files.write(Paths.get(this.file), s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
