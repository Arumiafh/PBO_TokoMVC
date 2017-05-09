/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author arumia
 */
public class controllerKoneksi {
    
    public static ResultSet executeQuery(String SQL) throws SQLException
    {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        }
        catch (SQLException ex) {
            Logger.getLogger(controllerKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static int execute (String SQL) throws SQLException
    {
        int status = 0;
        Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        }
        catch(SQLException ex){
            Logger.getLogger(controllerKoneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static Connection setKoneksi() {
        String konString = "jdbc:mysql://localhost:3306/pbo_tokomvc";
        Connection koneksi = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (com.mysql.jdbc.Connection)
                    DriverManager.getConnection(konString,"root","");
                    System.out.println("Koneksi Berhasil");
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(controllerKoneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }
        catch(SQLException ex){
            Logger.getLogger(controllerKoneksi.class.getName()).log(Level.SEVERE, null,ex);
        }
        return koneksi;
    }
    
    public static Object getConnection()
    {
        return null;
    }
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    
    public controllerKoneksi()
    {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo_tokomvc","root","");
            st = con.createStatement();
        }
        catch(Exception a)
        {
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal" + a);
        }
    }
    
}
