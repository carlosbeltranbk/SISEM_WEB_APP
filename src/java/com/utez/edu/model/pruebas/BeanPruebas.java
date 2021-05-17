/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.pruebas;

import com.utez.edu.model.demanda.BeanDemanda;
import java.io.FileInputStream;

/**
 *
 * @author BELTRAN PC
 */
public class BeanPruebas {
    
    private int idPruebas;
    private FileInputStream prueba;
    private BeanDemanda demanda;

    public BeanPruebas(int idPruebas, FileInputStream prueba, BeanDemanda demanda) {
        this.idPruebas = idPruebas;
        this.prueba = prueba;
        this.demanda = demanda;
    }

    public BeanPruebas() {
    }

    public int getIdPruebas() {
        return idPruebas;
    }

    public void setIdPruebas(int idPruebas) {
        this.idPruebas = idPruebas;
    }

    public FileInputStream getPrueba() {
        return prueba;
    }

    public void setPrueba(FileInputStream prueba) {
        this.prueba = prueba;
    }

    public BeanDemanda getDemanda() {
        return demanda;
    }

    public void setDemanda(BeanDemanda demanda) {
        this.demanda = demanda;
    } 
}
