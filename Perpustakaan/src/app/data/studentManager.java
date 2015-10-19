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
public class studentManager {
  private Connection conn = null;
  private Statement st = null;
  private String url = "jdbc:mysql://localhost:3306/perpustakaan";
  private String user = "root";
  private String pass = "";
  
  public studentManager(){
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, pass);
    st = conn.createStatement();
    } catch(Exception e){
    e.printStackTrace();
    }
  }
    public List getStudent(){
  ResultSet rs = null;
  List students = new ArrayList();
  try {
  rs = st.executeQuery("select * from student");
  while (rs.next()){
      student s = new student();
      s.setID(rs.getString("ID"));
      s.setNim(rs.getString("Nim"));
      s.setNama(rs.getString("Nama"));
      s.setPK(rs.getString("PK"));
      s.setAlamat(rs.getString("Alamat"));
      s.setTanggal(rs.getString("Masa Aktif"));
      s.setNoHp(rs.getString("noHP"));
      students.add(s);
        }
        } catch (Exception e){
                    e.printStackTrace();
         }
         return students;
  }
    /*public void getNIM(student s)
    { 
        CekAnggota cek = new CekAnggota();
  try {
       ResultSet res = st.executeUpdate("Select * from into student where Nim='"+cek.lokal()+",");
  } catch (Exception e) { e.printStackTrace();}
  
    }*/
     public int Insert(student s)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("insert into student values('" + s.getID() + "','"+ s.getNim() + "','" +s.getNama()+"','"+s.getPK()+"','"+s.getAlamat()+"','"+s.getTanggal()+"','"+s.getNoHp()+"')");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
     public int Delete(student s)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("delete from student where Nim='" + s.getNim() +"' or ID='"+s.getID()+"'");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
  public int Update(student s)
  {
  int result = 0 ;
  try {
      result = st.executeUpdate("update student set Nim='"+ s.getNim() + "', Nama='"+s.getNama()+
              "',PK='"+s.getPK()+"',Alamat='"+s.getAlamat()+"',Masa_Aktif='"+s.getTanggal()+"',noHP='" +s.getNoHp()+"' where ID='" + s.getID() +"'");
  } catch (Exception e) { e.printStackTrace();}
  return result;
  }
 
  public void Cari(student s){
      ResultSet result;
      try{
          result=st.executeQuery("select * from student where Nim='"+s.getNim()+"'");
       }catch(Exception e){
           e.printStackTrace();
       }
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

