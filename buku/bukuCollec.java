package com.company.tuugasColections.buku;

public class bukuCollec {
    private String judul, penulis;
    int banyak;

    public bukuCollec(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void cetakData(){
        System.out.println("Judul\t: "+getJudul());
        System.out.println("Penulis\t: "+getPenulis());
    }


}

