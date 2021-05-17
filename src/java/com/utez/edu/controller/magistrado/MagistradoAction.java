/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.magistrado;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.edu.model.magistrado.BeanMagistrado;
import com.utez.edu.model.magistrado.DaoMagistrado;

import com.utez.edu.model.magistrado.BeanMagistrado;
import com.utez.edu.model.magistrado.DaoMagistrado;

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
public class MagistradoAction implements ServletRequestAware{
    
    /**
     * Declaramos las variables necesarias para los métodos correspondientes
     */
    
    HttpServletRequest servletRequest;
    
    private BeanMagistrado beanMagistrado = new BeanMagistrado();
    private DaoMagistrado daoMagistrado= new DaoMagistrado();
    
    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanMagistrado> listaMagistrados = new ArrayList();
    
    private String mensaje;

    public BeanMagistrado getBeanMagistrado() {
        return beanMagistrado;
    }

    public void setBeanMagistrado(BeanMagistrado beanMagistrado) {
        this.beanMagistrado = beanMagistrado;
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

    public List<BeanMagistrado> getListaMagistrados() {
        return listaMagistrados;
    }

    public void setListaMagistrados(List<BeanMagistrado> listaMagistrados) {
        this.listaMagistrados = listaMagistrados;
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
    public String consultarMaigstrado(){
        listaMagistrados = daoMagistrado.consultarMagistrados();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarMagistradoId(){
         String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanMagistrado = daoMagistrado.consultarMagistradId(beanMagistrado.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (beanMagistrado != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    /**
     * Método para modificar un registro del magistrado
     * @return ERROR
     * @return SUCCESS
     */
    public String modificarMagistrado(){
        if (daoMagistrado.modificarMagistrado(beanMagistrado)) {
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
