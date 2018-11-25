package console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rey
 */
public class Main {

    String mata_uang;
    double kurs_jual, kurs_beli, kurs_tengah;
    int stok_ratusan, stok_puluhan, stok_satuan;

    public Main(String mata_uang, double kurs_jual, double kurs_beli) {
        this.mata_uang = mata_uang;
        this.kurs_jual = kurs_jual;
        this.kurs_beli = kurs_beli;
        this.kurs_tengah = (kurs_jual + kurs_beli) / 2;
    }

    public Main(int stok_ratusan, int stok_puluhan, int stok_satuan) {
        this.stok_ratusan = stok_ratusan;
        this.stok_puluhan = stok_puluhan;
        this.stok_satuan = stok_satuan;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        ArrayList<Main> kurs = new ArrayList<Main>();
        ArrayList<Main> stok = new ArrayList<Main>();
        int pilih_menu, pilih_submenu;

        kurs.add(new Main("IDR", 0, 0));
        kurs.add(new Main("USD", 14625.00, 14479.00));
        kurs.add(new Main("SGD", 10654.19, 10543.98));
        kurs.add(new Main("AUD", 10604.59, 10497.28));
        kurs.add(new Main("EUR", 16688.59, 16517.64));
        kurs.add(new Main("GBP", 18837.00, 18647.50));
        kurs.add(new Main("JPY", 129.49, 129.49));

        System.out.println("================================ 1Menu1 ================================");
        System.out.println("1.\tKurs Mata Uang Terkini");
        System.out.println("2.\tKelola Kurs Mata Uang");
        System.out.println("3.\tTransaksi");
        System.out.println("4.\tKeluar");
        System.out.println("======================================================================");
        System.out.print("Pilih : ");
        pilih_menu = sc.nextInt();
        switch (pilih_menu) {
            case 1:
                System.out.println("=========================== Kurs Mata Uang ===========================");
                System.out.println("No.\t| Mata Uang\t| Kurs Jual\t| Kurs Beli\t| Kurs Tengah");
                System.out.println("======================================================================");
                for (int x = 0; x < kurs.size(); x++) {
                    if (kurs.get(x) != null && kurs.get(x).mata_uang != "IDR") {
                        System.out.println(x + "\t| "
                                + kurs.get(x).mata_uang + "\t\t| "
                                + df.format(kurs.get(x).kurs_jual) + " IDR\t| "
                                + df.format(kurs.get(x).kurs_beli) + " IDR\t| "
                                + df.format(kurs.get(x).kurs_tengah) + " IDR"
                        );
                    }
                }
                break;
            case 2:
                System.out.println("======================== Kelola Kurs Mata Uang =======================");
                System.out.println("1.\tTambah Mata Uang");
                System.out.println("2.\tUpdate Mata Uang");
                System.out.println("3.\tHapus Mata Uang");
                System.out.println("4.\tList Mata Uang");
                System.out.println("5.\tKembali");
                System.out.println("======================================================================");
                System.out.print("Pilih : ");
                pilih_submenu = sc.nextInt();
                switch(pilih_submenu) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 3:
                System.out.println("============================= Transaksi ==============================");
                System.out.println("1.\tKelola Pecahan");
                System.out.println("2.\tTukar Mata Uang");
                System.out.println("3.\tKembali");
                break;
            case 4:
                break;
        }
    }
}
