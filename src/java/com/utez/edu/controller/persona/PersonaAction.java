/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.persona;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author BELTRAN PC
 */
public class PersonaAction implements ServletRequestAware{
    
    HttpServletRequest servletRequest;

    private BeanPersona beanPersona = new BeanPersona();
    private DaoPersona daoPersona = new DaoPersona();

    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();

    private String mensaje;
    
     @Override
    public void setServletRequest(HttpServletRequest hsr) {
       this.servletRequest = hsr;
    }

    /**
     * Getters y Setters de las variables y listas declaradas.
     *
     * @return
     */
    public BeanPersona getBeanPersona() {
        return beanPersona;
    }

    public void setBeanPersona(BeanPersona beanPersona) {
        this.beanPersona = beanPersona;
    }

    public List<BeanPersona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<BeanPersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
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

    /* ----------------- METODOS ---------------------- */
    /**
     * Dentro de este método se hace la consulta de las personas
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarPersona() {
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (cargarImg() == 1) {
            return SUCCESS;
        } else {
            cargarImg();
        }
        return SUCCESS;
    }

    public int cargarImg() {
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        listaPersonas = daoPersona.consultarPersonas(filePath);
        if (listaPersonas != null) {
            return 1;
        } else {
            mensaje = "No se encuentran registradas categorias";
            return 2;
        }
    }

    /**
     * Dentro de este método se hace la eliminación de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String eliminarPersona() {
        if (daoPersona.eliminarPersona(beanPersona.getIdPersona())) {
            return SUCCESS;
        } else {
            mensaje = "No se eliminó correctamente la persona...";
            return ERROR;
        }
    }

    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarPersonaId() {
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        beanPersona = daoPersona.consultarPersonaId(beanPersona.getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        if (beanPersona != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontró la persona específica...";
            return ERROR;
        }
    }

    /**
     * Dentro de este método se hace la modificación de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String modificarPersona() {
        if (daoPersona.modificarPersona(beanPersona)) {
            return SUCCESS;
        } else {
            mensaje = "No se modificó correctamente la persona";
            return ERROR;
        }
    }

    /**
     * Dentro de este método se registra correctamente un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String registrarPersona() {
        boolean resultado = daoPersona.registrarPersona(beanPersona);
        if (resultado) {
            return SUCCESS;
        } else {
            mensaje = "No se registró correctamente la persona";
            return ERROR;
        }
    }

    /**
     * Cargamos las listas de las llaves foraneas
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String nuevaPersona() {
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        listaMunicipios = daoMunicipio.consultarMunicipios();
        return SUCCESS;
    }

   

}
