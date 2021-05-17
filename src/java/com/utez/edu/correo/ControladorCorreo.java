package com.utez.edu.correo;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author jtc_2
 */
public class ControladorCorreo {

    private DaoCorreo dao = new DaoCorreo();
    private CorreoBean bean = new CorreoBean();
    private String mensaje;

    public CorreoBean getBean() {
        return bean;
    }

    public void setBean(CorreoBean bean) {
        this.bean = bean;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String cambiarContrasena() {
        System.out.println(bean.getCodigoRecuperacion());
        bean = dao.consularCorreoUserId(bean.getCodigoRecuperacion());
        if (bean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String cambiarContrasenaPass() {
        String texto;
        if (bean.getContraseniaUsuario().equals("") && bean.getContra1Alter().equals("")) {
            mensaje = "No puedes dejar espacios en blanco";
            return ERROR;
        }
        if (bean.getContraseniaUsuario().equals(bean.getContra1Alter())) {
            boolean resultado = dao.cambiarPass(bean);
            if (resultado) {
                mensaje = "Tu contraseña se cambio exitosamente";
                return SUCCESS;

            } else {
                return ERROR;
                
            }
        }
        mensaje = "La constraseñas no coinciden.";
        texto = bean.getContraseniaUsuario();
                System.out.println();
        return ERROR;
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
                        + "<td style=\"color:#000000 ; font-family:Kaushan Script,sans-serif; font-size:35px\"><b>¿Olvidaste tu contraseña? ¡No hay problema!</b> </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "Recibimos tu solicitud para restablecer tu contraseña.. </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#000000; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "Si solicitaste restablecer tu contraseña para <strong style=\"color:#000000  \"></strong> haz clic en el siguiente boton: </td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td style=\"padding:20px 0 30px 0; color:#308eb4 ; font-family:Kaushan Script,sans-serif; font-size:16px\">\n"
                        + "<form action=\"http://31.220.62.60:8084/SISEM_UTEZ/cambiarContrasena\" method=\"POST\">\n"
                        + "<input value=\"" + bean.getCodigoRecuperacion()+ "\" name=\"bean.codigoRecuperacion\" type=\"hidden\"/>\n"
                        + " <input type=\"submit\" value=\"Restablecer contraseña\" style=\"background-color: #ff0000; padding:12px 28px; color:#ffffff; font-family:Kaushan Script,sans-serif; border-radius:15px\"> </form>\n"
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
}
