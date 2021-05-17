/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.login;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.model.usuarioLogin.DaoUsuarioLogin;
import java.util.Map;

/**
 *
 * @author BELTRAN PC
 */
public class ActionLogin {

    /**
     * @param: dao Dato con instancia al objeto administrador.
     * @param: bean Dato con instancia a los metodos del objeto administrador.
     * @param: beanA Dato con instancia a los metodos del objeto administrador.
     * @param: session Almacena los datos del usuario que inicio sesion.
     */
    private DaoUsuarioLogin dao = new DaoUsuarioLogin();
    private BeanUsuario bean = new BeanUsuario();
    
    private String respuesta;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    

    public BeanUsuario getBean() {
        return bean;
    }

    public void setBean(BeanUsuario bean) {
        this.bean = bean;
    }

    /**
     * @param: Get Metodos cada uno a su respectiva variable sirve para obtener
     * su información.
     * @param: Set Metodos cada uno a su respectiva variable sirve para asignar
     * un valor a la variable.
     * @return: Los metodos get retornan la informacion contenida en la variable
     * del objeto.
     */
    //Controlador encargado de realizar la verificacion de inicio de sesion
    //a su vez ingresa la informacion de la sesion en caso de que esta sea correcta.
    public String iniciarSesion() {
        String contrasenia = bean.getContrasenia();
        System.out.println("Contraseña --->" + contrasenia);
        String correo = bean.getCorreo();
        System.out.println(correo);
        bean = dao.consultarAdminLogin(correo, contrasenia);
        if (bean != null) {
            Map session = ActionContext.getContext().getSession();

            session.put("usuarioLogeado", bean);
            session.put("idUsuario", bean.getIdUsuario());
            session.put("fechaNacimiento", bean.getPersona().getFechaNacimiento());
            session.put("edad", bean.getPersona().getEdad());
            session.put("curp", bean.getPersona().getCurp());
            session.put("rol", bean.getRol().getIdRol());

            System.out.println("Bean ---->" + bean);
            System.out.println("Rol----> " + bean.getRol().getIdRol());
            System.out.println("Edad---> " + bean.getPersona().getEdad());
            System.out.println("Nombre---> " + bean.getPersona().getNombre());

            if (bean.getRol().getIdRol() == 1) {
                return "admin";
            } else {
                session.clear();
                return "usuario";
            }
        } else {
            respuesta = "El usuario y/o contraseña son incorrectas.";
            return "NoLogeado";
        }
    }

    /**
     * Método para cerrar la sesón de usuario
     * @return SUCCESS afirma que la sesión fue cerrada correctamente
     */
    public String cerrarSesion() {
        Map sesion = ActionContext.getContext().getSession();
        sesion.clear();
        System.out.println("SESION CERRRADA");
        System.out.println(sesion);
        return SUCCESS;
    }

//    public String iniciarSesion(String correo, String contrasenia) {
//        session = ActionContext.getContext().getSession();
//        bean = dao.consultarAdminLogin(correo, contrasenia);
//        if (bean != null) {
//            session.put("idUsuario", bean.getIdUsuario());
//            session.put("fechaNacimiento", bean.getPersona().getFechaNacimiento());
//            session.put("edad", bean.getPersona().getEdad());
//            session.put("curp", bean.getPersona().getCurp());
//            session.put("rol", bean.getRol().getIdRol());
//
//            if (bean.getRol().getIdRol() == 1) {
//                return "admin";
//            } else {
//                return "usuario";
//            }
//        } else {
//            return ERROR;
//        }
//    }
}
