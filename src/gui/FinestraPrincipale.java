package gui;

import dto.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class FinestraPrincipale {
    private JFrame frame;
    private JPanel tablePanel;
    private JPanel buttonPanel;
    private JTable table;
    private DefaultTableModel model;

    //finestre delle altre schermate
    private NuovoUtente nu;
    private EliminaUtente eu;
    private ModificaUtente mu;

    public FinestraPrincipale() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        tablePanel = new JPanel();
        buttonPanel = new JPanel();

        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rubrica");
        frame.setVisible(true);

    }

    public void fill(Vector<Persona> rubrica) {
        table = new JTable();

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

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nu = new NuovoUtente();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eu = new EliminaUtente();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mu = new ModificaUtente();
            }
        });

        buttonPanel.add(b1, BorderLayout.SOUTH);
        buttonPanel.add(b2, BorderLayout.SOUTH);
        buttonPanel.add(b3, BorderLayout.SOUTH);
    }
}
