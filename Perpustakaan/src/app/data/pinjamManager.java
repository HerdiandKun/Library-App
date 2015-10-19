/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author misterciput
 */
public class pinjamManager {
    private Connection conn = null;
  private Statement st = null;
  private String url = "jdbc:mysql://localhost:3306/perpustakaan";
  private String user = "root";
  private String pass = "";
  
  public pinjamManager(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, pass);
    st = conn.createStatement();
    } catch(Exception e){
    e.printStackTrace();
    }
  }
    public List getPinjam(){
  ResultSet rs = null;
  List pinjam = new ArrayList();
  try {
  rs = st.executeQuery("select * from peminjaman");
  while (rs.next()){
      pinjam p = new pinjam();
      p.setNim(rs.getString("Nim"));
      p.setIDBuku(rs.getString("IDBuku"));
      p.setTglPinjam(rs.getString("tglPinjam"));
      p.setTglJatuhTempo(rs.getString("tglJatuhTempo"));
      p.setTglKembali(rs.getString("tglKembali"));
      p.setDenda(rs.getInt("denda"));
      pinjam.add(p);
        }
        } catch (Exception e){
                    e.printStackTrace();
         }
         return pinjam;
  }
    
     public int Insert(pinjam p)
  {
  int result = 0 ;
  try {
     
      result = st.executeUpdate("insert into peminjaman values('" + p.getNim()+ "','"+ p.getIDBuku()+ "','" +p.getTglPinjam()+"','"+p.getTglJatuhTempo()+"','"+p.getTglKembali()+"','"+p.getDenda()+"')");
      
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
     
  public int Update(pinjam p)
  {
  int result = 0 ;
  try {
     result = st.executeUpdate("update peminjaman set tglKembali='"+p.getTglKembali()+"',denda='" +p.getDenda()+"' where Nim='" + p.getNim() +"' AND tglJatuhTempo='"+p.getTglJatuhTempo()+"'");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
 
 
  
  public void closeConnection(){
      try {
          conn.close();
          st.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      
  }
}
