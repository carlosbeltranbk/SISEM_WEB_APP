/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.secretariaEstudio;

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
import com.utez.edu.model.secretariaEstudio.BeanSecretaria;
import com.utez.edu.model.secretariaEstudio.DaoSecretaria;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class EstudioyCuentaAction {
    
    private BeanSecretaria beanSecretaria = new BeanSecretaria();
    private DaoSecretaria daoSecretaria= new DaoSecretaria();
    
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    private List<BeanSecretaria> listaSecretarias = new ArrayList();
   
    private String mensaje;

    public BeanSecretaria getBeanSecretaria() {
        return beanSecretaria;
    }

    public void setBeanSecretaria(BeanSecretaria beanSecretaria) {
        this.beanSecretaria = beanSecretaria;
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

    public List<BeanSecretaria> getListaSecretarias() {
        return listaSecretarias;
    }

    public void setListaSecretarias(List<BeanSecretaria> listaSecretarias) {
        this.listaSecretarias = listaSecretarias;
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
    public String consultarSecretaria(){
        listaSecretarias = daoSecretaria.consultarSecretarias();
        return SUCCESS;
    }
    
    
    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarSecretariaId(){
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        DaoRol daoRol = new DaoRol();
        DaoPersona daoPersona = new DaoPersona();
        beanSecretaria = daoSecretaria.consultarSecretariaId(beanSecretaria.getPersona().getIdPersona());
        listaMunicipios = daoMunicipio.consultarMunicipios();
        listaRoles = daoRol.consultarRoles();
        if (beanSecretaria != null) {
            return SUCCESS;
        }else{
            mensaje = "No se encontró al sindico específica...";
            return ERROR;
        }
    }
    
    
    public String modificarSecretaria(){
        if (daoSecretaria.modificarSecreatia(beanSecretaria)) {
            return SUCCESS;
        }else{
            mensaje="No se modificó correctamente la persona";
            return ERROR;
        }
    }

    
    
}
