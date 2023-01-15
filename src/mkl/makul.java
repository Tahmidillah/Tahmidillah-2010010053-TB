/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mkl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import krs.Koneksi;

/**
 *
 * @author fikrish
 */
public class makul {
    Connection Konek = new Koneksi().KonektoDB();
    
    public void insert(String id_makul, String makul, String sks, String semester, String dosen){
        try {
            String SQL = " insert into makul values ( '"+id_makul+"' , '"+makul+"' , '"+sks+"' , '"+semester+"','"+dosen+"' )";
            
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
            ResultSet mkl = statement.executeQuery(sql);
            while (mkl.next()){
                String id_makul = mkl.getString(1);
                String makul = mkl.getString(2);
                String sks = mkl.getString(3);
                String semester = mkl.getString(4);
                String dosen = mkl.getString(5);
                String [] data = {id_makul, makul, sks, semester, dosen};
                model.addRow(data);
                a++;
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(String id_makul, String makul, String sks, String semester, String dosen){
        try {
            String SQL = "update makul set makul='"+makul+"',sks='"+sks+"',semester='"+semester+"', dosen= '"+dosen+"' where id_makul='"+id_makul+"'";
            
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(String id_makul){
        try {
            String SQL = "delete from makul where id_makul='"+id_makul+"'";
        
            PreparedStatement ps = Konek.prepareStatement(SQL);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
