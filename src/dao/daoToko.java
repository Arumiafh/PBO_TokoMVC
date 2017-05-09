/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import control.controllerKoneksi; 
import model.modelToko;
/**
 *
 * @author arumia
 */
public class daoToko implements daoImplementToko{
    
    Connection connection;
    public String TampilData = "select * from `tb_barang`";
    public String UbahData = "update `tb_barang` "
            + "               set `nama_barang`=? , `harga`=? , `kategori`=? , `jenis`=? "
            + "               where `kode_barang`=?;";
    public String SimpanData = "insert into `tb_barang` "
            + "                 values (?,?,?,?,?)";
    public String HapusData = "delete from `tb_barang` where kode_barang=?";
    public String CariKategori = "select `kode_barang`,`nama_barang`,`kategori`,`jenis`,`harga` from `tb_barang` "
            + "                  where kategori like ?";
    
   public daoToko(){
       
       connection = controllerKoneksi.setKoneksi();    
}
    @Override
    public void TampilData(modelToko a) { 
         
    } 
 
    @Override
    public void UbahData(modelToko a) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(UbahData); 
        statement.setString(5, a.getKode()); 
        statement.setString(1, a.getNama()); 
        statement.setString(3, a.getKategori()); 
        statement.setString(4, a.getJenis()); 
        statement.setString(2, a.getHarga()); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) {          
            Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
 
    @Override
    public void SimpanData(modelToko a) { 
        PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(SimpanData); 
        statement.setString(1, a.getKode()); 
        statement.setString(2, a.getNama()); 
        statement.setString(3, a.getKategori()); 
        statement.setString(4, a.getJenis()); 
        statement.setString(5, a.getHarga()); 
        statement.executeUpdate(); 
        ResultSet rs = statement.getGeneratedKeys(); 
        while (rs.next()){ 
            a.setKode(rs.getString(1)); 
        } 
    }
     catch (SQLException ex) { 
         Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE, null, ex); 
        } 
         
    }
    
    //menampilkan data ke tabel sesuai pencarian 
    @Override
    public List<modelToko> getCariKategori(String kategori) { 
    List<modelToko> lt = null; 
    try { 
        lt = new ArrayList<modelToko>();  
        PreparedStatement st = connection.prepareStatement(CariKategori); 
        st.setString(1, "%"+kategori+"%"); 
        ResultSet rs = st.executeQuery(); 
        while (rs.next()){ 
            modelToko toko = new modelToko(); 
            toko.setKode(rs.getString("kode_barang")); 
            toko.setNama(rs.getString("nama_barang")); 
            toko.setKategori(rs.getString("kategori")); 
            toko.setJenis(rs.getString("jenis")); 
            toko.setHarga(rs.getString("harga")); 
            lt.add(toko); 
        } 
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex); 
        } 
    return lt; 
    } 
    
    //menampilkan data ke Tabel 
    @Override
    public List<modelToko> getAll() { 
    List<modelToko> lt=null; 
    try { 
        lt = new ArrayList<modelToko>(); 
        Statement st = connection.createStatement(); 
        ResultSet rs = st.executeQuery(TampilData); 
        while (rs.next()){ 
            modelToko toko = new modelToko(); 
            toko.setKode(rs.getString("kode_barang")); 
            toko.setNama(rs.getString("nama_barang")); 
            toko.setKategori(rs.getString("kategori")); 
            toko.setJenis(rs.getString("jenis")); 
            toko.setHarga(rs.getString("harga")); 
            lt.add(toko); 
    } 
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex); 
        } 
   return lt; 
}    
    
//hapus data 
    @Override
    public void HapusData(String kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(HapusData); 
        statement.setString(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE,null, ex); 
        } 
    } 
    //pencarian data 
    public void CariKategori(int kode) { 
    PreparedStatement statement = null; 
    try { 
        statement = connection.prepareStatement(CariKategori); 
        statement.setInt(1, kode); 
        statement.executeUpdate(); 
         
    }   catch (SQLException ex) { 
            
Logger.getLogger(daoToko.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
    
} 
    
    

