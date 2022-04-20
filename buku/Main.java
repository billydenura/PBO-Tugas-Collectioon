package com.company.tuugasColections.buku;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        welcomeMenu();

        Scanner in = new Scanner(System.in);
        ArrayList<bukuCollec> list = new ArrayList<bukuCollec>();


        for(;;){
            menu();
            String pilih = in.nextLine();
            int piliih = Integer.parseInt(pilih);
            if (piliih==1){
                System.out.print("\nMasukkan Judul Buku\t\t: ");
                String judul = in.nextLine();
                System.out.print("Masukkan Penulis Buku\t: ");
                String penulis = in.nextLine();
                list.add(new bukuCollec(judul,penulis));
            }
            else if (piliih==2){
                //print
                System.out.print("\nMasukkan Judul Buku yang Ingin Dibuang : ");
                String buang = in.nextLine();
                for(int i=0;i<list.size();i++){
                    if(buang.equals(list.get(i).getJudul())){
                        list.remove(i);
                        System.out.println("Buku Berhasil Dibuang");
                    }else if((i+1)==list.size()){
                        System.out.println("Buku Tidak Ditemukan");
                    }
                }
            }
            else if (piliih==3){
                System.out.print("\nMasukkan Judul Buku yang Ingin Diedit   : ");
                String edit = in.nextLine();
                for(int i=0;i<list.size();i++){
                    if(edit.equals(list.get(i).getJudul())){
                        System.out.print("Masukkan Judul Buku Baru   : ");
                        String judulBaru = in.nextLine();
                        System.out.print("Masukkan Penulis Buku Baaru : ");
                        String penulisBaru = in.nextLine();
                        list.set(i,new bukuCollec(judulBaru,penulisBaru));
                    }else if((i+1)==list.size()){
                        System.out.println("Buku Tidak Ditemukan");
                    }
                }
            }
            else if (piliih==4){
                if (list.isEmpty()){
                    System.out.println("Tidak Ada Buku di Dalam Daftar");
                }
                else {
                    System.out.println("Daftar Buku Anda :");
                    for(int i=0;i<list.size();i++){
                        System.out.println("\n"+(i+1)+".");
                        list.get(i).cetakData();
                    }
                }
            }
            else if (piliih==5){
                System.out.println("Layanan BILL's Books Management Berakhir");
                break;
            }
        }
    }

    static void welcomeMenu(){
        System.out.println("\nSelamat Datang di BILL's Books Management");
        System.out.println("Silahkan Pilih Menu :");
    }

    static void menu(){
        System.out.println("\n1. Tambah Buku");
        System.out.println("2. Buang Buku");
        System.out.println("3. Edit Buku");
        System.out.println("4. Cetak Daftar Buku");
        System.out.println("5. Keluar");
        System.out.println("Masukan Pilihan dalam Bentuk Angka!!");
    }
}
