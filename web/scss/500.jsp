<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/estilos.css"></script>

<!------ Include the above in your HEAD tag ---------->
<%String context = request.getContextPath();%>
<script>
    h1.{
        font-size: 250px;
    }
</script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body background="fondo999.jpg">
         <br>
        
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
                    <br>
                <br>
                        <font size=20>ERROR 500</font>
                   
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <br><br><br><br><br><br><br><br>
                    <img src="/nuevo.png" style="width:300px;height:300px;" class="img-fluid"/>
                    <br><br><br>
                    <h1>Algo fallo en el sistema. </h1>
                    <br>
                    <h1><a href="<%=context%>/index" class="btn btn-primary">Regresa al inicio.</a></h1>
                </div>
            </div>
            <br><br>
            
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>