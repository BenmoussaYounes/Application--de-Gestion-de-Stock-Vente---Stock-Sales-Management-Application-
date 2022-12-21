package Fenetre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.*;

public class Fenetre31 extends JFrame {
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField informationPersonelleTextField;
    private JTextField détailsDeLaFacturationTextField;
    private JTable table1;
    private JPanel pan1;
    private JTextField textField2;
    private JTextField pannierTextField;
    private JScrollPane pan2;
    private JButton supprimerDePanierButton;
    private JButton valideButton;
    private JButton retourButton;
    private JTextField textField3;

    public Fenetre31() {
        try {
            this.setTitle("GES-Recu-");
            this.setSize(800, 600);
            this.setLocationRelativeTo(null);
            String[] column = {"Article", "Couleur", "Taille", "Quantite", "Prix Par Unite", "Totale"};
            String[][] Data = new String[30][6];
            //
            Connection c= DriverManager.getConnection("jdbc:mysql://localhost/ges?ServerTimeZone=UTC",
                    "root",
                    "younesSql"
            );
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`,`Totale`, `Number` FROM `Panier`"
            );
            int i=0;
            int all=0;
            while(r.next()){
                Data[i][0]=r.getString("Article");
                Data[i][1]=r.getString("Couleur");
                Data[i][2]=r.getString("Taille");
                Data[i][3]=r.getString("Prix");
                Data[i][4]=r.getString("Quantite");
                Data[i][5]=r.getString("Totale");
                //Calacule De Prix Totale
                String Totale=r.getString("Totale");
                all=Integer.parseInt(Totale)+all;
                i++;
            }
            DefaultTableModel model = new DefaultTableModel(Data, column);
            //JTableHeader header = table1.getTableHeader();
            //header.setBackground(Color.blue);
            table1.setModel(model);
            // Affichage de Totale a payer
            String Afficher=String.valueOf(all)+" £ ";
            textField2.setText(Afficher);
            this.setContentPane(pan1);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
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
        } catch (Exception e) {
          e.printStackTrace();
        }
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fenetre2 f=new Fenetre2();
                f.setVisible(true);
            }
        });
        valideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Votre Achat a ete bien effectuez","GES-GestionDeVente",JOptionPane.INFORMATION_MESSAGE);
                try {
                    int Number;
                    Connection c = DriverManager.getConnection(
                            "jdbc:mysql://localhost/ges?serverTimezone=UTC",
                            "root",
                            "younesSql");
                    Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet DeleteTable = s.executeQuery(
                            "SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Totale`, `Number` FROM `panier` ");
                    while (DeleteTable.next()) {
                            DeleteTable.deleteRow();
                    }
                    dispose();
                    Fenetre31 f=new Fenetre31();
                    f.setVisible(true);
                }catch(SQLException sql){
                    sql.printStackTrace();
                }
            }
        });
        supprimerDePanierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ligne = JOptionPane.showInputDialog(null, "Donne le numero de la ligne a supprimer : ", "GES-Suprimmer Ligne-", JOptionPane.INFORMATION_MESSAGE);
                    int op=JOptionPane.showConfirmDialog(null, "Vous ete Sure de Supprimer l Article \n numero "+ligne+" !","GES-Supprimer Ligne-",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
                    if(op==0) {
                        int Number;
                        Connection c = DriverManager.getConnection(
                                "jdbc:mysql://localhost/ges?serverTimezone=UTC",
                                "root",
                                "younesSql");
                        Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet DeleteTable = s.executeQuery(
                                "SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Totale`, `Number` FROM `panier` ");
                        int Row=Integer.parseInt(ligne);
                        while (DeleteTable.next()) {
                            if (Row == DeleteTable.getRow()) {
                                DeleteTable.deleteRow();
                                break;
                            }
                        }
                        while (DeleteTable.next()) {
                            Number = DeleteTable.getInt("Number");
                            Number--;
                            DeleteTable.updateInt("Number", Number);
                            DeleteTable.updateRow();}

                        /*
                        String[] column = {"Article", "Couleur", "Taille", "Quantite", "Prix Par Unite", "Totale"};
                        String[][] Data = new String[30][6];
                        int i=0;
                        int all=0;
                        while(DeleteTable.next()){
                            Data[i][0]=DeleteTable.getString("Article");
                            Data[i][1]=DeleteTable.getString("Couleur");
                            Data[i][2]=DeleteTable.getString("Taille");
                            Data[i][3]=DeleteTable.getString("Prix");
                            Data[i][4]=DeleteTable.getString("Quantite");
                            Data[i][5]=DeleteTable.getString("Totale");
                            //Calacule De Prix Totale
                            String Totale=DeleteTable.getString("Totale");
                            all=Integer.parseInt(Totale)+all;
                            i++;
                        }
                        DefaultTableModel model = new DefaultTableModel(Data, column);
                        table1.setModel(model);*/
                        dispose();
                        Fenetre31 f=new Fenetre31();
                        f.setVisible(true);
                    }

                }catch(SQLException sql){
                    sql.printStackTrace();;

                }
            }
        });
    }
        public static void main(String []Args){
        new Fenetre31();
        }
}



