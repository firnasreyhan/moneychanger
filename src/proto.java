
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Rey
 */
public class proto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        String[] nama_mu = new String[50];
        double[][] kurs_mu = new double[50][3];
        int[][] stock_pecahan = new int[50][3];

        int pilih_menu, pilih_sub_menu, pilih_menu_transaksi, pilih_mu_awal, pilih_mu_tukar, pilih_index,
                ratusan_masuk, puluhan_masuk, satuan_masuk,
                ratusan_keluar, puluhan_keluar, satuan_keluar;
        double mu_awal, mu_tukar, mu_temp, temp_mu_tukar;
        char ulang;

        String[] temp_nama_mu = {"IDR", "USD", "GBP", "EUR", "AUD"};
        double[][] temp_kurs_mu = {{0, 0, 0},
        {14000, 13000, 13500},
        {18839, 18648, 18744},
        {16560, 16390, 16475},
        {10709, 10601, 10655}};

        for (int x = 0; x < temp_kurs_mu.length; x++) {
            nama_mu[x] = temp_nama_mu[x];
            for (int y = 0; y < temp_kurs_mu[0].length; y++) {
                kurs_mu[x][y] = temp_kurs_mu[x][y];
                stock_pecahan[x][y] = 100;
            }
        }

        do {
            pilih_index = 0;
            pilih_menu = 0;
            pilih_sub_menu = 0;
            pilih_menu_transaksi = 0;
            pilih_mu_awal = 0;
            pilih_mu_tukar = 0;
            ulang = 't';
            System.out.println("================================ Menu ================================");
            System.out.println("1.\tKurs Mata Uang Terkini");
            System.out.println("2.\tKelola Kurs Mata Uang");
            System.out.println("3.\tTransaksi");
            System.out.println("4.\tKeluar");
            pilih_menu = ulang_f(sc, pilih_menu, 1, 4);
            System.out.println("");
            switch (pilih_menu) {
                case 1:
                    tampil_kurs(nama_mu, kurs_mu);
                    ulang = f_ulang(sc, ulang);
                    break;
                case 2:
                    do {
                        ulang = 't';
                        System.out.println("======================== Kelola Kurs Mata Uang =======================");
                        System.out.println("1.\tTambah Mata Uang");
                        System.out.println("2.\tUpdate Mata Uang");
                        System.out.println("3.\tHapus Mata Uang");
                        System.out.println("4.\tList Mata Uang");
                        System.out.println("5.\tKembali");
                        pilih_sub_menu = ulang_f(sc, pilih_sub_menu, 1, 5);
                        switch (pilih_sub_menu) {
                            case 1:
                                for (int i = 0; i < nama_mu.length; i++) {
                                    if (nama_mu[i] == null) {
                                        System.out.println("======================================================================");
                                        System.out.print("Masukkan kode mata uang : ");
                                        nama_mu[i] = sc.next().toUpperCase();
                                        kurs_mu[i][0] = f_ulang_f(sc, 1, "Masukkan kurs jual : ");
                                        kurs_mu[i][1] = f_ulang_f(sc, 1, "Masukkan kurs beli : ");
                                        kurs_mu[i][2] = Math.floor(((kurs_mu[i][0] + kurs_mu[i][1]) / 2) * 100) / 100;
                                        stock_pecahan[i][0] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang ratusan : ");
                                        stock_pecahan[i][1] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang puluhan : ");
                                        stock_pecahan[i][2] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang satuan : ");
                                        System.out.println("");
                                        System.out.println("Kurs " + nama_mu[i] + " berhasil ditambahkan");
                                        break;
                                    }
                                }
                                ulang = f_ulang(sc, ulang);
                                break;
                            case 2:
                                tampil_kurs(nama_mu, kurs_mu);
                                pilih_index = ulang_f(sc, pilih_index, 1, (jml_data(nama_mu) - 1));
                                System.out.println("Anda memilih : " + nama_mu[pilih_index]);
                                System.out.println("======================================================================");
                                System.out.println("1.\tUbah kode mata uang");
                                System.out.println("2.\tUbah kurs jual");
                                System.out.println("3.\tUbah kurs beli");
                                System.out.println("4.\tKembali");
                                pilih_sub_menu = ulang_f(sc, pilih_sub_menu, 1, 4);
                                switch (pilih_sub_menu) {
                                    case 1:
                                        System.out.print("Masukkan kode mata uang : ");
                                        nama_mu[pilih_index] = sc.next().toUpperCase();
                                        System.out.println("Data berhasil diubah");
                                        break;
                                    case 2:
                                        kurs_mu[pilih_index][0] = f_ulang_f(sc, 1, "Masukkan kurs jual : ");
                                        kurs_mu[pilih_index][2] = Math.floor(((kurs_mu[pilih_index][0] + kurs_mu[pilih_index][1]) / 2) * 100) / 100;
                                        System.out.println("Data berhasil diubah");
                                        break;
                                    case 3:
                                        kurs_mu[pilih_index][1] = f_ulang_f(sc, 1, "Masukkan kurs beli : ");
                                        kurs_mu[pilih_index][2] = Math.floor(((kurs_mu[pilih_index][0] + kurs_mu[pilih_index][1]) / 2) * 100) / 100;
                                        System.out.println("Data berhasil diubah");
                                        break;
                                }
                                ulang = f_ulang(sc, ulang);
                                break;
                            case 3:
                                tampil_kurs(nama_mu, kurs_mu);
                                pilih_index = ulang_f(sc, pilih_index, 1, (jml_data(nama_mu) - 1));
                                System.out.println("Kurs " + nama_mu[pilih_index] + " telah dihapus!");
                                nama_mu[pilih_index] = null;
                                for (int i = 0; i < kurs_mu[0].length; i++) {
                                    kurs_mu[pilih_index][i] = 0;
                                    stock_pecahan[pilih_index][i] = 0;
                                }
                                for (int i = pilih_index; i < nama_mu.length - 1; i++) {
                                    nama_mu[i] = nama_mu[(i + 1)];
                                    for (int j = 0; j < kurs_mu[0].length; j++) {
                                        kurs_mu[i][j] = kurs_mu[(i + 1)][j];
                                        stock_pecahan[i][j] = stock_pecahan[(i + 1)][j];
                                    }
                                }
                                ulang = f_ulang(sc, ulang);
                                break;
                            case 4:
                                tampil_kurs(nama_mu, kurs_mu);
                                ulang = f_ulang(sc, ulang);
                                break;
                        }
                    } while (ulang == 'y' || ulang == 'Y');
                    break;
                case 3:
                    do {
                        ratusan_keluar = 0;
                        puluhan_keluar = 0;
                        satuan_keluar = 0;
                        ulang = 't';
                        pilih_sub_menu = 0;
                        System.out.println("============================= Transaksi ==============================");
                        System.out.println("1.\tKelola Pecahan");
                        System.out.println("2.\tTukar Mata Uang");
                        System.out.println("3.\tKembali");
                        pilih_menu_transaksi = ulang_f(sc, pilih_menu_transaksi, 1, 3);
                        switch (pilih_menu_transaksi) {
                            case 1:
                                System.out.println("=========================== Kelola Pecahan ===========================");
                                System.out.println("No.\t| Mata Uang\t| Ratusan\t| Puluhan\t| Satuan");
                                System.out.println("======================================================================");
                                for (int x = 0; x < kurs_mu.length; x++) {
                                    if (nama_mu[x] != null) {
                                        System.out.println((x + 1) + ".\t| " + nama_mu[x] + "\t\t| " + stock_pecahan[x][0] + "\t\t| " + stock_pecahan[x][1] + "\t\t| " + stock_pecahan[x][2]);
                                    }
                                }
                                pilih_index = ulang_f(sc, pilih_index, 1, jml_data(nama_mu)) - 1;
                                System.out.println("Anda memilih : " + nama_mu[pilih_index]);
                                System.out.println("======================================================================");
                                System.out.println("1. Ubah Stok Ratusan");
                                System.out.println("2. Ubah Stok Puluhan");
                                System.out.println("3. Ubah Stok Satuan");
                                System.out.println("4. Kembali");
                                pilih_sub_menu = ulang_f(sc, pilih_sub_menu, 1, 4);
                                switch (pilih_sub_menu) {
                                    case 1:
                                        stock_pecahan[pilih_index][0] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang ratusan : ");
                                        System.out.println("Data berhasil diubah");
                                        ulang = f_ulang(sc, ulang);
                                        break;
                                    case 2:
                                        stock_pecahan[pilih_index][1] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang puluhan : ");
                                        System.out.println("Data berhasil diubah");
                                        ulang = f_ulang(sc, ulang);
                                        break;
                                    case 3:
                                        stock_pecahan[pilih_index][2] = (int) f_ulang_f(sc, 0, "Masukkan stok pecahan uang satuan : ");
                                        System.out.println("Data berhasil diubah");
                                        ulang = f_ulang(sc, ulang);
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("========================== Tukar Mata Uang ===========================");
                                for (int x = 0; x < kurs_mu.length; x++) {
                                    if (nama_mu[x] != null) {
                                        System.out.println((x + 1) + ". " + nama_mu[x]);
                                    }
                                }
                                pilih_mu_awal = ulang_f(sc, pilih_mu_awal, 1, jml_data(nama_mu));
                                do {
                                    System.out.print("Masukkan uang anda (" + nama_mu[pilih_mu_awal - 1] + ") = ");
                                    mu_awal = sc.nextDouble();
                                    if (mu_awal < 1) {
                                        System.out.println("Mohon maaf, uang anda kurang");
                                    }
                                } while (mu_awal < 1);
                                System.out.println("======================================================================");
                                do {
                                    System.out.print("Pilih mata uang tukar : ");
                                    pilih_mu_tukar = sc.nextInt();
                                    if (pilih_mu_awal == pilih_mu_tukar) {
                                        System.out.println("Anda menukar dengan mata uang yang sama!");
                                    } else if (pilih_mu_tukar < 1 || pilih_mu_tukar > jml_data(nama_mu)) {
                                        System.out.println("Mohon maaf, inputan anda salah");
                                    }
                                } while (pilih_mu_awal == pilih_mu_tukar || pilih_mu_tukar < 1 || pilih_mu_tukar > jml_data(nama_mu));

                                if (pilih_mu_awal == 1 && pilih_mu_tukar != 1) {
                                    mu_tukar = mu_awal / kurs_mu[pilih_mu_tukar - 1][0];
                                } else if (pilih_mu_awal != 1 && pilih_mu_tukar == 1) {
                                    mu_tukar = mu_awal * kurs_mu[pilih_mu_awal - 1][1];
                                } else {
                                    mu_temp = mu_awal * kurs_mu[pilih_mu_awal - 1][2];
                                    mu_tukar = mu_temp / kurs_mu[pilih_mu_tukar - 1][2];
                                }
                                System.out.println("======================================================================");
                                System.out.println("Hasil tukar : " + df.format(mu_tukar) + " " + nama_mu[pilih_mu_tukar - 1]);
                                System.out.println("======================================================================");
                                if (pilih_mu_tukar == 1) {
                                    mu_tukar = mu_tukar / 1000;
                                }
                                
                                temp_mu_tukar = mu_tukar;
                                
                                if (pilih_mu_awal == 1) {
                                    mu_awal = mu_awal / 1000;
                                }

                                ratusan_masuk = (int) mu_awal / 100;
                                mu_awal = mu_awal % 100;
                                puluhan_masuk = (int) mu_awal / 10;
                                mu_awal = mu_awal % 10;
                                satuan_masuk = (int) mu_awal / 1;

                                if (temp_mu_tukar >= 100) {
                                    if (stock_pecahan[pilih_mu_tukar - 1][0] != 0) {
                                        ratusan_keluar = (int) temp_mu_tukar / 100;
                                        temp_mu_tukar = temp_mu_tukar % 100;
                                        if (ratusan_keluar > stock_pecahan[pilih_mu_tukar - 1][0]) {
                                            temp_mu_tukar = temp_mu_tukar + ((ratusan_keluar - stock_pecahan[pilih_mu_tukar - 1][0]) * 100);
                                            ratusan_keluar = stock_pecahan[pilih_mu_tukar - 1][0];
                                        }
                                    } else {
                                        ratusan_keluar = 0;
                                    }
                                }
                                if (temp_mu_tukar >= 10) {
                                    if (stock_pecahan[pilih_mu_tukar - 1][1] != 0) {
                                        puluhan_keluar = (int) temp_mu_tukar / 10;
                                        temp_mu_tukar = temp_mu_tukar % 10;
                                        if (puluhan_keluar > stock_pecahan[pilih_mu_tukar - 1][1]) {
                                            temp_mu_tukar = temp_mu_tukar + ((puluhan_keluar - stock_pecahan[pilih_mu_tukar - 1][1]) * 10);
                                            puluhan_keluar = stock_pecahan[pilih_mu_tukar - 1][1];
                                        }
                                    } else {
                                        puluhan_keluar = 0;
                                    }
                                }
                                if (temp_mu_tukar >= 1) {
                                    if (stock_pecahan[pilih_mu_tukar - 1][2] != 0) {
                                        satuan_keluar = (int) temp_mu_tukar / 1;
                                        if (satuan_keluar > stock_pecahan[pilih_mu_tukar - 1][2]) {
                                            satuan_keluar = stock_pecahan[pilih_mu_tukar - 1][2];
                                        }
                                    } else {
                                        satuan_keluar = 0;
                                    }
                                }

                                temp_mu_tukar = (ratusan_keluar * 100) + (puluhan_keluar * 10) + satuan_keluar;
                                
                                if (temp_mu_tukar == (int) mu_tukar) {
                                    stock_pecahan[pilih_mu_awal - 1][0] = stock_pecahan[pilih_mu_awal - 1][0] + ratusan_masuk;
                                    stock_pecahan[pilih_mu_awal - 1][1] = stock_pecahan[pilih_mu_awal - 1][1] + puluhan_masuk;
                                    stock_pecahan[pilih_mu_awal - 1][2] = stock_pecahan[pilih_mu_awal - 1][2] + satuan_masuk;
                                    stock_pecahan[pilih_mu_tukar - 1][0] = stock_pecahan[pilih_mu_tukar - 1][0] - ratusan_keluar;
                                    stock_pecahan[pilih_mu_tukar - 1][1] = stock_pecahan[pilih_mu_tukar - 1][1] - puluhan_keluar;
                                    stock_pecahan[pilih_mu_tukar - 1][2] = stock_pecahan[pilih_mu_tukar - 1][2] - satuan_keluar;
                                    System.out.println("Anda mendapat : ");
                                    if (ratusan_keluar != 0) {
                                        System.out.println(ratusan_keluar + " pecahan ratusan");
                                    }
                                    if (puluhan_keluar != 0) {
                                        System.out.println(puluhan_keluar + " pecahan puluhan");
                                    }
                                    if (satuan_keluar != 0) {
                                        System.out.println(satuan_keluar + " pecahan satuan");
                                    }
                                    System.out.println("======================================================================");
                                    if (pilih_mu_tukar == 1) {
                                        System.out.println("Sisa uang anda sebesar : " + ((int) (mu_tukar * 1000) - (temp_mu_tukar * 1000)) + " " + nama_mu[pilih_mu_tukar - 1]);
                                    } else {
                                        System.out.println("Sisa uang anda sebesar : " + df.format(mu_tukar - (double) temp_mu_tukar) + " " + nama_mu[pilih_mu_tukar - 1]);
                                    }
                                } else {
                                    System.out.println("Mohon maaf, stok uang kami tidak cukup");
                                }
                                ulang = f_ulang(sc, ulang);
                                break;
                        }
                    } while (pilih_sub_menu == 4 || ulang == 'y' || ulang == 'Y');
                    break;
            }
            System.out.println("");
        } while (ulang == 'y' || ulang == 'Y' || pilih_sub_menu == 5 || pilih_menu_transaksi == 3);
        System.out.println("Keluar program!");
    }

    public static void tampil_kurs(String[] nama, double[][] kurs) {
        System.out.println("=========================== Kurs Mata Uang ===========================");
        System.out.println("No.\t| Mata Uang\t| Kurs Jual\t| Kurs Beli\t| Kurs Tengah");
        System.out.println("======================================================================");
        for (int x = 0; x < kurs.length; x++) {
            if (nama[x] != null && nama[x] != "IDR") {
                System.out.print(x + "\t| " + nama[x] + "\t");
                for (int y = 0; y < kurs[0].length; y++) {
                    System.out.print("\t| " + kurs[x][y] + " IDR");
                }
                System.out.println("");
            }
        }
    }

    public static int jml_data(String[] array) {
        int n;
        n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                n++;
            }
        }
        return n;
    }

    public static char f_ulang(Scanner sc, char ulang) {
        do {
            System.out.println("======================================================================");
            System.out.print("Kembali ke menu awal?(Y/T) ");
            ulang = sc.next().charAt(0);
            if (ulang != 'y' && ulang != 't') {
                System.out.println("Mohon maaf, inputan anda salah");
            }
        } while (ulang != 'y' && ulang != 't' && ulang != 'Y' && ulang != 'T');
        return ulang;
    }

    public static int ulang_f(Scanner sc, int pilih, int a, int b) {
        do {
            System.out.println("======================================================================");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            if (pilih < a || pilih > b) {
                System.out.println("Mohon maaf, inputan anda salah");
            }
        } while (pilih < a || pilih > b);
        return pilih;
    }

    public static double f_ulang_f(Scanner sc, int a, String teks) {
        double angka;
        do {
            System.out.print(teks);
            angka = sc.nextDouble();
            if (angka < a) {
                System.out.println("Mohon maaf, inputan anda salah");
            }
        } while (angka < a);
        return angka;
    }
}