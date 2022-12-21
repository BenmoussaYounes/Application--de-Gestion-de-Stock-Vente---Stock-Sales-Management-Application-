package Fenetre;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class Fenetre3 extends JFrame{
    private JPanel pan3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton ajoutéButton1;
    private JButton ajoutéButton2;
    private JButton ajoutéButton3;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox5;
    private JButton ajoutéButton;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox8;
    private JTextField textField6;
    private JComboBox comboBox9;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField12;
    private JComboBox Casquette;
    private JComboBox LeHaut;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JButton retourButton;
    private JTextField textField5;
    private JTextField textField10;
    private JTextField textField11;

    public Fenetre3() {
        this.setTitle("GES-Gestion De Stock Ajoute-");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setContentPane(pan3);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = String.valueOf(comboBox1.getSelectedItem());
                switch (m) {
                    case "Rouge": {
                        comboBox1.setBackground(Color.RED);
                    }
                    break;
                    case "Blue": {
                        comboBox1.setBackground(Color.blue);
                    }
                    break;
                    case "Blanc": {
                        comboBox1.setBackground(Color.white);
                    }
                    break;
                    case "orange": {
                        comboBox1.setBackground(Color.orange);
                    }
                    break;
                    case "Noire": {
                        comboBox1.setBackground(Color.black);
                    }
                    break;
                    case "Vert": {
                        comboBox1.setBackground(Color.green);
                    }
                    break;
                }
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = String.valueOf(comboBox4.getSelectedItem());
                switch (m) {
                    case "Rouge": {
                        comboBox4.setBackground(Color.RED);
                    }
                    break;
                    case "Blue": {
                        comboBox4.setBackground(Color.blue);
                    }
                    break;
                    case "Blanc": {
                        comboBox4.setBackground(Color.white);
                    }
                    break;
                    case "orange": {
                        comboBox4.setBackground(Color.orange);
                    }
                    break;
                    case "Noire": {
                        comboBox4.setBackground(Color.black);
                    }
                    break;
                    case "Vert": {
                        comboBox4.setBackground(Color.green);
                    }
                    break;
                }
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = String.valueOf(comboBox2.getSelectedItem());
                switch (m) {
                    case "Rouge": {
                        comboBox2.setBackground(Color.RED);
                    }
                    break;
                    case "Blue": {
                        comboBox2.setBackground(Color.blue);
                    }
                    break;
                    case "Blanc": {
                        comboBox2.setBackground(Color.white);
                    }
                    break;
                    case "orange": {
                        comboBox2.setBackground(Color.orange);
                    }
                    break;
                    case "Noire": {
                        comboBox2.setBackground(Color.black);
                    }
                    break;
                    case "Vert": {
                        comboBox2.setBackground(Color.green);
                    }
                    break;
                }
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = String.valueOf(comboBox3.getSelectedItem());
                switch (m) {
                    case "Rouge": {
                        comboBox3.setBackground(Color.RED);
                    }
                    break;
                    case "Blue": {
                        comboBox3.setBackground(Color.blue);
                    }
                    break;
                    case "Blanc": {
                        comboBox3.setBackground(Color.white);
                    }
                    break;
                    case "orange": {
                        comboBox3.setBackground(Color.orange);
                    }
                    break;
                    case "Noire": {
                        comboBox3.setBackground(Color.black);
                    }
                    break;
                    case "Vert": {
                        comboBox3.setBackground(Color.green);
                    }
                    break;
                }
            }
        });
        comboBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = String.valueOf(comboBox6.getSelectedItem());
                switch (m) {
                    case "Menu": {
                        dispose();
                        Fenetre1 f = new Fenetre1();
                        f.setVisible(true);
                    }
                    break;
                    case "GestionDeStock": {
                        dispose();
                        Fenetre4 f = new Fenetre4();
                        f.setVisible(true);
                    }
                    break;
                    case "Recu": {
                        dispose();
                        Fenetre31 f = new Fenetre31();
                        f.setVisible(true);
                    }
                    break;
                    case "GestionDeVente": {
                        dispose();
                        Fenetre2 f = new Fenetre2();
                        f.setVisible(true);
                    }
                    break;
                    default:
                        break;


                }
            }
        });
        ajoutéButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Couleur = String.valueOf(comboBox1.getSelectedItem());
                    String Taille = String.valueOf(comboBox5.getSelectedItem());
                    String Quantite = textField1.getText();
                    String Prix = textField2.getText();
                    String Article = String.valueOf(Casquette.getSelectedItem());
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost/ges?serverTimeZone=UTC",
                            "root",
                            "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery(
                            "SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    r.last();
                    int x=r.getInt("Number");
                    x++;
                    r.moveToInsertRow();
                    r.updateInt("Number",x);
                    r.updateString("Article", Article);
                    r.updateString("Couleur", Couleur);
                    r.updateString("Taille", Taille);
                    r.updateString("Prix", Prix);
                    r.updateString("Quantite", Quantite);
                    r.insertRow();
                    r.close();
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }



            }
        });
        ajoutéButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Couleur = String.valueOf(comboBox4.getSelectedItem());
                    String Taille = String.valueOf(comboBox7.getSelectedItem());
                    String Quantite = textField3.getText();
                    String Prix = textField4.getText();
                    String Article = String.valueOf(LeHaut.getSelectedItem());
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost/ges?ServerTimeZone=UTC",
                            "root",
                            "younesSql"
                    );
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet r=s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    r.last();
                    int x=r.getInt("Number");
                    x++;
                    r.moveToInsertRow();
                    r.updateInt("Number",x);
                    r.updateString("Article", Article);
                    r.updateString("Couleur", Couleur);
                    r.updateString("Taille", Taille);
                    r.updateString("Prix", Prix);
                    r.updateString("Quantite", Quantite);
                    r.insertRow();
                    r.close();
                }catch(SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
        ajoutéButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Couleur = String.valueOf(comboBox2.getSelectedItem());
                    String Taille = String.valueOf(comboBox8.getSelectedItem());
                    String Article = String.valueOf(comboBox12.getSelectedItem());
                    String Prix = textField6.getText();
                    String Quantite = textField12.getText();
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost/ges?ServerTimeZone=UTC",
                            "root",
                            "younesSql"

                    );
                    Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet r=s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    r.last();
                    int x=r.getInt("Number");
                    x++;
                    r.moveToInsertRow();
                    r.updateInt("Number",x);
                    r.updateString("Article", Article);
                    r.updateString("Couleur", Couleur);
                    r.updateString("Taille", Taille);
                    r.updateString("Prix", Prix);
                    r.updateString("Quantite", Quantite);
                    r.insertRow();
                    r.close();
                }catch(SQLException ex2){
                    ex2.printStackTrace();
                }
            }
        });
        ajoutéButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Couleur=String.valueOf(comboBox3.getSelectedItem());
                String Taille=String.valueOf(comboBox9.getSelectedItem());
                String Prix=textField8.getText();
                String Quantite=textField7.getText();
                String Article=String.valueOf(comboBox13.getSelectedItem());
                try {
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost/ges?ServerTimeZone=UTC",
                            "root",
                            "younesSql"
                    );
                    Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet r=s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    r.last();
                    int x=r.getInt("Number");
                    x++;
                    r.moveToInsertRow();
                    r.updateInt("Number",x);
                    r.updateString("Article", Article);
                    r.updateString("Couleur", Couleur);
                    r.updateString("Taille", Taille);
                    r.updateString("Prix", Prix);
                    r.updateString("Quantite", Quantite);
                    //int answer=JOptionPane.showConfirmDialog(null,"Esque tu est sure ??","Info",JOptionPane.YES_NO_CANCEL_OPTION);
                        r.insertRow();
                        r.close();
                }catch(SQLException ex3){
                    ex3.printStackTrace();
                }
            }
        });
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre4 f=new Fenetre4();
                f.setVisible(true);
            }
        });
        ajoutéButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bien Ajoute","GES-GestionDeStock-Ajoute- -",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ajoutéButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bien Ajoute","GES-GestionDeStock-Ajoute- -",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ajoutéButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bien Ajoute","GES-GestionDeStock-Ajoute- -",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ajoutéButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bien Ajoute","GES-GestionDeStock-Ajoute- -",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public static void main(String []Args){
        Fenetre3 f3=new Fenetre3();
    }

}
