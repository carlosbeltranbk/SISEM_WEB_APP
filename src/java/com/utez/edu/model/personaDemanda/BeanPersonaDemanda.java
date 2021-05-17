/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.personaDemanda;

import com.utez.edu.model.demanda.BeanDemanda;
import com.utez.edu.model.persona.BeanPersona;

/**
 *
 * @author BELTRAN PC
 */
public class BeanPersonaDemanda {
    
    private boolean estado;
    private BeanDemanda idDemanda;
    private BeanPersona idPersona;

    public BeanPersonaDemanda() {
    }

    public BeanPersonaDemanda(boolean estado, BeanDemanda idDemanda, BeanPersona idPersona) {
        this.estado = estado;
        this.idDemanda = idDemanda;
        this.idPersona = idPersona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BeanDemanda getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(BeanDemanda idDemanda) {
        this.idDemanda = idDemanda;
    }

    public BeanPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BeanPersona idPersona) {
        this.idPersona = idPersona;
    }
    
    

   
    
    
}
