/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.modelToko;

/**
 *
 * @author arumia
 */
public interface daoImplementToko {
    
    public void TampilData(modelToko a); 
    public void UbahData(modelToko a); 
    public void SimpanData(modelToko a); 
    public void HapusData(String kode); 
    public List<modelToko> getCariKategori(String kategori); 
    public List<modelToko> getAll(); 
    
}
