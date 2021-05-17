<%-- 
    Document   : Inicio
    Created on : 8/03/2019, 04:36:17 PM
    Author     : BELTRAN PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SISEM</title>

        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">
        <link href="css/stylish-portfolio.min.css" rel="stylesheet">
    </head>
    <body id="page-top">

        <!-- Navigation -->
        <a class="menu-toggle rounded" href="#">
            <i class="fas fa-bars"></i>
        </a>
        <nav id="sidebar-wrapper" style="color:#fc0000">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a class="js-scroll-trigger" href="#page-top">Inicio</a>
                </li>
                <li class="sidebar-nav-item">
                    <a class="js-scroll-trigger" href="#inicia_sesion">Iniciar Sesión</a>
                </li>
                <li class="sidebar-nav-item">
                    <a class="js-scroll-trigger" href="<%=context%>/registroUsuarioPersona">Registrate!</a>
                </li>
                <li class="sidebar-nav-item">
                    <a class="js-scroll-trigger" href="#services">¿Qué servicios ofrecemos?</a>
                </li>
                <li class="sidebar-nav-item">
                    <a class="js-scroll-trigger" href="#portfolio">¿Quienes nos integran?</a>
                </li>
            </ul>
        </nav>

        <!-- Header -->
        <header class="masthead d-flex">
            <div class="container text-center my-auto">
                <h1 class="mb-1" style="color:#ffffff">SISTEMA DE SEGUIMIENTO DE TRÁMITES Y MULTAS</h1>
                <h3 class="mb-5" style="color:#ffffff">
                    <em>SISEM</em>
                </h3>

            </div>
            <div class="overlay"></div>
        </header>

        <!-- About -->
        <section class="content-section bg-light" id="inicia_sesion">
            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-10 mx-auto">
                        <h2>¿Ya estás registrado?</h2>
                        <p class="lead mb-5">Inicia sesión con nostros...!
                            <a href="https://unsplash.com/" style="color:#f41c1c">CodeSoft</a>!</p>
                        <a class="btn btn-danger btn-xl js-scroll-trigger" href="Login.jsp">Iniciar Sesión</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Services -->
        <section class="content-section bg-danger text-white text-center" id="services">
            <div class="container">
                <div class="content-section-heading">
                    <h3  style="color:#ffffff">Servicios</h3>
                    <h2 class="mb-5">¿Qué ofrece la aplicación?</h2>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <span class="service-icon rounded-circle mx-auto mb-3">
                            <i class="icon-screen-smartphone"></i>
                        </span>
                        <h4>
                            <strong>Generar una demanda</strong>
                        </h4>
                        <p class="text-faded mb-0">¿Te multaron sin justificación alguna?... Te podemos ayudar</p>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-lg-0">
                        <span class="service-icon rounded-circle mx-auto mb-3">
                            <i class="icon-pencil"></i>
                        </span>
                        <h4>
                            <strong>Subir evidencias</strong>
                        </h4>
                        <p class="text-faded mb-0">Podrás subir fotografías para comprobar la apelación de tu multa</p>
                    </div>
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-0">
                        <span class="service-icon rounded-circle mx-auto mb-3">
                            <i class="icon-like"></i>
                        </span>
                        <h4>
                            <strong>Mostrar Seguimiento de Demanda</strong>
                        </h4>
                        <p class="text-faded mb-0">A través de notificaciones a tu teléfono móvil,
                            recibirás el seguimiento de tu demanda</p>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <span class="service-icon rounded-circle mx-auto mb-3">
                            <i class="icon-mustache"></i>
                        </span>
                        <h4>
                            <strong>Apelar Multas o Sanciones</strong>
                        </h4>
                        <p class="text-faded mb-0">Podrás apelar una multa de manera legal</p>
                    </div>
                </div>
            </div>
        </section>


        <!-- Portfolio -->
        <section class="content-section" id="portfolio">
            <div class="container">
                <div class="content-section-heading text-center">
                    <h3 style="color:#f41c1c">SISEM</h3>
                    <h2 style="color:#f41c1c" class="mb-5">¿Quienes nos conforman?</h2>
                </div>
                <div class="row no-gutters">
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="#">
                            <span class="caption">
                                <span class="caption-content">
                                    <h2>Magistrado</h2>
                                    <p class="mb-0">Tiene como función el administrar justicia dictando el fallo de acuerdo a la ley.</p>
                                </span>
                            </span>
                            <img class="img-fluid" src="img/magistrado.jpeg" alt="">
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="#">
                            <span class="caption">
                                <span class="caption-content">
                                    <h2>Secretaría de estudio y cuenta</h2>
                                    <p class="mb-0">Se realizan los últimos análisis para pasar el caso a la última sección que es en el pleno.</p>
                                </span>
                            </span>
                            <img class="img-fluid" src="img/estudio.jpg" alt="">
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="#">
                            <span class="caption">
                                <span class="caption-content">
                                    <h2>Pleno</h2>
                                    <p class="mb-0">Dentro del pleno el cual se conforma por 5 magistrados, se dicta la sentencia final que concluirá con el proceso del caso que se esté ejerciendo en su momento.</p>
                                </span>
                            </span>
                            <img class="img-fluid" src="img/pleno3.jpg" alt="">
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="#">
                            <span class="caption">
                                <span class="caption-content">
                                    <h2>Secretaría de Acuerdos</h2>
                                    <p class="mb-0">Dentro de esta sección, se decreta la fecha del juicio y el periodo aprobatorio donde se genera la lista con la documentación aceptada y se pasa a la Secretaría de estudio y cuenta.</p>
                                </span>
                            </span>
                            <img class="img-fluid" src="img/resta1.jpg" alt="">
                        </a>
                    </div>
                    <div class="col-lg-6">
                        <a class="portfolio-item" href="#">
                            <span class="caption">
                                <span class="caption-content">
                                    <h2>Oficialía de partes</h2>
                                    <p class="mb-0">Se encarga de recibir y analizar los documentos de la demanda, para así, comenzar con el análisis de “Prevenir, Radicar o Desechar”.</p>
                                </span>
                            </span>
                            <img class="img-fluid" src="img/partes.jpg" alt="">
                        </a>
                    </div>
                </div>
            </div>
        </section>



        <!-- Footer -->
        <footer class="footer text-center">
            <div class="container">
                <p style="color:#f41c1c">Copyright &copy; CodeSoft 2019</p>
            </div>
        </footer>

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded js-scroll-trigger" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/stylish-portfolio.min.js"></script>

    </body>
</html>
