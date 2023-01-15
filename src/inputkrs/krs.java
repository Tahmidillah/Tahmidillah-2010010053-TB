/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inputkrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import krs.Koneksi;


/**
 *
 * @author fikrish
 */
public class krs {
    Connection Konek = new Koneksi().KonektoDB();
    public void insert (String nim, String nama, String id_makul, String makul, String sks, String semester, String dosen){
            try {
            String SQL = "insert into krs values ('"+nim+"','"+nama+"','"+id_makul+"','"+makul+"','"+sks+"','"+semester+"','"+dosen+"')";
            
                PreparedStatement ps = Konek.prepareStatement(SQL);
                ps. executeUpdate();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
     }
    public void delete(String id_makul){
            try {
            
                String SQL = "delete from krs where id_makul = '"+id_makul+"'";
            
                PreparedStatement ps = Konek.prepareStatement(SQL);
                ps. executeUpdate();
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
     }
    public void select(String SQL,DefaultTableModel model){
        int a = 1;
        
        try {
            Statement statement = Konek.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                String nim = rs.getString(1);
                String nama = rs.getString(2);
                String id_makul = rs.getString(3);
                String makul = rs.getString(4);
                String sks = rs.getString(5);
                String semester = rs.getString(6);
                String dosen = rs.getString(7);
                
                String [] data = {nim, nama, id_makul, makul, sks, semester, dosen};
                
                model.addRow(data);
                a++;
                
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
}
    public void update(String nim, String nama, String id_makul, String makul, String sks, String semester, String dosen){
        try {
            String SQL = "update krs set nim='"+nim+"',nama='"+nama+"', makul='"+makul+"',sks='"+sks+"',semester='"+semester+"', dosen='"+dosen+"' where id_makul='"+id_makul+"'";
            
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public  void combo (JComboBox kombo){
        kombo.removeAllItems();
        String SQL = "select id_makul from makul";
        try {
            Statement statement = Konek.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while(rs.next()){
                kombo.addItem(rs.getString("id_makul"));
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
