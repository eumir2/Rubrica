package business;
import dto.Persona;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    private ArrayList<Persona> rubrica;

    public Rubrica(){
        rubrica = new ArrayList<>();
        //lettura da file
        try {
            List<String> lines = Files.readAllLines(Paths.get("informazioni.txt"));
            for(String line : lines){
                Persona t = formatString(line);
                //agguingo se i dati sono sufficienti
                if(t != null){
                    rubrica.add(t);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Persona formatString(String data){
        Persona tmp = new Persona();
        String[] d = data.split(";");
        if(d.length < 5){
            return null;
        }
        tmp.setNome(d[0]);
        tmp.setCognome(d[1]);
        tmp.setIndirizzo(d[2]);
        tmp.setTelefono(d[3]);
        tmp.setEta(Integer.parseInt(d[4]));

        return tmp;
    }

    public String toString(){
        String s = new String();
        for(Persona p : rubrica){
            s += p.toString();
        }
        return s;
    }

}
