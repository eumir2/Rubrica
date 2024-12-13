package gui;

import business.Rubrica;
import dto.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificaUtente extends SecondLevelFrame{


    public ModificaUtente(Rubrica r, Persona tmp){
        super(r);

        super.frame.setTitle("Modifica utente");

        Persona t = r.findUser(tmp);

        //carico i dati da modificare
        ModificaUtente.super.fields.get(0).setText(t.getNome());
        ModificaUtente.super.fields.get(1).setText(t.getCognome());
        ModificaUtente.super.fields.get(2).setText(t.getIndirizzo());
        ModificaUtente.super.fields.get(3).setText(t.getTelefono());
        ModificaUtente.super.fields.get(4).setText(String.valueOf(t.getEta()));



        super.salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona p = new Persona();
                p.setNome(ModificaUtente.super.fields.get(0).getText());
                p.setCognome(ModificaUtente.super.fields.get(1).getText());
                p.setIndirizzo(ModificaUtente.super.fields.get(2).getText());
                p.setTelefono(ModificaUtente.super.fields.get(3).getText());
                p.setEta(Integer.parseInt(ModificaUtente.super.fields.get(4).getText()));

                r.updateUser(p);

                ModificaUtente.super.frame.dispose();
            }
        });

        super.frame.setVisible(true);
    }
}
