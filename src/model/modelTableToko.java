/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author arumia
 */
public class modelTableToko extends AbstractTableModel
{
    List<modelToko> lt;
    
    public modelTableToko(List<modelToko> lt)
    {
        this.lt = lt;
    }
    
    @Override
    public int getRowCount()
    {
        return lt.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return 5;
    }
    
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0 : return"kode_barang";
            case 1 : return"nama_barang";
            case 2 : return"kategori";
            case 3 : return"jenis";
            case 4 : return"harga";
            default : return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        switch(column)
        {
            case 0 : return lt.get(row).getKode();
            case 1 : return lt.get(row).getNama();
            case 2 : return lt.get(row).getKategori();
            case 3 : return lt.get(row).getJenis();
            case 4 : return lt.get(row).getHarga();
            default : return null;
        }
    }
    
}
