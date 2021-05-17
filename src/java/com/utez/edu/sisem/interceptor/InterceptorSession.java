/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.sisem.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.utez.edu.model.usuario.BeanUsuario;
import java.util.Map;

/**
 *
 * @author BELTRÁN-PC
 */
public class InterceptorSession implements Interceptor {

    //Método encargado de destruir las sesiones creadas.
    @Override
    public void destroy() {
        System.out.println(" Destruyendo interceptor.. ");
    }

    @Override
    public void init() {
        System.out.println(" Construyendo interceptor.. ");

    }

    //Método encargado de interceptar el rol de las sesiones iniciadas
    @Override
    public String intercept(ActionInvocation ai) throws Exception {
       String respuesta = "";
        try {
            Map sesion = ActionContext.getContext().getSession();
            BeanUsuario usuario = (BeanUsuario) sesion.get("usuarioLogeado");
            // Obtener el action que se ejecuta
//            String actionEjecutandose = ActionContext.getContext().get(ActionContext.ACTION_NAME).toString();
            System.out.println("Usuario: ->>>>>>>>>>>>>>>>>>>>>>>> "+usuario);
            if (usuario != null) {
                 respuesta = ai.invoke();
            } else {
                  respuesta = "NoLogeado";
            }
        } catch (Exception e) {
            System.out.println("-> " + e);
            respuesta = "error";
        }
        return respuesta;
    }

    }


