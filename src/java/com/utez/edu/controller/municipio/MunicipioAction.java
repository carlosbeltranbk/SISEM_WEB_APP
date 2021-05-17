/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.municipio;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author BELTRAN PC
 */
public class MunicipioAction {
    
    private BeanMunicipio beanMunicipio = new BeanMunicipio();
    private DaoMunicipio daoMunicipio = new DaoMunicipio();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();
    
    private String mensaje;
    
    /**
     * Getters y Setters de las variables y listas declaradas.
     * @return 
     */

    public BeanMunicipio getBeanMunicipio() {
        return beanMunicipio;
    }

    public void setBeanMunicipio(BeanMunicipio beanMunicipio) {
        this.beanMunicipio = beanMunicipio;
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
     * Dentro de este método se hace la consulta del dato requerido
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarMunicipios() {
        listaMunicipios = daoMunicipio.consultarMunicipios();
        return SUCCESS;
    }
    
}
