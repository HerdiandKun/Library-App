/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.data;

/**
 *
 * @author misterciput
 */
public class pinjam {
   
    private String Nim;
    private String IDBuku;
    private String tglPinjam;
    private String tglJatuhTempo;
    private String tglKembali;
    private int denda;

    /**
     * @return the Nim
     */
    public String getNim() {
        return Nim;
    }

    /**
     * @param Nim the Nim to set
     */
    public void setNim(String Nim) {
        this.Nim = Nim;
    }

    /**
     * @return the IDBuku
     */
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
     * @return the tglPinjam
     */
    public String getTglPinjam() {
        return tglPinjam;
    }

    /**
     * @param tglPinjam the tglPinjam to set
     */
    public void setTglPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    /**
     * @return the tglJatuhTempo
     */
    public String getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    /**
     * @param tglJatuhTempo the tglJatuhTempo to set
     */
    public void setTglJatuhTempo(String tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    /**
     * @return the tglKembali
     */
    public String getTglKembali() {
        return tglKembali;
    }

    /**
     * @param tglKembali the tglKembali to set
     */
    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    /**
     * @return the denda
     */
    public int getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(int denda) {
        this.denda = denda;
    }
    
}
