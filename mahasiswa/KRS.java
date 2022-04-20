package com.company.tuugasColections.mahasiswa;

public class KRS {
    private String matkul;
    private int sks;
    private static int totalSks = 0;
    static final int maxSKS = 25;

    public static int getTotalSks() {
        return totalSks;
    }

    public KRS(String matkul, int sks) {
        this.matkul = matkul;
        this.sks = sks;
    }

    public String getMatkul() {
        return matkul;
    }

    public int getSks() {
        return sks;
    }

    public static void setTotalSks(int sks) {
        KRS.totalSks += sks;
    }

    public void cetak(){
        System.out.printf("%-20s%5d\n",getMatkul(),getSks());
    }
}
