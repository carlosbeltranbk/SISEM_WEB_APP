<%-- 
    Document   : RegistrarCiudadano
    Created on : 8/03/2019, 08:48:27 PM
    Author     : BELTRAN PC
--%>

<%-- 
    Document   : Ciudadanos
    Created on : 8/03/2019, 08:48:00 PM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<% String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SISEM</title>
        <!-- Custom fonts for this template -->
        <link href="<%=context%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<%=context%>/css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="<%=context%>/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-danger sidebar sidebar-dark accordion" id="accordionSidebar">
                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Administrador</div>
                </a>
                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Menú</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Gestión del sistema
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-eye"></i>
                        <span>Consulta de Usuarios</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Consulta de Usuarios:</h6>
                            <a class="collapse-item" href="<%=context%>/consultarPersona">Ciudadanos</a>
                            <a class="collapse-item" href="<%=context%>/consultarMaigstrado">Magistrado</a>
                            <a class="collapse-item" href="<%=context%>/consultarFiscalias">Fiscalias</a>
                            <a class="collapse-item" href="<%=context%>/consultarSindico">Sindico Municipal</a>
                            <a class="collapse-item" href="<%=context%>/consultarSecretaria">Sría. de Estudio y Cuenta</a>
                            <a class="collapse-item" href="<%=context%>/consultarPleno">Pleno</a>
                            <a class="collapse-item" href="<%=context%>/consultarAcuerdo">Secretaria de Acuerdos</a>
                            <a class="collapse-item" href="<%=context%>/consultarOficialia">Oficialia de Partes</a> 
                            <a class="collapse-item" href="<%=context%>/consultarUsuarios">Usuarios</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo2" aria-expanded="true" aria-controls="collapseTwo2">
                        <i class="fas fa-fw fa-ad"></i>
                        <span>Información Adicional</span>
                    </a>
                    <div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Consulta de Usuarios:</h6>
                            <a class="collapse-item" href="<%=context%>/consultarDemandas">Demandas</a>                          
                            <a class="collapse-item" href="<%=context%>/consultarAudiencias">Audiencias</a>                           
                            <a class="collapse-item" href="<%=context%>/consultarPersonaDemanda">Demandas de Ciudadanos</a>
                           
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-user-plus"></i>
                        <span>Nuevo Registro</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Menú:</h6>
                             <a class="collapse-item" href="<%=context%>/nuevoUsuarioAdmin">Registrar Persona</a>
                            <a class="collapse-item" href="<%=context%>/nuevaFiscalia">Fiscalia</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>



                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                           


                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Carlos Beltrán</span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    
                                    <a class="dropdown-item"  href="<%=context%>/cerrarSesion" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">Gestión de Usuarios</h1>
                        <p class="mb-4">Dentro de esta ventana se vizualizaran las tablas con los datos correspondientes
                            de los usuarios seleccionados. <a target="_blank" href="https://datatables.net">CodeSoft</a>.</p>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Usuario a registrar:</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <form action="registrarUsuario" method="POST">
                                        <div class="form-row">

                                            <div class="form-group col-md-3">
                                                <label for="correo">Correo de la persona: </label>
                                                <input  type="text" class="form-control" id="correo" name="BeanUsuario.correo" >
                                            </div>

                                            <div class="form-group col-md-6">
                                                <label for="persona">Persona: </label>
                                                <select class="form-control" name="BeanUsuario.persona.idPersona">
                                                    <option value="">Seleccione...</option>
                                                    <s:iterator value="listaPersonas" status="stat" var="lista">
                                                        <option value="<s:property value="idPersona"/>"><s:property value="nombre"/> <s:property value="primeroApellido"/> <s:property value="segundoApellido"/></option>
                                                    </s:iterator>
                                                </select>
                                            </div>

                                            <div class="form-group col-md-6">
                                                <label for="rol">Rol del usuario: </label>
                                                <select class="form-control" name="BeanUsuario.rol.idRol">
                                                    <option value="">Seleccione...</option>
                                                    <s:iterator value="listaRoles" status="stat" var="lista">
                                                        <option value="<s:property value="idRol"/>"><s:property value="nombreRol"/></option>
                                                    </s:iterator>
                                                </select>
                                            </div>

                                            <div class="form-group col-md-4">
                                                <label for="estado">Estado del usuario: </label>
                                                <select disabled class="form-control" name="BeanUsuario.estado">
                     
                                                    <option value="true">Activa</option>
                    
                                                </select>
                                            </div>

                                            <br>
                                            <div class="form-group col-md-6">
                                                <input type="submit" class="btn btn-success" value="Registrar" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; CodeSoft 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

       <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesión</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">¿Estás seguro de cerrar sesión?</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                        <a class="btn btn-primary" href="<%=context%>/cerrarSesion">Salir</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="<%=context%>/vendor/jquery/jquery.min.js"></script>
        <script src="<%=context%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="<%=context%>/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="<%=context%>/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="<%=context%>/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="<%=context%>/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="<%=context%>/js/demo/datatables-demo.js"></script>

    </body>
</html>

