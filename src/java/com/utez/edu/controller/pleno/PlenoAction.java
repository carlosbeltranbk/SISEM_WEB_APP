/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.pleno;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.utez.edu.model.sindicoMunicipal.BeanSindicoMunicipal;
import com.utez.edu.model.sindicoMunicipal.DaoSindicoMunicipal;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;
import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;
import com.utez.edu.model.pleno.BeanPleno;
import com.utez.edu.model.pleno.DaoPleno;


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
public class PlenoAction implements ServletRequestAware{
    
    HttpServletRequest servletRequest;
    
    private BeanPleno beanPleno = new BeanPleno();
    private DaoPleno daoPleno= new DaoPleno();
    
    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanPleno> listaPlenos = new ArrayList();
    
    private String mensaje;

    public BeanPleno getBeanPleno() {
        return beanPleno;
    }

    public void setBeanPleno(BeanPleno beanPleno) {
        this.beanPleno = beanPleno;
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

    public List<BeanPleno> getListaPlenos() {
        return listaPlenos;
    }

    public void setListaPlenos(List<BeanPleno> listaPlenos) {
        this.listaPlenos = listaPlenos;
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
    public String consultarPleno(){
        listaPlenos = daoPleno.consultarPlenos();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarPlenoId(){
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanPleno = daoPleno.consultarPlenoId(beanPleno.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (beanPleno != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    
    public String modificarPleno(){
        if (daoPleno.modificarPleno(beanPleno)) {
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
