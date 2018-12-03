/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import console.*;

/**
 *
 * @author Rey
 */
public class Stok_Helper {

    String mata_uang;
    int stok_ratusan, stok_puluhan, stok_satuan;

    public Stok_Helper(String mata_uang, int stok_ratusan, int stok_puluhan, int stok_satuan) {
        this.mata_uang = mata_uang;
        this.stok_ratusan = stok_ratusan;
        this.stok_puluhan = stok_puluhan;
        this.stok_satuan = stok_satuan;
    }
}
