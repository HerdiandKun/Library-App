/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.data;

/**
 *
 * @author HerdiandKun
 */
public class Buku {
    private String IDBuku;
    private String Judul;
    private String Pengarang;
    private String Penerbit;
    private String Rak;
    private String Stock;

    /**
     * @return the IDBuku
     */
    public Buku(){}
    public String getIDBuku() {
        return IDBuku;
    }

    /**
     * @param IDBuku the IDBuku to set
     */
    public void setIDBuku(String IDBuku) {
        this.IDBuku = IDBuku;
    }

    /**
     * @return the Judul
     */
    public String getJudul() {
        return Judul;
    }

    /**
     * @param Judul the Judul to set
     */
    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    /**
     * @return the Pengarang
     */
    public String getPengarang() {
        return Pengarang;
    }

    /**
     * @param Pengarang the Pengarang to set
     */
    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    /**
     * @return the Penerbit
     */
    public String getPenerbit() {
        return Penerbit;
    }

    /**
     * @param Penerbit the Penerbit to set
     */
    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    /**
     * @return the Rak
     */
    public String getRak() {
        return Rak;
    }

    /**
     * @param Rak the Rak to set
     */
    public void setRak(String Rak) {
        this.Rak = Rak;
    }

    /**
     * @return the Status
     */
    public String getStock() {
        return Stock;
    }

    /**
     * @param Status the Status to set
     */
    public void setStock(String Stock) {
        this.Stock = Stock;
    }
}
