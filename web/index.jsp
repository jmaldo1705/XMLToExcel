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
        <link href="css/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form action="IndexServlet1?accion=1" class="dropzone dropzone-file-area" id="my-dropzone" style="width: 500px;">
            <center>
                <h3 class="sbold">Examina XML</h3>
                <p>Arrastra XML o click para seleccionar uno</p>
            </center>
        </form>
        <br />
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalSubmit">Cargue Manual</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalForm">Digita XML</button>
        <div class="modal fade" id="modalSubmit" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Carga XML</h4>
                    </div>
                    <div class="modal-body">
                        <form id="data" method="post" action="FileUploadServlet" enctype="multipart/form-data">
                            <input id="fileupload" type="file" name="file" data-url="FileUploadServlet">
                            <br />
                            <button type="button" id="btnSubmit" class="btn btn-primary btn-sm">Enviar</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal" id="modalForm" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Copia XML</h4>
                    </div>
                    <div class="modal-body">
                        <textarea id="rutaXML" style="width: 97%; height: 350px;"></textarea>
                        <br /><br />
                        <button type="button" id="btnSubmit2" class="btn btn-primary btn-sm">Enviar</button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="plugins/js/jquery.min.js" type="text/javascript"></script>
        <script src="plugins/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="plugins/js/dropzone.min.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.iframe-transport.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.fileupload.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.form.js" type="text/javascript"></script>
        <script src="js/index.js" type="text/javascript"></script>
    </body>
</html>
