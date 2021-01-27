/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rizkiadam.latihanmvcjdbc.event;

import edu.rizkiadam.latihanmvcjdbc.entity.Pelanggan;
import edu.rizkiadam.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Legion
 * NIM   : 10119045
 * Nama  : FAHMA MAULANA 
 * Kelas : IF - 2
 */
public interface PelangganListener {
   
    public void onChange(PelangganModel model );
    
    public void onInsert(Pelanggan pelanggan );
    
    public void onDelete();
    
    public void onUpdate(Pelanggan pelanggan );
    
}
