/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.acuerdos;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.edu.model.acuerdos.BeanAcuerdos;
import com.utez.edu.model.acuerdos.DaoAcuerdos;

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
public class AcuerdosAction implements ServletRequestAware{
    
    /**
     * Declaramos e instanciamos todas las variables y métodos a implementar.
     */

    HttpServletRequest servletRequest;

    private BeanAcuerdos beanAcuerdo = new BeanAcuerdos();
    private DaoAcuerdos daoAcuerdo= new DaoAcuerdos();

    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanAcuerdos> listaAcuerdos = new ArrayList();
    
    private String mensaje;
    
    /**
     * Creamos los getters and seatters de las variables declaradass
     * @return 
     */
    
   
    public BeanAcuerdos getBeanAcuerdo() {
        return beanAcuerdo;
    }

    public void setBeanAcuerdo(BeanAcuerdos beanAcuerdo) {
        this.beanAcuerdo = beanAcuerdo;
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

    public List<BeanAcuerdos> getListaAcuerdos() {
        return listaAcuerdos;
    }

    public void setListaAcuerdos(List<BeanAcuerdos> listaAcuerdos) {
        this.listaAcuerdos = listaAcuerdos;
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
    public String consultarAcuerdo(){
        listaAcuerdos = daoAcuerdo.consultarAcuerdos();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarAcuerdoId(){
         String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanAcuerdo = daoAcuerdo.consultarAcuerdoId(beanAcuerdo.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (beanAcuerdo != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    /**
     * Método para modificar un registro de la Stria de Acuerdos
     * @return SUCCESS
     * @return ERROR
     */
    public String modificarAcuerdo(){
        if (daoAcuerdo.modificarAcuerdo(beanAcuerdo)) {
            return SUCCESS;
        }else{
            mensaje="No se modificó correctamente la persona";
            return ERROR;
        }
    }
    
    /**
     * Método para implementar imagenes dinámicas
     * @param hsr 
     */
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
       this.servletRequest = hsr;
    }
    
}
