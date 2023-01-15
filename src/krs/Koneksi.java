/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package krs;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fikrish
 */
public class Koneksi {
    public Koneksi (){
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            System.out.println("sukses memanggil driver");
        } catch (Exception e) {
            System.out.println("gagal memanggil driver:"+e.getMessage());
        }
    }
    public Connection KonektoDB(){
        Connection Koneksi = null;
        try {
            String url = "jdbc:mysql://localhost/krs";
            String user = "root";
            String pass = "";
            
            Koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("koneksi database sukses");
        } catch (Exception e) {
            System.out.println("koneksi database gagal :"+e.getMessage());
        }
        return Koneksi;
    }
}
