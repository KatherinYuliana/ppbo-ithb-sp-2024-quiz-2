package model;

import java.util.Date;

public class Member {
    private int nomor_anggota;
    private String nama_lengkap;
    private String jenis_kelamin;
    private Date tanggal_lahir;
    private String foto_member;
    private Date tanggal_pembuatan;

    public Member() {
    }

    public Member(int nomor_anggota, String nama_lengkap, String jenis_kelamin, Date tanggal_lahir, String foto_member,
            Date tanggal_pembuatan) {
        this.nomor_anggota = nomor_anggota;
        this.nama_lengkap = nama_lengkap;
        this.jenis_kelamin = jenis_kelamin;
        this.tanggal_lahir = tanggal_lahir;
        this.foto_member = foto_member;
        this.tanggal_pembuatan = tanggal_pembuatan;
    }

    public Member(int nomor_anggota, String nama_lengkap, String jenis_kelamin, Date tanggal_lahir, String foto_member,
    Date tanggal_pembuatan, int i) {
        this.nomor_anggota = nomor_anggota;
        this.nama_lengkap = nama_lengkap;
        this.jenis_kelamin = jenis_kelamin;
        this.tanggal_lahir = tanggal_lahir;
        this.foto_member = foto_member;
        this.tanggal_pembuatan = tanggal_pembuatan;
    }

    public int getNomor_anggota() {
        return nomor_anggota;
    }

    public void setNomor_anggota(int nomor_anggota) {
        this.nomor_anggota = nomor_anggota;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getFoto_member() {
        return foto_member;
    }

    public void setFoto_member(String foto_member) {
        this.foto_member = foto_member;
    }

    public Date getTanggal_pembuatan() {
        return tanggal_pembuatan;
    }

    public void setTanggal_pembuatan(Date tanggal_pembuatan) {
        this.tanggal_pembuatan = tanggal_pembuatan;
    }

    
}
