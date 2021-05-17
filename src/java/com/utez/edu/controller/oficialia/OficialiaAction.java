/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.oficialia;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.utez.edu.model.sindicoMunicipal.BeanSindicoMunicipal;
import com.utez.edu.model.sindicoMunicipal.DaoSindicoMunicipal;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;
import com.utez.edu.model.oficialia.BeanOficialia;
import com.utez.edu.model.oficialia.DaoOficialia;
import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;


import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.rol.DaoRol;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
/**
 *
 * @author BELTRAN PC
 */
public class OficialiaAction implements ServletRequestAware{
    
    /**
     * Declaramos las variables necesarias para 
     */
    
    HttpServletRequest servletRequest;
    
    private BeanOficialia beanOficialia = new BeanOficialia();
    private DaoOficialia daoOficialia= new DaoOficialia();
    
    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanOficialia> listaOficialias = new ArrayList();
    
    private String mensaje;

    public BeanOficialia getBeanOficialia() {
        return beanOficialia;
    }

    public void setBeanOficialia(BeanOficialia beanOficialia) {
        this.beanOficialia = beanOficialia;
    }

    public List<BeanPersona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<BeanPersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public List<BeanRol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<BeanRol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public List<BeanMunicipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<BeanMunicipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<BeanOficialia> getListaOficialias() {
        return listaOficialias;
    }

    public void setListaOficialias(List<BeanOficialia> listaOficialias) {
        this.listaOficialias = listaOficialias;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
     /* ----------------- METODOS ---------------------- */
    
    /**
     * Dentro de este método se hace la consulta de los sindicos
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarOficialia(){
        listaOficialias = daoOficialia.consultarOficialias();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarOficialiaId(){
         String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanOficialia = daoOficialia.consultarOficialiaId(beanOficialia.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (beanOficialia != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    
    public String modificarOficialia(){
        if (daoOficialia.modificarOficialia(beanOficialia)) {
            return SUCCESS;
        }else{
            mensaje="No se modificó correctamente la persona";
            return ERROR;
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
       this.servletRequest = hsr;
    }

    
}
