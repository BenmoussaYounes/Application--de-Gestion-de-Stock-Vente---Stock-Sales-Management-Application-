package Fenetre;

import javax.swing.*;
import java.awt.event.*;

public class Fenetre1 extends JFrame{
    private JButton GestionDeStock;
    private JButton gestionDeVenteButton;
    private JButton recuButton;
    private JButton exitButton;
    private JPanel pan;
    private JButton parametreButton;
    private JButton seConnecterButton;
    private JTextField gestionDeVenteEtTextField;

    public Fenetre1(){
        this.setTitle("GSE");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gestionDeVenteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                Fenetre2 f=new Fenetre2();
                f.setVisible(true);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        GestionDeStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre4 f=new Fenetre4();
                f.setVisible(true);
            }
        });
        recuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre31 f=new Fenetre31();
                f.setVisible(true);
            }
        });
    }
    public static void main(String []Args){
        Fenetre1 f=new Fenetre1();
    }
}
