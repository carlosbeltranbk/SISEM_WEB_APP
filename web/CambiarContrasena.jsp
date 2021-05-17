<%-- 
    Document   : olvideContra
    Created on : 14/03/2019, 11:51:16 PM
    Author     : BELTRAN PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SISEM</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body class="bg-gradient-warning">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block">
                                    <div class="card-body">
                                        <div class="col-md-12 ">
                                            <center><img src="img/nuevo.png" class="img-responsive"></center>
                                            <div class="h-30"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-2">SISEM</h1>
                                        </div>
                                        <form method="POST" action="cambiarContrasenaPass">
                                            <input type="hidden" name="bean.codigoRecuperacion" value="<s:property value="bean.codigoRecuperacion"/>" 
                                                   <h2 class="text-center">Cambiar contraseña</h2>       
                                            <div class="form-group">
                                                <label for="password">Nueva contraseña: </label>
                                                <input required minlength="8" class="form-control" type="password" name="bean.contraseniaUsuario"  placeholder="Contraseña:" /></br>
                                            </div>
                                            <div class="form-group">
                                                <label for="password">Confirmar contraseña: </label>
                                                <input required minlength="8" class="form-control" type="password" name="bean.contra1Alter" placeholder="Contraseña:" /></br>
                                            </div>
                                            <div class="form-group">
                                                <input  type="submit"  class="btn btn-success" value="Cambiar contraseña"/>
                                            </div> 
                                            <h5 class="d-flex justify-content-center links"><s:property value="mensaje"/></h5>
                                        </form>
                                        <hr>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>
