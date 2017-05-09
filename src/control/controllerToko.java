/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.daoImplementToko;
import dao.daoToko;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import dao.daoToko;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.modelToko;
import view.viewHome;
import model.modelTableToko;

/**
 *```
 * @author arumia
 */
public class controllerToko {
    
    viewHome hm;
    daoImplementToko impToko;
    List<modelToko> lt;
    
    public controllerToko (viewHome hm) 
    {
        this.hm = hm;
        impToko = new daoToko();
        lt = impToko.getAll();
    }
    
    //mengosongkan isian field
    public void Reset()
    {
        hm.getTxtKode().setText("");
        hm.getTxtNama().setText("");
        hm.getTxtHarga().setText("");
        hm.getCbKategori().setSelectedItem(null);
        hm.getCbJenis().setSelectedItem(null);
    }
    
    //menghapus data yang dipilih
    public void Hapus()
    {
        if(hm.getTxtKode().getText().trim().isEmpty())
        {
            
        }
        else
        {
            String kode = (hm.getTxtKode().getText());
            impToko.HapusData(kode);
            JOptionPane.showMessageDialog(hm, "Data berhasil dihapus");
        }
    }
    
    //menyimpan data
    public void SimpanData()
    {
        modelToko toko = new modelToko();
        toko.setKode(hm.getTxtKode().getText()); 
        toko.setNama(hm.getTxtNama().getText()); 
        toko.setHarga(hm.getTxtHarga().getText()); 
        
        toko.setKategori(hm.getCbKategori().getSelectedItem().toString()); 
        toko.setJenis(hm.getCbJenis().getSelectedItem().toString()); 
        impToko.SimpanData(toko); 
    }
    
    //mengubah data
    public void Ubah()
    {
        modelToko toko = new modelToko();
        toko.setKode(hm.getTxtKode().getText()); 
        toko.setNama(hm.getTxtNama().getText()); 
        
        toko.setKategori(hm.getCbKategori().getSelectedItem().toString()); 
        toko.setJenis(hm.getCbJenis().getSelectedItem().toString()); 
        toko.setHarga(hm.getTxtHarga().getText()); 
        impToko.UbahData(toko); 
    }
    
    public void isiTable()
    {
        lt = impToko.getAll();
        modelTableToko tmt = new modelTableToko(lt);
        hm.getTableData().setModel(tmt); 
    }
    
    public void isiField(int row)
    {
        hm.getTxtKode().setText(lt.get(row).getKode().toString()); 
        hm.getTxtNama().setText(lt.get(row).getNama().toString()); 
    
        hm.getCbKategori().setSelectedItem(lt.get(row).getKategori().toString()); 
        hm.getCbJenis().setSelectedItem(lt.get(row).getJenis().toString()); 
        hm.getTxtHarga().setText(lt.get(row).getHarga().toString()); 
    }
    
    public void cariKategori()
    {
        if(!hm.getCbCariKategori().getSelectedItem().toString().isEmpty())
        {   
           // impToko.getCariKategori((String)hm.getCbCariKategori().getSelectedItem()); 
            isiTableCariKategori(); 
        }
        else
        { 
            JOptionPane.showMessageDialog(hm, "Silahkan Pilih Kategori"); 
        } 
    }
    
    
    public void isiTableCariKategori()
    {
       String item = hm.getCbCariKategori().getSelectedItem().toString();
       lt =impToko.getCariKategori(item); 
       modelTableToko tmt = new modelTableToko(lt); 
       hm.getTableData().setModel(tmt);
    }
    
    
}
