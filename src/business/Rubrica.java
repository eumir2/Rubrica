package business;
import dto.Persona;
import repository.RWOperations;

import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    private ArrayList<Persona> rubrica;
    private RWOperations dr = new RWOperations();


    public Rubrica(){
        rubrica = new ArrayList<>();
        load();


    }

    //estrazione dei dati dalla stringa
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

    //carica i dati nella rubrica
    private void load(){
        //lettura da file
        List<String> lines = dr.getData();

        //riempio la rubrica
        for(String line : lines){
            Persona t = formatString(line);
            //agguingo se i dati sono sufficienti
            if(t != null){
                rubrica.add(t);
            }
        }
    }

    //toString
    public String toString(){
        String s = new String();
        for(Persona p : rubrica){
            s += p.toString();
        }
        return s;
    }

}
