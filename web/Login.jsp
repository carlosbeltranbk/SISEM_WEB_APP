<%-- 
    Document   : Login
    Created on : 8/03/2019, 04:36:29 PM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <title>SISEM</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">


                    <s:form action="iniciarSesion" theme="simple" class="login100-form validate-form" method="POST">
                        <span class="login100-form-title p-b-34">
                            Inicio de Sesión
                        </span>

                        <div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
                            <input required id="exampleInputEmail" class="input100" type="email" name="bean.correo" placeholder="Correo">
                            <span class="focus-input100"></span>
                        </div>
                        <div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
                            <input minlength="8" required class="input100" type="password" name="bean.contrasenia" placeholder="Contraseña">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="btn btn-lg  btn-outline-info btn-block text-uppercase" type="submit">Iniciar Sesión</button>
                            <br>
                        </div>
                        <br>

                        <div class="alert alert-light alert-dismissible fade show" role="alert">
                            <strong><s:property value="respuesta"/></strong>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>



                        <div class="w-full text-center p-t-27 p-b-239">
                            <span class="txt1">
                                ¿Olviaste tu
                            </span>

                            <a href="olvideContra.jsp" class="txt2">
                                contraseña?
                            </a>
                            <br>
                            <br>
                            <div class="w-full text-center">
                                <br>
                                <a href="<%=context%>/registroUsuarioPersona" class="txt3">
                                    ¡Registrate!
                                </a>
                            </div>
                        </div>
                    </s:form>



                    <div class="login100-more" style="background-image: url('img/logo_inicio.png');"></div>
                </div>
            </div>
        </div>



        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <script>
            $(".selection-2").select2({
                minimumResultsForSearch: 20,
                dropdownParent: $('#dropDownSelect1')
            });
        </script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>
