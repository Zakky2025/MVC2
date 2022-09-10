/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.controller;
import Koneksi.koneksi;
import View.tampilan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class model implements controller {
 String jk;
    @Override
    public void Simpan(tampilan t) throws SQLException {    
       if(t.rblaki.isSelected()){
       jk = "laki-laki";
       }else{
       jk ="perempuan";
       }
       try{
       Connection con =koneksi.getcon();
       String sql = "Insert Into siswa Values (?,?,?,?)";
       PreparedStatement prepare = con.prepareStatement(sql);
       prepare.setString(1, t.txtnis.getText());
       prepare.setString(2, t.txtname.getText());
       prepare.setString(3, jk);
       prepare.setString(4, (String) t.cbjurusan.getSelectedItem());
       prepare.executeUpdate();
       JOptionPane.showMessageDialog(null, "data Berhasil diSimpan");
       prepare.close();
       }catch (Exception e){
           System.out.println(e);
             }
    }

    @Override
    public void Reset(tampilan t) throws SQLException {
        t.txtname.setText("");
        
    }
    
}
