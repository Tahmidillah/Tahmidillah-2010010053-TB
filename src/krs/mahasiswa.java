/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package krs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fikrish
 */
public class mahasiswa {
    Connection Konek = new Koneksi().KonektoDB();
    
    public void insert(String nim, String nama, String alamat, String jenis_k, String jurusan){
        try {
            String SQL = " insert into mhs values ('"+nim+"','"+nama+"','"+alamat+"','"+jenis_k+"','"+jurusan+"')";
            
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void select (String sql, DefaultTableModel model){
        int a = 1;
        try {
            Statement statement = Konek.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String nim = rs.getString(1);
                String nama = rs.getString(2);
                String alamat = rs.getString(3);
                String jenis_k = rs.getString(4);
                String jurusan = rs.getString(5);
                
                String [] data = {nim, nama, alamat, jenis_k, jurusan};
                model.addRow(data);
                a++;
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(String nim, String nama, String alamat, String jenis_k, String jurusan){
        try {
            String SQL = "update mhs set nama='"+nama+"', alamat='"+alamat+"',jenis_k='"+jenis_k+"',jurusan='"+jurusan+"' where nim='"+nim+"'";
            
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(String nim){
        try {
            String SQL = "delete from mhs where nim='"+nim+"'";
        
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
