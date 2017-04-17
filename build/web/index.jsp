<%-- 
    Document   : index
    Created on : 17/04/2017, 09:52:14 AM
    Author     : jmaldonadoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="plugins/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/css/dropzone.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form action="IndexServlet1?accion=1" class="dropzone dropzone-file-area" id="my-dropzone" style="width: 500px; margin-top: 50px;">
            <center>
                <h3 class="sbold">Examina XML</h3>
                <p>Arrastra XML o click para seleccionar uno</p>
            </center>
        </form>
        <script src="plugins/js/jquery.min.js" type="text/javascript"></script>
        <script src="plugins/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="plugins/js/dropzone.min.js" type="text/javascript"></script>
        <script src="js/index.js" type="text/javascript"></script>
    </body>
</html>
