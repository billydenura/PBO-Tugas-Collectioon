package com.company.tuugasColections.mahasiswa;

import com.company.tuugasColections.buku.bukuCollec;

import java.util.ArrayList;
import java.util.Scanner;

public class pengelola {
    void welcome() {
        System.out.println("\nSelamat Datang di Layanan KRS...");
        System.out.println("Silahkan Pilih Layanan :");
    }

    void menu() {
        System.out.println("\n1. Tambah Mata Kuliah");
        System.out.println("2. Edit Mata Kuliah");
        System.out.println("3. Hapus Mata Kuliah");
        System.out.println("4. Cetak KRS");
        System.out.println("5. Keluar");
    }

    void complete() {
        Scanner in = new Scanner(System.in);
        ArrayList<KRS> list = new ArrayList<KRS>();


        for (; ; ) {
            menu();
            String pilih = in.nextLine();
            int piliih = Integer.parseInt(pilih);
            if (piliih == 1) {
                System.out.print("Masukkan Nama Mata Kuliah\t: ");
                String nama = in.nextLine();
                System.out.print("Masukkan Jumlah SKS\t\t\t: ");
                String skss = in.nextLine();
                int sks = Integer.parseInt(skss);

                int sksSementara = sks + KRS.getTotalSks();

                if (sksSementara <= KRS.maxSKS) {
                    list.add(new KRS(nama, sks));
                    KRS.setTotalSks(sks);
                } else {
                    System.out.println("Slot SKS Tidak Mencukupi Untuk Menambah Mata Kuliah !!!");
                    System.out.println("Sisa Slot SKS : " + (KRS.maxSKS - KRS.getTotalSks()));
                }
            } else if (piliih == 2) {
                System.out.print("\nMasukkan Mata Kuliah yang Ingin Diubah : ");
                String edit = in.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    if (edit.equals(list.get(i).getMatkul())) {
                        int kurang = 0 - list.get(i).getSks();
                        KRS.setTotalSks(kurang);
                        System.out.print("Masukkan Mata Kuliah Baru   : ");
                        String matkulBaru = in.nextLine();
                        System.out.print("Masukkan SKS Baaru : ");
                        String sksbaru = in.nextLine();
                        int sks = Integer.parseInt(sksbaru);

                        int sksSementara = sks + KRS.getTotalSks();

                        if (sksSementara <= KRS.maxSKS) {
                            list.add(new KRS(matkulBaru, sks));
                            KRS.setTotalSks(sks);
                        } else {
                            System.out.println("Slot SKS Tidak Mencukupi Untuk Mengubah Mata Kuliah !!!");
                            System.out.println("Sisa Slot SKS : " + (KRS.maxSKS - KRS.getTotalSks()));
                        }
                        break;
                    } else if ((i + 1) == list.size()) {
                        System.out.println("Mata Kuliah Tidak Ditemukan");
                    }
                }
            } else if (piliih == 3) {
                System.out.print("\nMasukkan Mata Kuliah yang Ingin Dihapus : ");
                String hapus = in.nextLine();
                for (int i = 0; i < list.size(); i++) {
                    if (hapus.equals(list.get(i).getMatkul())) {
                        int kurang = 0 - list.get(i).getSks();
                        KRS.setTotalSks(kurang);
                        list.remove(i);
                        System.out.println("Mata Kuliah Berhasil Dihapus");
                    } else if ((i + 1) == list.size()) {
                        System.out.println("Mata Kuliah Tidak Ditemukan");
                    }
                }
            } else if (piliih == 4) {
                if (list.isEmpty()) {
                    System.out.println("Tidak Ada Data KRS");
                } else {
                    System.out.println("\t\t Data KRS");
                    System.out.printf("%-20s%5s\n", "Mata Kuliah", "SKS");
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).cetak();
                    }
                    System.out.printf("%-20s%5d\n", "Total SKS", KRS.getTotalSks());
                }

            } else if (piliih == 5) {
                System.out.println("Layanan KRS Berakhir");
                System.out.println("Logging Out...");
                break;
            }
        }
    }
}
