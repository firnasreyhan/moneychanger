/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Rey
 */
public class Kurs_Helper {

    String mata_uang;
    float kurs_jual, kurs_beli, kurs_tengah;

    public Kurs_Helper(String mata_uang, float kurs_jual, float kurs_tengah, float kurs_beli) {
        this.mata_uang = mata_uang;
        this.kurs_jual = kurs_jual;
        this.kurs_beli = kurs_beli;
        this.kurs_tengah = kurs_tengah;
    }
}
