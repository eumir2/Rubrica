package business;
import dto.Persona;
import gui.FinestraPrincipale;
import repository.RWOperations;

import java.util.List;
import java.util.Vector;

public class Rubrica {
    private Vector<Persona> rubrica;
    private RWOperations dr = new RWOperations();
    private FinestraPrincipale fp;


    public Rubrica(){
        rubrica = new Vector<>();
        fp = new FinestraPrincipale(this);
        load();
        fp.fill(rubrica);

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

        if(lines != null){
            //riempio la rubrica
            for(String line : lines){
                Persona t = formatString(line);
                //agguingo se i dati sono sufficienti
                if(t != null){
                    rubrica.add(t);
                }
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

    //ricercaUtente
    public Persona findUser(Persona p){
        for(int i = 0; i < rubrica.size(); i++){
            if(rubrica.get(i).equals(p)){
                return rubrica.get(i);

            }
        }
        return null;
    }

    //eliminare un utente
    public void delUtente(Persona p){
        //rimozione dell'utente dalla rubrica
        for(int i = 0; i < rubrica.size(); i++){
            if(rubrica.get(i).equals(p)){
                rubrica.remove(i);
                break;
            }
        }
        update(rubrica);
    }

    //modifica utente
    public void updateUser(Persona newUser, Persona oldUser){
        for(int i = 0; i < rubrica.size(); i++){
            if(rubrica.get(i).equals(oldUser)){
                //inserimento rimpiazzando il vecchio utente
                rubrica.set(i, newUser);
                break;
            }
        }

        update(rubrica);
    }

    //aggiungta utente
    public void addUser(Persona p){
        rubrica.addFirst(p);

        update(rubrica);
    }

    private void update(Vector<Persona> rubrica){
        //aggiornamento del file
        dr.writeFile(rubrica);

        //aggiornamento tabella
        fp.updateTabella(rubrica);
    }

}
