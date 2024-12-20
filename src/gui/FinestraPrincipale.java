package gui;

import business.Rubrica;
import dto.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class FinestraPrincipale {
    private Rubrica rubrica;
    private JFrame frame;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable table;
    private DefaultTableModel model;

    //finestre delle altre schermate
    private NuovoUtente nu;
    private ModificaUtente mu;

    public FinestraPrincipale(Rubrica r) {
        this.rubrica = r;
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        tablePanel = new JPanel();
        buttonPanel = new JPanel();

        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rubrica");
    }

    public void fill(Vector<Persona> rubrica) {
        table = new JTable();
        //rendo la tabella non editabile
        table.setDefaultEditor(Object.class, null);
        table.getTableHeader().setReorderingAllowed(false);

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Cognome");
        model.addColumn("Telefono");

        updateTabella(rubrica);
        JScrollPane sp = new JScrollPane(table);
        tablePanel.add(sp, BorderLayout.CENTER);
        addButtons();
        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void updateTabella(Vector<Persona> rubrica) {
        model.setRowCount(0);
        for (Persona p : rubrica) {
            model.addRow(new Object[]{p.getNome(), p.getCognome(), p.getTelefono()});
        }

        this.table.setModel(model);

    }

    private void addButtons() {
        JButton b1 = new JButton("NUOVO");
        JButton b2 = new JButton("ELIMINA");
        JButton b3 = new JButton("MODIFICA");


        //bottone NUOVO
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nu = new NuovoUtente(rubrica);
            }
        });

        //bottone ELIMINA
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if(row != -1){
                    Persona tmp = new Persona();
                    tmp.setNome(table.getValueAt(row,0).toString());
                    tmp.setCognome(table.getValueAt(row,1).toString());
                    tmp.setTelefono(table.getValueAt(row,2).toString());

                    int option = JOptionPane.showConfirmDialog(frame, "Eliminare la persona " + tmp.getNome() + " " + tmp.getCognome());
                    if(option == JOptionPane.YES_OPTION){
                        rubrica.delUtente(tmp);
                    }

                }else{
                    JOptionPane.showMessageDialog(frame, "Nessun utente selezionato");
                }
            }
        });


        //bottone MODIFICA
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if(row != -1){
                    Persona tmp = new Persona();
                    tmp.setNome(table.getValueAt(row,0).toString());
                    tmp.setCognome(table.getValueAt(row,1).toString());
                    tmp.setTelefono(table.getValueAt(row,2).toString());

                    //TODO
                    //caricare dati da rubrica => tocca

                    mu = new ModificaUtente(rubrica, tmp);

                }else{
                    JOptionPane.showMessageDialog(frame, "Nessun utente selezionato");
                }
            }
        });

        buttonPanel.add(b1, BorderLayout.SOUTH);
        buttonPanel.add(b2, BorderLayout.SOUTH);
        buttonPanel.add(b3, BorderLayout.SOUTH);
    }


}
