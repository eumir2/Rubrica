package gui;

import business.Rubrica;
import dto.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuovoUtente extends SecondLevelFrame{

    public NuovoUtente(Rubrica r){
        super(r);

        super.frame.setTitle("Nuovo utente");
        super.salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona p = new Persona();
                p.setNome(NuovoUtente.super.fields.get(0).getText());
                p.setCognome(NuovoUtente.super.fields.get(1).getText());
                p.setIndirizzo(NuovoUtente.super.fields.get(2).getText());
                p.setTelefono(NuovoUtente.super.fields.get(3).getText());
                p.setEta(Integer.parseInt(NuovoUtente.super.fields.get(4).getText()));

                r.addUser(p);

                NuovoUtente.super.frame.dispose();
            }
        });
        super.frame.setVisible(true);
    }
}
