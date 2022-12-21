package Fenetre;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Fenetre4 extends JFrame{
    private JPanel panel1;
    private JComboBox comboBox1;
    private JTable table1;
    private JButton ajoutéButton;
    private JButton modifierButton;
    private JPanel pan11;
    private JScrollPane pan2;
    private JButton menuButton;

    public Fenetre4() {
        this.setTitle("GES-GestionDeStock-");
        this.setSize(800, 600);
        this.setContentPane(panel1);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ges?serverTimezone=UTC",
                    "younes",
                    "younesSQL");
            Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet r = s.executeQuery(
                    "SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");

            String[] column = {"Number","Article", "Couleur", "Taille", "Prix", "Quantite"};
            String[][] Data =new String[30][6];
            int i=0;
            r.next();
            while(r.next()) {
                Data[i][0]=r.getString("Number");
                Data[i][1]=r.getString("Article");
                Data[i][2]=r.getString("Couleur");
                Data[i][3]=r.getString("Taille");
                Data[i][4]=r.getString("Prix")+"£";
                Data[i][5]=r.getString("Quantite");
                i++;
            }
            DefaultTableModel model = new DefaultTableModel(Data, column);
            table1.setModel(model);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
            ajoutéButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    Fenetre3 f = new Fenetre3();
                    f.setVisible(true);
                }
            });
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
                        case "GestionDeStock-Ajoute": {
                            dispose();
                            Fenetre3 f = new Fenetre3();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ligne = JOptionPane.showInputDialog(null, "Donne le numero de la ligne a supprimer : ", "GES-Suprimmer Ligne-", JOptionPane.INFORMATION_MESSAGE);
                    int op=JOptionPane.showConfirmDialog(null, "Vous ete Sure de Supprimer la ligne \n numero "+ligne+" !","GES-Supprimer Ligne-",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
                    if(op==0) {
                        int Number;
                        Connection c = DriverManager.getConnection(
                                "jdbc:mysql://localhost/ges?serverTimezone=UTC",
                                "younes",
                                "younesSQL");
                        Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet DeleteTable = s.executeQuery(
                                "SELECT `Article`, `Couleur`, `Taille`, `Prix`, `Quantite`, `Number` FROM `stock`");
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
                            DeleteTable.updateRow();

                        }
                        dispose();
                        Fenetre4 f=new Fenetre4();
                        f.setVisible(true);
                    }
                }catch(SQLException sql){
                    sql.printStackTrace();;

                }
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
            public static void main (String[]Args){
                new Fenetre4();

            }
        }

