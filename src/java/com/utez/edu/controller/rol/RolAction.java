/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.rol;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.rol.DaoRol;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class RolAction {
    
    private BeanRol beanRol = new BeanRol();
    private DaoRol daoRol = new DaoRol();
    private List<BeanRol> listaRoles = new ArrayList();
    
    private String mensaje;
    
    /**
     * Getters y Setters de las variables y listas declaradas.
     * @return 
     */

    public BeanRol getBeanRol() {
        return beanRol;
    }

    public void setBeanRol(BeanRol beanRol) {
        this.beanRol = beanRol;
    }

    public List<BeanRol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<BeanRol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    /* ----------------- METODOS ---------------------- */
    
    /**
     * Dentro de este método se hace la consulta de los roles
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarRoles() {
        listaRoles = daoRol.consultarRoles();
        return SUCCESS;
    }
    
}
