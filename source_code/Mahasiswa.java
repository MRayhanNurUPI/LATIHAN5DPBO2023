/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarmahasiswa;

/**
 *
 * @author sekar and modified by Muhammad Rayhan Nur (2100192)
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String kelas;
    private String nilai;

    
    
    public Mahasiswa(String nim, String nama, String jenisKelamin, String kelas, String nilai){
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.kelas = kelas;
        this.nilai = nilai;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
    
    public String getNim() {
        return this.nim;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    public String getKelas() {
        return this.kelas;
    }
    
    public String getNilai() {
        return this.nilai;
    }
}
