/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.sindicoMunicipal;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.utez.edu.model.sindicoMunicipal.BeanSindicoMunicipal;
import com.utez.edu.model.sindicoMunicipal.DaoSindicoMunicipal;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;
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
public class SindicoAction implements ServletRequestAware{
    
    HttpServletRequest servletRequest;
    
    private BeanSindicoMunicipal beanSindico = new BeanSindicoMunicipal();
    private DaoSindicoMunicipal daoSindico= new DaoSindicoMunicipal();
    
    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanSindicoMunicipal> listaSindicos = new ArrayList();
    
    private String mensaje;

    
    
    public List<BeanPersona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * Getters y Setters de las variables y listas declaradas.
     * @return 
     */
    public void setListaPersonas(List<BeanPersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public BeanSindicoMunicipal getBeanSindico() {
        return beanSindico;
    }

    public void setBeanSindico(BeanSindicoMunicipal beanSindico) {
        this.beanSindico = beanSindico;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<BeanSindicoMunicipal> getListaSindicos() {
        return listaSindicos;
    }

    public void setListaSindicos(List<BeanSindicoMunicipal> listaSindicos) {
        this.listaSindicos = listaSindicos;
    }
    
    
    
     /* ----------------- METODOS ---------------------- */
    
    /**
     * Dentro de este método se hace la consulta de los sindicos
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarSindico(){
        listaSindicos = daoSindico.consultarSindicos();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarSindicoId(){
         String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanSindico = daoSindico.consultarSindicoId(beanSindico.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (beanSindico != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    
    public String modificarSindico(){
        if (daoSindico.modificarSindico(beanSindico)) {
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
