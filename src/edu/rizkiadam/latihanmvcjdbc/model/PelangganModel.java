/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkiadam.latihanmvcjdbc.model;

import edu.rizkiadam.latihanmvcjdbc.database.KingBarbershopDatabase;
import edu.rizkiadam.latihanmvcjdbc.entity.Pelanggan;
import edu.rizkiadam.latihanmvcjdbc.error.PelangganException;
import edu.rizkiadam.latihanmvcjdbc.event.PelangganListener;
import edu.rizkiadam.latihanmvcjdbc.service.PelangganDao;
import java.sql.SQLException;

/**
 *
 * @author Legion
 * NIM   : 10119045
 * Nama  : FAHMA MAULANA 
 * Kelas : IF - 2
 */
public class PelangganModel {
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    
    protected void fireOnChange(){
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnCnInsert(Pelanggan pelanggan){
        if (listener!=null) {
            listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnUpdate(Pelanggan pelanggan){
        if (listener!=null) {
            listener.onUpdate(pelanggan);
        }
    }
    
    protected void firenOnDelete(){
        if (listener!=null) {
            listener.onDelete();
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException{
    
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        
        dao.insertPelanggan(pelanggan);
        fireOnCnInsert(pelanggan);

    }
    
    public void updatePelanggan() throws SQLException, PelangganException{
    
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);
        
        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);

    }
    
    public void deletePelanggan() throws SQLException, PelangganException{
    
        PelangganDao dao = KingBarbershopDatabase.getPelangganDao();
        dao.deletePelanggan(id);
        firenOnDelete();

    }
    
    public void resetPelanggan(){
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    
    
    
    }
}
