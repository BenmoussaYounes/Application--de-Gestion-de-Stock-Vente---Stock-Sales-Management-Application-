package Fenetre;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.sql.*;

public class Fenetre2 extends JFrame{
    private JButton achetéButton;
    private JButton achetéButton1;
    private JButton achetéButton4;
    private JLabel B1;
    private JLabel B2;
    private JButton achetéButton5;
    private JButton achetéButton3;
    private JButton achetéButton2;
    private JComboBox comboBox1;
    private JButton achetéButton10;
    private JButton achetéButton9;
    private JButton achetéButton8;
    private JPanel pan2;
    private JButton achetéButton12;
    private JButton achetéButton13;
    private JButton achetéButton14;
    private JLabel B3;
    private JLabel B5;
    private JLabel B6;
    private JLabel B7;
    private JLabel B9;
    private JLabel B10;
    private JLabel B11;
    private JLabel B13;
    private JLabel B14;
    private JLabel B15;
    private JScrollPane pan0;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JTextField textField5;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField12;
    private JTextField textField11;
    private JButton allerAuPanierButton;
    private JButton menuButton;

    public Fenetre2(){
        try {
            this.setTitle("GES-GestioDeVente-");
            this.setSize(800, 600);
            this.setLocationRelativeTo(null);
            this.setContentPane(pan0);
            this.setVisible(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            comboBox1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String m = String.valueOf(comboBox1.getSelectedItem());
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
                        default:
                            break;
                    }
                }
            });
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC",
                    "root",
                    "younesSql"
            );
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
            r.next();
            int i=0;
            while ((r.next())&&(i<12)) {
              switch(i){
                  case 0:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField1.setText(Article+"|"+Prix+"$");
                  }break;
                  case 1:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField2.setText(Article+"|"+Prix+"$");
                  } break;
                  case 2:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField3.setText(Article+"|"+Prix+"$");
                  }break;
                  case 3:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField4.setText(Article+"|"+Prix);
                  }break;
                  case 4:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField5.setText(Article+"|"+Prix);
                  }break;
                  case 5:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField6.setText(Article+" | "+Prix+"£");
                  }break;
                  case 6:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField7.setText(Article+" | "+Prix+"$");
                  }break;
                  case 7:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField8.setText(Article+" | "+Prix+"$");
                  }break;
                  case 8:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField9.setText(Article+" | "+Prix+"$");
                  }break;
                  case 9:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField10.setText(Article+" | "+Prix+"$");
                  }break;
                  case 10:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField11.setText(Article+" | "+Prix+"$");
                  }break;
                  case 11:{
                      String Article=r.getString("Article");
                      String Prix=r.getString("Prix");
                      textField12.setText(Article+" | "+Prix+"£");
                  }break;
              }
              i++;
            }
            achetéButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                                , "root"
                                , "younesSql");
                        Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                        String Prix = null;
                        String Article = null;
                        String Taille = null;
                        String Couleur=null;
                        String Quantite=null;
                        while (r.next()) {
                            if (r.getRow() == 2) {
                                Article = r.getString("Article");
                                Taille = r.getString("Taille");
                                Couleur=r.getString("Couleur");
                                Prix = r.getString("Prix");
                                break;
                            }
                        }
                        Quantite=JOptionPane.showInputDialog(null,"Entrer La Quantite ","GES",JOptionPane.INFORMATION_MESSAGE);
                        int Op=-1;
                        if(Quantite!=null){
                            Op=JOptionPane.showConfirmDialog(null, "Article : " + Article +"\n Couleur : "+Couleur+"\n  Taille : " + Taille+"\n Quantite : "+Quantite +"\n Prix : "+ Prix +" £ "+"\n Ajouté au panier ? ","GES", JOptionPane.YES_NO_CANCEL_OPTION);
                        }
                        if(Op==0){
                            Statement s2=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                            ResultSet r2=s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                            int i=Integer.parseInt(Prix);
                            int j=Integer.parseInt(Quantite);
                            String Totale=String.valueOf(i*j);
                            int n=1;
                            r2.last();
                            if(r2.isLast()){// Sheck if not empty Base
                                n=r2.getInt("Number");
                                n++;
                            }else{
                             n=0; // if Empty base start Primary Key number from 0
                            }
                            r2.moveToInsertRow();
                            r2.updateString("Article",Article);
                            r2.updateString("Couleur",Couleur);
                            r2.updateString("Taille",Taille);
                            r2.updateString("Prix",Prix);
                            r2.updateString("Quantite",Quantite);
                            r2.updateString("Totale",Totale);
                            r2.updateInt("Number",n);
                            r2.insertRow();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        achetéButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 3) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 4) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 5) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 6) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 7) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 8) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 9) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 10) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 11) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 12) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        achetéButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC"
                            , "root"
                            , "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet r = s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
                    String Prix = null;
                    String Article = null;
                    String Taille = null;
                    String Couleur = null;
                    String Quantite = null;
                    while (r.next()) {
                        if (r.getRow() == 13) {
                            Article = r.getString("Article");
                            Taille = r.getString("Taille");
                            Couleur = r.getString("Couleur");
                            Prix = r.getString("Prix");
                            break;
                        }
                    }
                    Quantite = JOptionPane.showInputDialog(null, "Entrer La Quantite ", "GES", JOptionPane.INFORMATION_MESSAGE);
                    int Op = -1;
                    if (Quantite != null) {
                        Op = JOptionPane.showConfirmDialog(null, "Article : " + Article + "\n Couleur : " + Couleur + "\n  Taille : " + Taille + "\n Quantite : " + Quantite + "\n Prix : " + Prix + " £ " + "\n Ajouté au panier ? ", "GES", JOptionPane.YES_NO_CANCEL_OPTION);
                    }
                    if (Op == 0) {
                        Statement s2 = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet r2 = s2.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`,`Number` FROM `panier`");
                        int i = Integer.parseInt(Prix);
                        int j = Integer.parseInt(Quantite);
                        String Totale = String.valueOf(i * j);
                        int n=1;
                        r2.last();
                        if(r2.isLast()){// Sheck if not empty Base
                            n=r2.getInt("Number");
                            n++;
                        }else{
                            n=0; // if Empty base start Primary Key number from 0
                        }
                        r2.moveToInsertRow();
                        r2.updateString("Article",Article);
                        r2.updateString("Couleur",Couleur);
                        r2.updateString("Taille",Taille);
                        r2.updateString("Prix",Prix);
                        r2.updateString("Quantite",Quantite);
                        r2.updateString("Totale",Totale);
                        r2.updateInt("Number",n);
                        r2.insertRow();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        allerAuPanierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre31 f=new Fenetre31();
                f.setVisible(true);
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre1 f=new Fenetre1();
                f.setVisible(true);
            }
        });
    }
    public static void main(String []Args){
        Fenetre2 f2=new Fenetre2();


    }
}
