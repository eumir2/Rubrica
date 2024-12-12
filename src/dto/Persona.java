package dto;

//Il software deve avere una classe Persona che contenga le informazioni di uno dei contatti della
//rubrica. Lo stesso software deve contenere una lista di oggetti (ad esempio con la classe Vector) di
//tipo persona. Deve permettere la creazione, la modifica e l’eliminazione delle persone esistenti.
//La persona deve mantenere le seguenti informazioni:
//- nome: stringa
//- cognome: stringa
//- indirizzo: stringa
//- telefono: stringa
//- eta: intero

public class Persona {
    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private int eta;

    public Persona(String nome, String cognome, String indirizzo, String telefono, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.eta = eta;
    }

    public Persona(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String toString(){
        return this.nome+";"+this.cognome+";"+this.indirizzo+";"+this.telefono+";"+this.eta+"\n";
    }


}
