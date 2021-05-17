<%-- 
    Document   : olvideContra
    Created on : 14/03/2019, 11:51:16 PM
    Author     : BELTRAN PC
--%>

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
                                            <h1 class="h4 text-gray-900 mb-2">¿Olvidaste tu contraseña?</h1>
                                            <p class="mb-4">No hay problema, ingresa tu correo electronico y te enviaremos un correo para
                                                restaurar tu contraseña</p>
                                        </div>
                                        <form class="user" action="enviarCorreo" method="POST">
                                            <div class="form-group">
                                                <input required type="email" class="form-control form-control-user" name="bean.correoUsuario" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa correo electronico...">
                                            </div>
                                            <input type="submit" value="Enviar" class="btn btn-warning btn-user btn-block">
                                            
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
