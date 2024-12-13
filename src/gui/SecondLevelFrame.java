package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class SecondLevelFrame {
    public JFrame frame;
    private JPanel panel;
    private Vector<JLabel> labels;
    private Vector<JTextField> fields;


    public SecondLevelFrame(){
        frame = new JFrame();
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //inizializzo i lable
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

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,2));

        for(int i = 0; i < labels.size(); i++){
            panel.add(labels.get(i));
            panel.add(fields.get(i));
        }

        frame.add(panel);



    }
}
