/*
 * Esta clase se definen los métodos para llevar a cabo las operaciones exitosamente
 * 13/03/19
 * Carlos Eduardo Beltrán Bernal
 */
package com.utez.edu.controller.usuario;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.edu.correo.CorreoBean;
import com.utez.edu.correo.DaoCorreo;
import com.utez.edu.correo.ServicioDeCorreo;
import com.utez.edu.model.municipio.BeanMunicipio;
import com.utez.edu.model.municipio.DaoMunicipio;

import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.model.usuario.DaoUsuario;

import com.utez.edu.model.persona.BeanPersona;
import com.utez.edu.model.persona.DaoPersona;

import com.utez.edu.model.rol.BeanRol;
import com.utez.edu.model.rol.DaoRol;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author BELTRAN PC
 */
public class UsuarioAction implements ServletRequestAware{
    
    HttpServletRequest servletRequest;
    
    private BeanUsuario beanUsuario = new BeanUsuario();
    private DaoUsuario daoUsuario = new DaoUsuario();
    private DaoCorreo dao = new DaoCorreo();
    private CorreoBean bean = new CorreoBean();

    private String correoEnvio;

    private List<BeanUsuario> listaUsuarios = new ArrayList();
    private List<BeanPersona> listaPersonas = new ArrayList();
    private List<BeanRol> listaRoles = new ArrayList();
    private List<BeanMunicipio> listaMunicipios = new ArrayList();

    private List<String> listaCorreos = new ArrayList();

    private String mensaje;

    public CorreoBean getBean() {
        return bean;
    }

    /**
     * Getters y Setters de las variables y listas declaradas.
     *
     * @return
     */
    public void setBean(CorreoBean bean) {
        this.bean = bean;
    }

    public String getCorreoEnvio() {
        return correoEnvio;
    }

    public void setCorreoEnvio(String correoEnvio) {
        this.correoEnvio = correoEnvio;
    }

    public List<BeanMunicipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<BeanMunicipio> listaMunicipio) {
        this.listaMunicipios = listaMunicipios;
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public List<BeanUsuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<BeanUsuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /* ----------------- METODOS ---------------------- */
    /**
     * Dentro de este método se hace la consulta de los usuarios
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarUsuarios() {
        listaUsuarios = daoUsuario.consultarUsuarios();
        return SUCCESS;
    }

    /**
     * Dentro de este método se hace la eliminación de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String eliminarUsuario() {
        if (daoUsuario.eliminarUsuario(beanUsuario.getIdUsuario())) {
            return SUCCESS;
        } else {
            mensaje = "No se eliminó correctamente el usuario...";
            return ERROR;
        }
    }

    /**
     * Dentro de este metodo se hace la busqueda especifica de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String consultarUsuarioId() {
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoPersona daoPersona = new DaoPersona();
        DaoRol daoRol = new DaoRol();
        beanUsuario = daoUsuario.consultarUsuarioId(beanUsuario.getIdUsuario());
        listaPersonas = daoPersona.consultarPersonas(filePath);
        listaRoles = daoRol.consultarRoles();
        if (beanUsuario != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontró el usuario específico...";
            return ERROR;
        }
    }

    /**
     * Dentro de este método se hace la modificación de un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String modificarUsuario() {
        if (daoUsuario.modificarUsuario(beanUsuario)) {
            return SUCCESS;
        } else {
            mensaje = "No se modificó correctamente el usuario";
            return ERROR;
        }
    }

    /**
     * Dentro de este método se registra correctamente un registro
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String registrarUsuario() throws FileNotFoundException {
        String correoEnvio2 = daoUsuario.registrarUsuario(beanUsuario);
        beanUsuario = daoUsuario.consultarContras(correoEnvio2);
        System.out.println("Correo ------> " + beanUsuario.getCorreo());
        System.out.println("Contraseña ------> " + beanUsuario.getContrasenia());
        if (beanUsuario.getContrasenia() != null) {
            String messa = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "	   <title>Correo</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<td style=\"padding:10px 0 30px 0\">\n"
                    + "<table style=\"border:1px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                    + "<tbody>\n"
                    + "\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>	\n"
                    + "\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:10px 0 30px 0\">\n"
                    + "\n"
                    + "<table style=\"border-radius:15px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:40px 0 30px 0; color:#153643; font-size:28px; font-weight:bold; font-family:Arial,sans-serif\" align=\"center\">\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:40px 30px 40px 30px;\" bgcolor= \" #f8feff    \">\n"
                    + "	<center>	<img src=\"https://custombusinessfinance.co.uk/wp-content/uploads/2017/02/animat-lightbulb-color.gif\" class=\"CToWUd\" width=\"71\" height=\"71\">\n"
                    + "	</center>\n"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                    + "	\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "	\n"
                    + "<td style=\"color:#000000 ; font-family:Kaushan Script,sans-serif; font-size:40px;\"><center><b>Sistema de envio de \n"
                    + "contraseña - SISEM.</b></center> </td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:20px\"><center>\n"
                    + "Por medio del correo, le entregamos su contraseña: </center></td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\"><center><b>\n"
                    + "Contraseña: </b><br><strong style=\"color:#ff5050;  font-size:60px\">" + beanUsuario.getContrasenia() + "</strong></center></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 20px 20px 20px;\" bgcolor=\"#ffe1e1 \">\n"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"color:#ffffff; font-family:Kaushan Script,sans-serif; font-size:16px\" width=\"75%\">\n"
                    + "<span style=\"font-size:x-small\"><h2>No responda a este mensaje. Este correo electrónico ha sido enviado a través de un sistema automatizado, por lo que no es monitoreado ni verificado.</h2></span> </td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "";
            ServicioDeCorreo correo = new ServicioDeCorreo();
            correo.SendMail("Envio de contraseña", beanUsuario.getCorreo(), messa);
            mensaje = "Envio de contraseña exitosa";
            return SUCCESS;
        } else {
            mensaje = "Algo salío mal..";
            return ERROR;
        }
//        boolean resultado = daoUsuario.registrarUsuario(beanUsuario);
//        if (resultado) {
//            return SUCCESS;
//        } else {
//            mensaje = "No se registró correctamente el usuario";
//            return ERROR;
//        }
    }

    /**
     * Este método hace referencia para pre-cargar los datos de los beans
     * externos
     *
     * @return SUCCESS haciendo referencia a la petición exitosa
     */
    public String nuevoUsuario() {
        String filePath = this.servletRequest.getSession().getServletContext().getRealPath("/imgUser/");
        DaoPersona daoPersona = new DaoPersona();
        DaoRol daoRol = new DaoRol();
        listaPersonas = daoPersona.consultarPersonas(filePath);
        listaRoles = daoRol.consultarRoles();
        return SUCCESS;
    }

    public String registroUsuarioPersona() {
        DaoMunicipio daoMunicipio = new DaoMunicipio();
        listaMunicipios = daoMunicipio.consultarMunicipios();
        System.out.println(listaMunicipios);
        return SUCCESS;
    }

    public String registrarUsuarioPersona() throws FileNotFoundException {
        String correoEnvio = daoUsuario.registrarUsuarioPersona(beanUsuario);
        beanUsuario = daoUsuario.consultarContras(correoEnvio);
        System.out.println("Correo ------> " + beanUsuario.getCorreo());
        System.out.println("Contraseña ------> " + beanUsuario.getContrasenia());

        if (beanUsuario.getContrasenia() != null) {
            String messa = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "	   <title>Correo</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<td style=\"padding:10px 0 30px 0\">\n"
                    + "<table style=\"border:1px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                    + "<tbody>\n"
                    + "\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>	\n"
                    + "\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:10px 0 30px 0\">\n"
                    + "\n"
                    + "<table style=\"border-radius:15px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:40px 0 30px 0; color:#153643; font-size:28px; font-weight:bold; font-family:Arial,sans-serif\" align=\"center\">\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:40px 30px 40px 30px;\" bgcolor= \" #f8feff    \">\n"
                    + "	<center>	<img src=\"https://custombusinessfinance.co.uk/wp-content/uploads/2017/02/animat-lightbulb-color.gif\" class=\"CToWUd\" width=\"71\" height=\"71\">\n"
                    + "	</center>\n"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                    + "	\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "	\n"
                    + "<td style=\"color:#000000 ; font-family:Kaushan Script,sans-serif; font-size:40px;\"><center><b> SISEM </b></center> </td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:20px\"><center>\n"
                    + "Has sido registrado correctamente, tu contraseña es: </center></td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\"><center><b>\n"
                    + "Contraseña: </b><br><strong style=\"color:#ff5050;  font-size:60px\">" + beanUsuario.getContrasenia() + "</strong></center></td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "<tr>\n"
                    + "<td style=\"padding:20px 20px 20px 20px;\" bgcolor=\"#ffe1e1 \">\n"
                    + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                    + "<tbody>\n"
                    + "<tr>\n"
                    + "<td style=\"color:#4cbffd; font-family:Kaushan Script,sans-serif; font-size:16px\" width=\"75%\">\n"
                    + "<span style=\"font-size:x-small\"><h2>No responda a este mensaje. Este correo electrónico ha sido enviado a través de un sistema automatizado, por lo que no es monitoreado ni verificado.</h2></span> </td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</table>\n"
                    + "</td>\n"
                    + "</tr>\n"
                    + "</tbody>\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "";
            ServicioDeCorreo correo = new ServicioDeCorreo();
            correo.SendMail("Envio de contraseña", beanUsuario.getCorreo(), messa);
            mensaje = "Envio de contraseña exitosa";
            return SUCCESS;
        } else {
            mensaje = "Algo salío mal..";
            return ERROR;
        }
    }

    public String enviarCorreo() {

        String correo = bean.getCorreoUsuario();
        System.out.println("--- >" + correo);
//        String nom = bean.getUser().getNombre();
//        System.out.println("--- >" + nom);

        bean = dao.consularCorreo(bean.getCorreoUsuario());
        if (bean != null) {
            String clave = "";
            for (int i = 0; i < 20; i++) {
                int a = (int) (Math.random() * 8) + 1;
                clave = clave + "" + a;
            }
            bean.setCodigoRecuperacion(clave);
            bean = dao.ingresarClave(bean);
            if (bean != null) {
                String messa = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "	    <title>Correo</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "\n"
                        + "<td style=\"padding:10px 0 30px 0\">\n"
                        + "<table style=\"border:1px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                        + "<tbody>\n"
                        + "\n"
                        + "</tbody>\n"
                        + "</table>\n"
                        + "</td>	\n"
                        + "\n"
                        + "<tbody>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:10px 0 30px 0\">\n"
                        + "\n"
                        + "<table style=\"border-radius:15px solid #cccccc; border-collapse:collapse\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\">\n"
                        + "<tbody>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:40px 0 30px 0; color:#153643; font-size:28px; font-weight:bold; font-family:Kaushan Script,sans-serif\" align=\"center\">\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:40px 30px 40px 30px;\" bgcolor= \" #f8feff    \">\n"
                        + "	<center>	<img src=\"https://custombusinessfinance.co.uk/wp-content/uploads/2017/02/animat-lightbulb-color.gif\" class=\"CToWUd\" width=\"71\" height=\"71\">\n"
                        + "	</center>\n"
                        + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                        + "	\n"
                        + "<tbody>\n"
                        + "<tr>\n"
                        + "	\n"
                        + "<td style=\"color:#000000 ; font-family:Kaushan Script,sans-serif; font-size:35px\"><b>Sistema de recuperación de contraseña.</b> </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "Enhorabuena! . </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "Te registraste correctamente, tu contraseña es: <strong style=\"color:#ff5050  \">" + bean.getContraseniaUsuario() + "</strong> haz clic en el siguiente boton: </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#308eb4 ; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "</td>\n"
                        + "</tr>\n"
                        + "</tbody>\n"
                        + "</table>\n"
                        + "</td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 20px 20px 20px;\" bgcolor=\"#ffe1e1 \">\n"
                        + "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n"
                        + "<tbody>\n"
                        + "<tr>\n"
                        + "<td style=\"color:#ffffff; font-family:Kaushan Script,sans-serif:16px\" width=\"75%\">\n"
                        + "<span style=\"font-size:x-small\"><h2>No responda a este mensaje. Este correo electrónico ha sido enviado a través de un sistema automatizado, por lo que no es monitoreado ni verificado.</h2></span> </td>\n"
                        + "</tr>\n"
                        + "</tbody>\n"
                        + "</table>\n"
                        + "</td>\n"
                        + "</tr>\n"
                        + "</td>\n"
                        + "</tr>\n"
                        + "</tbody>\n"
                        + "</table>\n"
                        + "</td>\n"
                        + "</tr>\n"
                        + "</tbody>\n"
                        + "</body>\n"
                        + "</html>\n"
                        + "";
                ServicioDeCorreo correo2 = new ServicioDeCorreo();
                correo2.SendMail("Recuperación de contraseña", bean.getCorreoUsuario(), messa);
                return SUCCESS;
            } else {
                mensaje = "Algo salío mal..";
                return ERROR;
            }
        } else {
            mensaje = "Este correo no cuenta con un registro.";
            return ERROR;
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
       this.servletRequest = hsr;
    }

}
