package gui;

import business.Rubrica;
import dto.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SecondLevelFrame {
    public JFrame frame;
    private JPanel dataPanel;
    public JPanel buttonPanel;
    public JButton salva = new JButton("SALVA");
    public JButton annulla = new JButton("ANNULLA");
    private Vector<JLabel> labels;
    public Vector<JTextField> fields;
    public Rubrica rubrica;



    public SecondLevelFrame(Rubrica r){
        frame = new JFrame();
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        rubrica = r;

        //inizializzo i label
        labels = new Vector<>();
        labels.add(new JLabel("Nome"));
        labels.add(new JLabel("Cognome"));
        labels.add(new JLabel("Indirizzo"));
        labels.add(new JLabel("Telefono"));
        labels.add(new JLabel("Età"));

        //inizializzo i JTextField
        JTextField nome = new JTextField();
        JTextField cognome = new JTextField();
        JTextField indirizzo = new JTextField();
        JTextField telefono = new JTextField();
        JTextField eta = new JTextField();

        fields = new Vector<>();
        fields.add(nome);
        fields.add(cognome);
        fields.add(indirizzo);
        fields.add(telefono);
        fields.add(eta);

        dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(5,2));

        for(int i = 0; i < labels.size(); i++){
            dataPanel.add(labels.get(i));
            dataPanel.add(fields.get(i));
        }

        buttonPanel = new JPanel();


        annulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        buttonPanel.add(annulla);
        buttonPanel.add(salva);
        frame.add(dataPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);



    }
}
