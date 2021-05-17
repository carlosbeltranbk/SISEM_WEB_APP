<%-- 
    Document   : olvideContra
    Created on : 14/03/2019, 11:51:16 PM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<% String context = request.getContextPath();%>
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

    <body class="bg-gradient-danger">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-2">REGISTRATE</h1>
                                        </div>
                                        <form class="user" action="registrarUsuarioPersona" method="POST" enctype="multipart/form-data">
                                            <div class="form-group">
                                                <input required type="text" class="form-control form-control-user" name="BeanUsuario.persona.nombre" id="" aria-describedby="" placeholder="Nombre Completo..." title="Únicamente letras">
                                            </div>

                                            <div class="form-group">
                                                <input required type="text" class="form-control form-control-user" name="BeanUsuario.persona.primeroApellido" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa tu Apellido Paterno..." title="Únicamente letras">
                                            </div>

                                            <div class="form-group">
                                                <input required type="text" class="form-control form-control-user" name="BeanUsuario.persona.segundoApellido" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa tu Apellido Materno..." title="Únicamente letras">
                                            </div>

                                            <div class="form-group">
                                                <input required type="date" class="form-control form-control-user" name="BeanUsuario.persona.fechaNacimiento" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa tu Fecha de Nacimiento..." data-date-format="aaaa/mm/dd" min="1000-01-01" max="2001-12-31" title="Debes ser mayor de edad">
                                               
                                            </div>

                                            <div class="form-group">
                                                <input required type="text" class="form-control form-control-user" name="BeanUsuario.persona.curp" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa tu CURP..." maxlength="18">
                                            </div>

                                            <div class="form-group col-md-6">
                                                <label for="municipio">Municipio: </label>
                                                <select required class="form-control" name="BeanUsuario.persona.municipio.idMunicipio">
                                                    <option value="">Seleccione...</option>
                                                    <s:iterator value="listaMunicipios" status="stat" var="lista">
                                                        <option value="<s:property value="idMunicipio"/>"><s:property value="nombreMunicipio"/></option>
                                                    </s:iterator>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <input required type="email" class="form-control form-control-user" name="BeanUsuario.correo" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Ingresa tu correo electrónico...">
                                            </div>

                                            <div class="form-group">
                                                <strong><label>Carga 2 Archivos Oficiales (fotografía de INE, pasaporte, cartilla militar, etc.)</label></strong>              
                                                <br>
                                                <input required id="imagenn" aria-describedby="" onchange="getName()" name="BeanUsuario.persona.documentacion1" type="file" >
                                                <input type="hidden"  name="BeanUsuario.persona.foto1" required id="nombreArchivoo" aria-describedby="">
                                                
                                                <input required id="imagen" aria-describedby="" onchange="getName1()" name="BeanUsuario.persona.documentacion2" type="file">
                                                <input type="hidden"  name="BeanUsuario.persona.foto2" required id="nombreArchivo" aria-describedby="">
                                                <br>
                                                <br>
                                                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                                    <strong>¡Importante!</strong> La identificación oficial 
                                                    tendrá que tener fotografía, estar en formato JPG, y debe pesar menos de 2.30 MB.
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>               
                                            </div>
                                            <br>
                                            <input onclick="return confirmarRegistrarUser()" type="submit" value="Enviar" class="btn btn-outline-success btn-user btn-block">       
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
        
        <!-- Custom scripts for this template -->
        <script src="js/agency.min.js"></script>
        <script src="js/main.js"></script> 


       <script>
            function getName() {
                var name = "he";
                var nombre = "";
                var x = document.getElementById("imagenn").value.toString().split("\\");
                var ss = x[2];
                for (var i = 0; i < 20; i++) {
                    var m = Math.floor(Math.random() * 100) + 1;
                    name = m.toString();
                    nombre = nombre.concat(name);
                }
                ss = nombre.concat(ss);
                alert(ss);
                document.getElementById("nombreArchivoo").value = ss;
            }
        </script>

        <script>
            function getName1() {
                var name = "he";
                var nombre = "";
                var x = document.getElementById("imagen").value.toString().split("\\");
                var ss = x[2];
                for (var i = 0; i < 20; i++) {
                    var m = Math.floor(Math.random() * 100) + 1;
                    name = m.toString();
                    nombre = nombre.concat(name);
                }
                ss = nombre.concat(ss);
                alert(ss);
                document.getElementById("nombreArchivo").value = ss;
            }
        </script>


    </body>

</html>
