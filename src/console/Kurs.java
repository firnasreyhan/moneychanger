/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import java.util.ArrayList;

/**
 *
 * @author Rey
 */
public class Kurs {

    String mata_uang;
    double kurs_jual, kurs_beli, kurs_tengah;
    ArrayList<Kurs> kurs = new ArrayList<Kurs>();

    public Kurs(String mata_uang, double kurs_jual, double kurs_beli) {
        this.mata_uang = mata_uang;
        this.kurs_jual = kurs_jual;
        this.kurs_beli = kurs_beli;
        this.kurs_tengah = (kurs_jual + kurs_beli) / 2;
    }
}
