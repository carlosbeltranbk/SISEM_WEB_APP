/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.fiscalia;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.utez.edu.model.fiscalia.BeanFiscalia;
import com.utez.edu.model.fiscalia.DaoFiscalia;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author BELTRAN PC
 */

public class FiscaliaAction implements ServletRequestAware{
    
    HttpServletRequest servletRequest;
    
    private BeanFiscalia beanFiscalia = new BeanFiscalia();
    private DaoFiscalia daoFiscalia= new DaoFiscalia();
    
    private List<BeanFiscalia> listaFiscalias = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanPersona> listaPersonas = new ArrayList();
    
    private String mensaje;
    
    /**
     * Getters y Setters de las variables y listas declaradas.
     * @return 
     */

    public BeanFiscalia getBeanFiscalia() {
        return beanFiscalia;
    }

    public void setBeanFiscalia(BeanFiscalia beanFiscalia) {
        this.beanFiscalia = beanFiscalia;
    }

    public List<BeanFiscalia> getListaFiscalias() {
        return listaFiscalias;
    }

    public void setListaFiscalias(List<BeanFiscalia> listaFiscalias) {
        this.listaFiscalias = listaFiscalias;
    }

    public List<BeanMunicipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<BeanMunicipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<BeanPersona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<BeanPersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    /* ----------------- METODOS ---------------------- */
    
    /**
     * Dentro de este método se hace la consulta de las fiscalias
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarFiscalias(){
        listaFiscalias = daoFiscalia.consultarFiscalias();
        return SUCCESS;
    }
    
    /**
     * Dentro de este método se hace la eliminación de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String eliminarFiscalia(){
        if (daoFiscalia.eliminarFiscalia(beanFiscalia.getIdFiscalia())) {
            return SUCCESS;
        }else{
            mensaje = "No se eliminó correctamente la fiscalia...";
            return ERROR;
        }
    }
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarFiscaliaId(){
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoPersona daoPersona = new DaoPersona();
        
        beanFiscalia = daoFiscalia.consultarFiscaliaId(beanFiscalia.getIdFiscalia());
        
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        
        if (beanFiscalia != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró la fiscalia específico...";
            return ERROR;
        }
    }
    
    /**
     * Dentro de este método se hace la modificación de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String modificarFiscalia(){
        if (daoFiscalia.modificarFiscalia(beanFiscalia)) {
            return SUCCESS;
        }else{
            mensaje="No se modificó correctamente la fiscalia";
            return ERROR;
        }
    }
    
    /**
     * Dentro de este método se registra correctamente un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String registrarFiscalia(){
        boolean resultado = daoFiscalia.registrarFiscalia(beanFiscalia);
        if (resultado) {
            return SUCCESS;
        }else{
            mensaje="No se registró correctamente el usuario";
            return ERROR;
        }
    }
    
    /**
     * Este método hace referencia para pre-cargar los datos de los beans externos
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String nuevaFiscalia(){
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoPersona daoPersona = new DaoPersona();
        
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        
        return SUCCESS;
    }
    
    /**
     * 
     * @param hsr 
     */
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
       this.servletRequest = hsr;
    }

}
