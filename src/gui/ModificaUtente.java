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

        Persona oldUser = r.findUser(tmp);

        //carico i dati da modificare
        ModificaUtente.super.fields.get(0).setText(oldUser.getNome());
        ModificaUtente.super.fields.get(1).setText(oldUser.getCognome());
        ModificaUtente.super.fields.get(2).setText(oldUser.getIndirizzo());
        ModificaUtente.super.fields.get(3).setText(oldUser.getTelefono());
        ModificaUtente.super.fields.get(4).setText(String.valueOf(oldUser.getEta()));



        super.salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona newUser = new Persona();
                newUser.setNome(ModificaUtente.super.fields.get(0).getText());
                newUser.setCognome(ModificaUtente.super.fields.get(1).getText());
                newUser.setIndirizzo(ModificaUtente.super.fields.get(2).getText());
                newUser.setTelefono(ModificaUtente.super.fields.get(3).getText());
                newUser.setEta(Integer.parseInt(ModificaUtente.super.fields.get(4).getText()));

                r.updateUser(newUser, oldUser);

                ModificaUtente.super.frame.dispose();
            }
        });

        super.frame.setVisible(true);
    }
}
