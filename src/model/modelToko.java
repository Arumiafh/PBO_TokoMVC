/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arumia
 */
public class modelToko {
    
    public String Nama_Barang, Jenis, Harga, Kategori;
    public String Kode_Barang;
    
    //method get
    public String getKode() { return Kode_Barang; }
    public String getNama() { return Nama_Barang; }
    public String getKategori() { return Kategori; }
    public String getJenis() { return Jenis; }
    public String getHarga() { return Harga; }
    
    //method set
    public void setKode(String Kode) { this.Kode_Barang = Kode; }
    public void setNama(String Nama) { this.Nama_Barang = Nama; }
    public void setKategori(String Kategori){ this.Kategori = Kategori; }
    public void setJenis(String Jenis) { this.Jenis = Jenis; }
    public void setHarga(String Harga) { this.Harga = Harga; }
    
}
