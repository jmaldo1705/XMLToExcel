<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="plugins/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/css/dropzone.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/datatable/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/datatable/css/buttons.dataTables.min.css" rel="stylesheet" type="text/css" />
        <link href="css/index.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <br />
        <input class="form-control" id="rutaXML" type="text">
        <br />
        <button type="button" class="btn btn-primary" data-toggle="modal" id="btnBureau">Variables Bureau</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" id="btnTenant">Variables Tenant</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" id="btnTablas">Tablas</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" id="btnArboles">&Aacute;rboles</button>
        <br /><br /><br />
        <div id="divVariables"></div>
        <div id="divTablas"></div>
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
        <script src="plugins/js/jquery.min.js" type="text/javascript"></script>
        <script src="plugins/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="plugins/js/dropzone.min.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.iframe-transport.js" type="text/javascript"></script>
        <script src="plugins/fileupload/jquery.fileupload.js" type="text/javascript"></script>
        <script src="plugins/js/jquery.form.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="//cdn.rawgit.com/ashl1/datatables-rowsgroup/v1.0.0/dataTables.rowsGroup.js"></script>
        <script src="plugins/datatable/js/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/buttons.flash.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/jszip.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/pdfmake.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/vfs_fonts.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/buttons.html5.min.js" type="text/javascript"></script>
        <script src="plugins/datatable/js/buttons.print.min.js" type="text/javascript"></script>
        <script src="js/index.js" type="text/javascript"></script>
    </body>
</html>
