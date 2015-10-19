/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HerdiandKun
 */
public class bukumanager {
  private Connection conn = null;
  private Statement st = null;
  private String url = "jdbc:mysql://localhost:3306/perpustakaan";
  private String user = "root";
  private String pass = "";
  
  public bukumanager(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, pass);
    st = conn.createStatement();
    } catch(Exception e){
    e.printStackTrace();
    }
  }
    public List getBuku(){
  ResultSet rs = null;
  List buku = new ArrayList();
  try {
  rs = st.executeQuery("select * from buku");
  while (rs.next()){
      Buku b = new Buku();
      b.setIDBuku(rs.getString("IDBuku"));
      b.setJudul(rs.getString("Judul"));
      b.setPengarang(rs.getString("Author"));
      b.setPenerbit(rs.getString("Penerbit"));
      b.setRak(rs.getString("Rak"));
      b.setStock(rs.getString("Stock"));
      buku.add(b);
        }
        } catch (Exception e){
                    e.printStackTrace();
         }
         return buku;
  }
    
     public int Insert(Buku b)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("insert into buku values('" + b.getIDBuku() + "','"+ b.getJudul() + "','" +b.getPengarang()+"','"+b.getPenerbit()+"','"+b.getRak()+"','"+b.getStock()+"')");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
     public int Delete(Buku b)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("delete from buku where IDBuku='" + b.getIDBuku() +"'");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
  public int Update(Buku b)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("update buku set Judul='"+b.getJudul()+
              "',Author='"+b.getPengarang()+"',Penerbit='"+b.getPenerbit()+"',Rak='"+b.getRak()+"',Stock='" +b.getStock()+"' where IDBuku='" + b.getIDBuku() +"'");
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
